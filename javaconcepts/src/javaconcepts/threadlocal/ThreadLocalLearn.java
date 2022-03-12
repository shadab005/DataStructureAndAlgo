package javaconcepts.threadlocal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Thread Local can be considered as a scope of access, like a request scope or session scope. It’s a thread scope.
 *
 * Most common use of thread local is when you have some object that is not thread-safe,
 * but you want to avoid synchronizing access to that object using synchronized keyword/block.
 * Instead, give each thread its own instance of the object to work with.
 *
 * ex : SimpleDateFormat,
 * let's say we have 10 pool size threadpool executor and 1000 task.
 * 1 object per task will take too much memory
 * Global object. Not thread safe will require synchronization and hence slow performance.
 * Right way is to have one object per thread.
 * See useOne
 *
 * We can also use ThreadLocal to hold the context if there is between services if
 * lets say s1 calls s2, s2 calls s3, s3 calls s4 and so on.
 * And we want to pass some static data from s1 to subsequent services.
 * see useTwo
 * Note: spring framework also uses a lot of context holder like LocaleContextHolder, TransactionContextHolder etc.
 */
public class ThreadLocalLearn {

	public static void main(String[] args) {

		useTwo();
		ex.shutdown();
	}

	private static ThreadLocal<SimpleDateFormat> df = ThreadLocal.withInitial(SimpleDateFormat::new);
	private static ExecutorService ex = Executors.newFixedThreadPool(10);

	public static void useOne() {
		getTasks().forEach(ex::execute);
		sleep(3000);
		System.out.println("Done useOne");

	}

	private static List<Runnable> getTasks() {
		List<Runnable> tasks = new ArrayList<>();
		for(int i=0;i<1000;i++) {
			int k = i;
			tasks.add(()->System.out.println("Thread id " + Thread.currentThread().getId() +
					" Task No : " + k +
					" Date : " + df.get().format(new Date())));
		}
		return tasks;
	}

	static class UserContextHolder {
		public static ThreadLocal<String> holder = new ThreadLocal<>();
	}
	private static void useTwo() {
		CompletableFuture<Void> c1 = webRequest("shadab");
		CompletableFuture<Void> c2 = webRequest("ankit");
		CompletableFuture<Void> c3 = webRequest("naaree");

		CompletableFuture<Void>  all = CompletableFuture.allOf(c1,c2,c3);
		try {
			all.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	private static CompletableFuture<Void> webRequest(String userName) {
		//Consider CompletableFuture built here as service calls 1(supplyAsync) then 2 (thenAccept)
		//We are hoping supplyAsycn and thenAccept runs on the same thread
		//We have created below simulation of three request.
		return CompletableFuture
		.supplyAsync(()->getUserName(userName))
		.thenAccept((user)->{
			sleep(1000);
			System.out.println("From accept param : " + user + " From ThreadLocal : " + UserContextHolder.holder.get());
		})
		.thenRun(()->UserContextHolder.holder.remove());
		//Note once the request is served and processed completely, it should be removed from the context
	}

	private static String getUserName(String userName){
		sleep(1000);
		UserContextHolder.holder.set(userName);
		return userName;
	}

	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
