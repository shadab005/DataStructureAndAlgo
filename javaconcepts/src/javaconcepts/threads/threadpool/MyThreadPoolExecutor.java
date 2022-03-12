package javaconcepts.threads.threadpool;

import javaconcepts.threads.blockingqueue.MyBlockingQueue;

/*
 *  Java Executor
 *  ExecutorService is an interface, you need to implement
 *  It has following implementation : ThreadPoolExecutor, ScheduledThreadPoolExecutor
 *
 *  Executors factory class to create ExecutorService instances too.
 *  ExecutorService executorService1 = Executors.newSingleThreadExecutor();
 *  ExecutorService executorService2 = Executors.newFixedThreadPool(10);
 *  ExecutorService executorService3 = Executors.newScheduledThreadPool(10);
 *
 * ExecutorService methods:
 *  execute(Runnable) -> Execute the runnable task asynchronously
 *  submit(Runnable)  -> Returns a Future object. Can be used to check if Runnable has finished executing
 *  submit(Callable)  -> call method of Callable can return result. and obtained via the Future object returned by submit(Callable) method. {future.get()}
 *  invokeAny(...)    -> it takes a collection of Callables. Doesn't return future but returns the result of one of the Callable objects (Which one no guarantee)
 *  invokeAll(...)    -> invokes all the callables. Returns list if futures via which you can obtain the results of the executions of each Callable.
 *
 *  ThreadPoolExecutor :
 *  If not instantiating ThreadPoolExecutor using Exectors factory you have option of using another constructors
 *  int  corePoolSize  =    5;
 *  int  maxPoolSize   =   10;
 *  long keepAliveTime = 5000;
 *  ExecutorService threadPoolExecutor=new ThreadPoolExecutor(corePoolSize,maxPoolSize,keepAliveTime,TimeUnit.MILLISECONDS,new LinkBlockingQueue<Runnable>());
 *
 */

public class MyThreadPoolExecutor {

	private MyBlockingQueue<Runnable> queue;
	private ThreadPool[] pool;
	private boolean isStopped = false;

	MyThreadPoolExecutor(int threadCount, int maxTask) {
		queue = new MyBlockingQueue<>(maxTask);
		pool = new ThreadPool[threadCount];
		for (int i = 0; i < threadCount; i++)
			pool[i] = new ThreadPool(queue);
		for (ThreadPool thread : pool)
			thread.start();
	}

	public synchronized void execute(Runnable task) {
		if (isStopped)
			throw new IllegalStateException("ThreadPool is stopped");
		queue.put(task);
	}

	public synchronized void stop() {
		this.isStopped = true;
		for (ThreadPool t : pool)
			t.doStop();
	}

}

class ThreadPool extends Thread {

	private boolean alive = true;
	MyBlockingQueue<Runnable> queue;

	public ThreadPool(MyBlockingQueue<Runnable> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (alive) {
			Runnable task = queue.take();
			task.run();
		}
	}

	public void doStop() {
		alive = false;
		this.interrupt(); // break pool thread out of dequeue() call.
	}
}