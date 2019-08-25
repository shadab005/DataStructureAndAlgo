package javaconcepts.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * In Java 8, the CompletableFuture class was introduced. Along with the Future interface, it also implemented the CompletionStage interface
 * About 50 different methods for composing, combining, executing asynchronous computation steps and handling errors.
 * 
 * CompletionStage is an Interface which represent a task or stage which can be treated as a stand-alone tasks 
 * that can be executed in isolation.
 * 
 * Limitation of Java Future: 
 * 1. Can't manually complete it.
 * 2. Can't chain future.
 * 3. Combining multiple Futures together is not possible
 * 	
 * Methods of CompletableFuture can be broadly divided in two categories. 1. Non Async 2. Async
 * Non Async methods, will get executed by the thread in which this stage is running or 
 * any other thread in which the other stages, which called this stage is running.
 * Async Methods, the stages are executed by having threads from ForkJoinPool.commonPool().
 * CompletableFuture Async methods have a variant where you can specify these custom Executors.
 * 
 *  ref:
 *  https://www.baeldung.com/java-completablefuture
 *  --loot
 *  https://thepracticaldeveloper.com/2018/02/24/differences-between-completablefuture-future-and-streams/#Synchronous_tasks_in_Java
 *  https://kicsikrumpli.github.io/today-i-learned/til/completablefuture/2018/01/30/completable-future-cheat-sheet.html
 */
public class CompletableFutureLearning {

	public static void main(String[] args) throws InterruptedException, ExecutionException{
		//Several use case
		//-- useAsSimpleFuture();
		//-- useCompletableFutureWithEncapsulatedLogic();
		//Used when result of one is needed for further computation
		 useChainWithThenAcceptThatTakesConsumer(); //doubt
		//If you neither need the value of the computation nor want to return some value at the end of the chain
		//-- useChainWithThenRunThatTakesRunnable();
		//-- useCombiningFutures();
		//-- useDifferenceBetweenThenApplyAndThenCompose();
		//-- useAsyncVariantOfThenAccept();
		//-- useRunningMultipleFuture();
		//-- useHandlingErrors();
		//-- useAsyncMethod();
		//-- useOperationOnEitherCompletionStageComplete();
		//-- useOperationAfterBothExample();
		//-- useAnyCompleteStateComplete();
		//-- useAllCompleteStateComplete();
	}

	public static void useAsSimpleFuture() throws InterruptedException, ExecutionException {
		Future<String> completableFuture = calculateAsync();
		//If you already know the result of a computation, you can use the static completedFuture method 
		//with an argument that represents a result of this computation. Then the get method of the Future will never block,
		//immediately returning this result instead.
		//Future<String> completableFuture =  CompletableFuture.completedFuture("Hello");
		String result = completableFuture.get();
		System.out.println(result.equals("Hello"));
	}
	
	private static Future<String> calculateAsync() throws InterruptedException {
	    CompletableFuture<String> completableFuture 
	      = new CompletableFuture<>();
	 
	    Executors.newCachedThreadPool().submit(() -> {
	        Thread.sleep(500);
	        //If not already completed, sets the value returned and related methods to the given value.
	        completableFuture.complete("Hello");
	        //Alternatively, if you don't want to complete, you can also cancel it. This method receives a boolean argument mayInterruptIfRunning, 
	        //but in the case of CompletableFuture it has no effect, as interrupts are not used to control processing for CompletableFuture.
	        //When we block on the result using the Future.get() method, it throws CancellationException if the future is canceled:
	        //completableFuture.cancel(false);
	        return null;
	    });
	    return completableFuture;
	}

    public static void useCompletableFutureWithEncapsulatedLogic() throws InterruptedException, ExecutionException {
    	//Providing supplier here
    	CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello From Supplier");
    	System.out.println(future.get());
    	//Providing computation logic in Runnable
    	CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> System.out.println("Hello From Runnable"));
    	System.out.println("Here I am");
    	future2.get();
    }
    


	public static void useChainWithThenAcceptThatTakesConsumer() throws InterruptedException, ExecutionException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
			sleep(1000); //uncomment this and check
			System.out.println(Thread.currentThread().getName() + " yyy");
			return "Hello";
		});
		CompletableFuture<Void> future = completableFuture.thenAccept(s -> {
			try {
				System.out.println(Thread.currentThread().getName() + " zzz");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Computation returned: " + s);
			});
		//Thread.sleep(1000);
		//future.get();
		System.out.println("Done");
		System.out.println(Thread.currentThread().getName() + " www");
		future.get();
	}
	public static void useChainWithThenRunThatTakesRunnable() throws InterruptedException, ExecutionException  {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<Void> future = completableFuture.thenRun(() -> System.out.println("Computation finished"));
		future.get();
	}
	
	public static void useCombiningFutures() throws InterruptedException, ExecutionException {
	// The best part of the CompletableFuture API is the ability to combine CompletableFuture instances in a chain of computation steps.
	//The result of this chaining is itself a CompletableFuture that allows further chaining and combining. 
	//In the following example we use the thenCompose method to chain two Futures sequentially.
	    CompletableFuture<String> completableFuture  = 
			CompletableFuture.supplyAsync(() -> "Hello")
			.thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World From then Compose"));
	    System.out.println(completableFuture.get());
		//The thenCompose method together with thenApply implement basic building blocks of the monadic pattern
	    //They closely relate to the map and flatMap methods of Stream and Optional classes also available in Java 8.
	    //Both methods receive a function and apply it to the computation result, but the thenCompose (flatMap) method 
	    //receives a function that returns another object of the same type. This functional structure allows composing
	    //the instances of these classes as building blocks.
	    
	    //If you want to execute two independent Futures and do something with their results, 
	    //use the thenCombine method that accepts a Future and a Function with two arguments to process both results:
	    CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> "Hello") 
	    		.thenCombine(CompletableFuture.supplyAsync(() -> " World From Then Combine"), (s1, s2) -> s1 + s2);
	    System.out.println(completableFuture2.get());
	    
	    //A simpler case is when you want to do something with two Futures‘ results, 
	    //but don’t need to pass any resulting value down a Future chain. The thenAcceptBoth method is there to help:
	    CompletableFuture<Void> completableFuture3 = CompletableFuture.supplyAsync(() -> "Hello")
	    		  .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World From Then AcceptBoth"),
	    		    (s1, s2) -> System.out.println(s1 + s2));
	    completableFuture3.get();
	    
	}
	
	public static void useDifferenceBetweenThenApplyAndThenCompose(){
		//You would use thenCompose when you have an operation that returns a CompletionStage and thenApply 
		//when you have an operation that doesn't return a CompletionStage
		
		//thenApply is used if you have a synchronous mapping function.
		CompletableFuture<Integer> future =  CompletableFuture.supplyAsync(() -> 1)
			                     .thenApply(x -> x+1);
		//thenCompose is used if you have an asynchronous mapping function (i.e. one that returns a CompletableFuture). 
		//It will then return a future with the result directly, rather than a nested future
		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 1)
			                     .thenCompose(x -> CompletableFuture.supplyAsync(() -> x+1));
		
		//Basically then compose is used when we have 2 asynchronous operation that needs to be executed sequentially
		//Object db = new Object(); // pretend this connects to a database
	    //CompletionStage<Object> recordInserted = insert(db).thenCompose(id -> get(id));
	}
	private static CompletionStage<String> insert(Object database) {
	    throw new UnsupportedOperationException();
	}

	private static CompletionStage<Object> get(String id) {
	    throw new UnsupportedOperationException();
	}
	
	public static void useAsyncVariantOfThenAccept() {

		/*
		Imagine for a moment that you have an application that allows users to register themselves and upon registration 
		they will receive a confirmation email to confirm their account.
		You don't want the user to be waiting for ever if the mail server is down or if it takes a long time 
		to compose the email or perform additional checks.
		You would then use thenApplyAsync to fire off the send email logic because it is not crucial to your system. 
		A user can always go back and say "send me another email".
		*/
	    register("user").thenAcceptAsync(username -> sendConfirmationEmail(username));
	}
	
	private static CompletionStage<String> register(String username) {
	    throw new UnsupportedOperationException();
	}

	private static void sendConfirmationEmail(String username) {
	    throw new UnsupportedOperationException();
	}
	
	public static void useRunningMultipleFuture() throws InterruptedException, ExecutionException {
		CompletableFuture<String> future1  = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<String> future2  = CompletableFuture.supplyAsync(() -> "Beautiful");
		CompletableFuture<String> future3  = CompletableFuture.supplyAsync(() -> "World");
		CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);
		combinedFuture.get(); //blocking
		//The limitation of this method is that it does not return the combined results of all Futures. 
		//Instead you have to manually get results from Futures. Fortunately, CompletableFuture.join() method 
		//Java 8 Streams API makes it simple:
		String combined = Stream.of(future1, future2, future3)
				  .map(CompletableFuture::join)
				  .collect(Collectors.joining(" "));
		System.out.println(combined);
		/*
		Note:
		The CompletableFuture.join() method is similar to the get method, but it throws an unchecked exception 
		in case the Future does not complete normally. This makes it possible to use it as a method reference in the Stream.map() method.
		*/
	}
	
	@SuppressWarnings("unused")
	public static void useHandlingErrors() throws InterruptedException, ExecutionException {
		/*
		 For error-handling in a chain of asynchronous computation steps, throw/catch idiom had to be adapted in a similar fashion.
		 Instead of catching an exception in a syntactic block, the CompletableFuture class allows you to handle it in a special handle method.
		 This method receives two parameters: a result of a computation (if it finished successfully) 
		 and the exception thrown (if some computation step did not complete normally).
		*/
		String name = null;
		CompletableFuture<String> completableFuture =  CompletableFuture.supplyAsync(() -> {
		      if (name == null) {
		          throw new RuntimeException("Computation error!");
		      }
		      return "Hello, " + name;
		  })
          .handle((s, t) -> s != null ? s : "Hello, Stranger! " + t);
		
		System.out.println(completableFuture.get());
		
		 // manually complete the Future, completeExceptionally method is intended 
		CompletableFuture<String> completableFuture2 = new CompletableFuture<>();
		completableFuture2.completeExceptionally(new RuntimeException("Calculation failed!"));
		System.out.println("Manually completed");
		System.out.println(completableFuture2.get());
		
	}
	
	public static void useAsyncMethod() throws InterruptedException, ExecutionException {
		//Most methods of the fluent API in CompletableFuture class have two additional variants with the Async postfix. 
		//These methods are usually intended for running a corresponding step of execution in another thread.
		//The methods without the Async postfix run the next execution stage using a calling thread. 
		//The Async method with an Executor argument runs a step using the passed Executor.
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<String> future = completableFuture.thenApplyAsync(s -> s + " World");
		System.out.println(future.get());
	}
	
	public static void useOperationOnEitherCompletionStageComplete() throws InterruptedException {
		Supplier<String> s1 = () -> {try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} return "Supplier 1";};
		Supplier<String> s2 = () -> "Supplier 2";
		CompletableFuture<String> p1 = CompletableFuture.supplyAsync(s1);
		CompletableFuture<String> p2 = CompletableFuture.supplyAsync(s2);
		//Consuming result of either of two completed stages
		p1.acceptEither(p2, System.out::println);
		//Applying a Function to result of either of two completed stages
		Thread.sleep(2000);
		CompletableFuture<String> ss = p1.applyToEither(p2, s->s+" new");
		System.out.println(ss.join());
	}
	
	static void useOperationAfterBothExample() {
	    String original = "Message";
	    StringBuilder result = new StringBuilder();
	    //Running a Runnable upon completion of both stages
	    CompletableFuture.completedFuture(original)
	                     .thenApply(String::toUpperCase)
	                     .runAfterBoth(CompletableFuture.completedFuture(original)
	                    		                        .thenApply(String::toLowerCase), () -> result.append("done"));
	    System.out.println(result);
	    
	    //Accepting results of both stages in a BiConsumer
	    StringBuilder result2 = new StringBuilder();
	    CompletableFuture.completedFuture(original)
	                      .thenApply(String::toUpperCase)
	                      .thenAcceptBoth(CompletableFuture.completedFuture(original)
	                    		                           .thenApply(String::toLowerCase), (s1, s2) -> result2.append(s1 + s2));
	    System.out.println(result2);
	    
	    //Applying a BiFunction on results of both stages
	    CompletableFuture<String> cf = CompletableFuture.completedFuture(original)
	    		                                        .thenApply(String::toUpperCase)
	    		                                        .thenCombine(CompletableFuture.completedFuture(original)
	    		                                        		                       .thenApply(String::toUpperCase), (s1, s2) -> s1 + s2);
	    System.out.println(cf.join());
	}
	
	public static void useAnyCompleteStateComplete() {
		StringBuilder result = new StringBuilder();
		List<String> messages = Arrays.asList("a", "b", "c");
	    List<CompletableFuture<String>> futures = messages.stream()
	            .map(msg -> CompletableFuture.completedFuture(msg).thenApply(String::toUpperCase))
	            .collect(Collectors.toList());
	    CompletableFuture.anyOf(futures.toArray(new CompletableFuture[futures.size()]))
	                     .whenComplete((res, th) -> 
	                                              {
												        if(th == null) {
												            System.out.println(isUpperCase((String) res));
												            result.append(res);
												         }
	                                               }
	                                    );
	    System.out.println(result);
	}
	private static boolean isUpperCase(String s) {
		return s.equals(s.toUpperCase());
	}
	
	public static void useAllCompleteStateComplete() {
		StringBuilder result = new StringBuilder();
		List<String> messages = Arrays.asList("a", "b", "c");
	    List<CompletableFuture<String>> futures = messages.stream()
	            .map(msg -> CompletableFuture.completedFuture(msg).thenApply(String::toUpperCase))
	            .collect(Collectors.toList());
	    CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
	                     .whenComplete((v, th) -> {
						    	System.out.println("Value = " + v);
						        futures.forEach(cf -> System.out.println(isUpperCase(cf.getNow(null))));
						        result.append("done");
	                      });
	    System.out.println(result);
	    
	    System.out.println("Testing Async");
	    //Async switching to thenApplyAsync() 
	    List<CompletableFuture<String>> futures2 = messages.stream()
	            .map(msg -> CompletableFuture.completedFuture(msg).thenApplyAsync(String::toUpperCase))
	            .collect(Collectors.toList());
	    CompletableFuture<Void> allOf =  CompletableFuture.allOf(futures2.toArray(new CompletableFuture[futures2.size()]))
	                     .whenComplete((v, th) -> {
	                    	    sleep(2000);
						    	System.out.println("Value = " + v);
						    	futures2.forEach(cf -> System.out.println(isUpperCase(cf.getNow(null))));
						        result.append("done");
	                      });
	    System.out.println("Done");
	    System.out.println(allOf.join());
	    System.out.println(result);
	    
	}
	
	 static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
