package javaconcepts.completablefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/*
 * 
 * Be default, the async tasks are run in the Common Fork/join pool 
 * CF helps:
 * Running task asynchrnously, chaining tasks, creating pipeline of tasks
 * combine and compose them
 * run them asynchronously
 */
public class CompletableFuturePS {

	public static void main(String[] args) {
		System.out.println("main start");
		mapReduceChaining();
		mapReduceChainingDBAsync();
		pipelinewhenBothTaskCompletes();
		pipelinewhenEitherTaskCompletes();
		pipeLineNTasks();
		exceptionHandling();
		System.out.println("main end");
	}
	
	static void runnableTest() {
		Runnable r = ()->System.out.println("Hello CF from Runnable!");
		CompletableFuture<Void> cf = CompletableFuture.runAsync(r);
		System.out.println("runnableTest end");
	}
	
	//Note Completable future doesn't work with Callable. It works with Supplier
	static void supplierTest() {
		Supplier<String> s = ()->"Hello CF returned from Supplier!";
		CompletableFuture<Void> cf = CompletableFuture.supplyAsync(s).thenAccept(System.out::println);
		System.out.println("supplierTest end");
	}
	
	static void mapReduceChaining() {
		Supplier<List<Integer>> userIds = () -> List.of(1, 2, 3);
		CompletableFuture.supplyAsync(userIds)
		                 .thenApply(ids -> readFromDB(ids))
		                 .thenAccept(users -> System.out.println("count of users : " + users.size()));
	}
	
	/*
	 * Note the above readFromDB is synchrnonous call 
	 * What if db returns CompletableFuture<List<User>> instead of List<User> i.e. if db call is non blocking/async 
	 * then we cannot use thenApply instead we should use thenCompose
	 * 
	 * therefore completablefuture are composable
	 */
	static void mapReduceChainingDBAsync() {
		Supplier<List<Integer>> userIds = () -> List.of(1, 2, 3);
		CompletableFuture.supplyAsync(userIds)
		                 .thenCompose(ids -> readFromDBAsync(ids))
		                 .thenAccept(users -> System.out.println("count of users async : " + users.size()));
	}
	
	/*
	 * Task pipeline:
	 * T1 and T2 both completes and then execute T3 i.e. T1&T2 => T3
	 */
	static void pipelinewhenBothTaskCompletes() {
		
		CompletableFuture<User> user = CompletableFuture.completedFuture(new User(1));
		CompletableFuture<UserEmail> userEmail  = CompletableFuture.completedFuture(new UserEmail(1, "test@email"));
		
		//Executes BiConsumer after both the CFs gets executed
		CompletableFuture<Void> cf = 
				user.thenAcceptBoth(userEmail, (u,e)->System.out.println(u.id + " # " + e.email));
		
		CompletableFuture<String> emailId  = CompletableFuture.completedFuture("another@email");
		//Executes BiFunction after both the CFs gets executed
		CompletableFuture<UserEmail> cf2 = 
				user.thenCombine(emailId, (u,e)-> new UserEmail(u.id, e));
		System.out.println("UserEmail " + cf2.join().email);
		System.out.println("pipelinewhenBothTaskCompletes end");
	}
	
	/*
	 * Task pipeline:
	 * T1 or T2 completes and then execute T3 i.e. T1||T2 => T3
	 * When either completes you can execute Runnable, Consumer, Function
	 * In that case both cfs return objects of same type. 
	 * This can be used when data is being fetched from two db servers in parallel and once either
	 * db executes then do some processing
	 */
	static void pipelinewhenEitherTaskCompletes() {
		
		CompletableFuture<User> userFromDB1 = CompletableFuture.completedFuture(new User(1));
		CompletableFuture<User> userFromDB2 = CompletableFuture.completedFuture(new User(2));
		
		CompletableFuture<Void> cf1 = userFromDB1.runAfterEither(userFromDB2, ()->System.out.println("Runnable done"));
		CompletableFuture<User> cf2 = userFromDB1.applyToEither(userFromDB2, Function.identity());
		cf2.thenAccept(System.out::println);
		CompletableFuture<Void> cf3 = userFromDB2.acceptEither(userFromDB1, System.out::println);
		System.out.println("pipelinewhenEitherTaskCompletes end");
	}
	
	/*
	 * Execute when all or either one completes 
	 */
	static void pipeLineNTasks() {
		CompletableFuture<User> u1 = CompletableFuture.completedFuture(new User(1));
		CompletableFuture<User> u2 = CompletableFuture.completedFuture(new User(1));
		CompletableFuture<User> u3 = CompletableFuture.completedFuture(new User(1));
		
		CompletableFuture.allOf(u1,u2,u3).thenRun(()->System.out.println("Done"));
		CompletableFuture.anyOf(u3,u2,u1).thenAccept(System.out::println);
		System.out.println("pipeLineNTasks end");
	}
	
	/*
	 * Exceptional handling through 
	 * exceptionally(ex -> return same type of completableFuture) 
	 * whenComplete(BiConsumer<ob, ex>)  
	 * handle(BiFunction<ob,ex> func)
	 */
	
	static void exceptionHandling() {
		CompletableFuture<List<User>> cf = 
				CompletableFuture.supplyAsync(()->List.of(1,2,3))
				.thenApply(l -> readFromDBWithException(l))
				.whenComplete((l, ex) -> {
					if(l != null) {
						System.out.println("User list size : " + l.size());
					} else {
						System.out.println("zzzzzzzzz");
					}
				});
		//System.out.println("users  = " + cf.join()); Calling this method throws exception
		System.out.println("exceptionHandling end");
	}
	
	static class User{ int id; User(Integer id){this.id = id;}
	  @Override
	  public String toString() {
		  return "User id : " + id;
	  }
	}
	static class UserEmail {
		int userId;
		String email;
		UserEmail(int userId, String email) {
			this.userId = userId; this.email = email;
		}
	}
	static List<User> readFromDB(List<Integer> ids) { 
		return ids.stream().map(User::new).collect(Collectors.toList());};
		
		static List<User> readFromDBWithException(List<Integer> ids) { 
			throw new RuntimeException("Random exception");
		}
		
	static CompletableFuture<List<User>> readFromDBAsync(List<Integer> ids) { 
		CompletableFuture<List<User>> cf = new CompletableFuture<>();
		cf.complete(ids.stream().map(User::new).collect(Collectors.toList()));
		return cf;
	}
}
