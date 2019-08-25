package javaconcepts.threads.threadpool.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelTasktest {
	
	private ExecutorService executor = Executors.newFixedThreadPool(2);
	
	
	public static void main(String[] args) {
	
		ParallelTasktest p = new ParallelTasktest();
		p.testOne();

	}
	
	void testOne() {
		System.out.println("Task started");
		List<Runnable> tasks = getTasks();
		List<Future<?>> futures = new ArrayList<>();

		
		//Future<?> result = executor.submit(()->f1());
		/*for(Runnable task : tasks) {
			futures.add(executor.submit(task));
		}*/
		tasks.forEach(task->futures.add(executor.submit(task)));
		futures.forEach(f-> {
            try {
            	System.out.println("Result : " + f.get());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("I am in exception block " + e);
            }
        });
	/*	for(Future<?> f : futures) {
			try {
				System.out.println("Result : " + f.get());
			} catch (InterruptedException | ExecutionException e) {
				System.out.println("I am in exception block");
			}
			System.out.println("Looping back");
		}*/
	/*	try {
			System.out.println(result.get());
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("I am in exception block");
		}*/
		System.out.println("End!!");
		executor.shutdown();
	}
	
	
	private List<Runnable> getTasks() {
		List<Runnable> runs = new ArrayList<>();
		runs.add(()->f1());
		runs.add(()->f2());
		return runs;
	}

	void f1() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new NullPointerException();
	}
	
	void f2() {
		System.out.println("Done f2");
	}

}
