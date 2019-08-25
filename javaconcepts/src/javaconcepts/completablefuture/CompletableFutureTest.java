package javaconcepts.completablefuture;

import static javaconcepts.completablefuture.CompletableFutureLearning.sleep;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTest {
	
	private static ExecutorService ex = Executors.newFixedThreadPool(3);

	public static void main(String[] args) {

		test2();
		ex.shutdown();

	}
	
	public static void test1() {
		//If I remove sleep(3000) the Hello aysnc Supplier will not be printed.
		//Difference between raw thread that we create and this completableFuture thread.
		testIfThisCallBlocks();
		System.out.println("Done");
		sleep(3000);
		System.out.println("Ending");
	}
	public static void testIfThisCallBlocks() {
		CompletableFuture<String> c1 = CompletableFuture.supplyAsync(()->{
		//	sleep(2000);
			return "Hello from async supplier";
		});
		c1.thenAccept(System.out::println);
		System.out.println("Exiting this");
	}
	
	public static void test2() {
		CompletableFuture<String> cf = new CompletableFuture<>();
		cf.thenApply(x->{System.out.println("thenApply:"+ Thread.currentThread()); return 1;});
		sleep(1000);
		ex.execute(()->{ System.out.println("execute:"+Thread.currentThread());cf.complete("test");});
		System.out.println("End test 2");
	}
	

}
