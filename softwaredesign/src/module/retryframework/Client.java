package module.retryframework;

public class Client {

	public static void main(String[] args) {
		testExponentialBackoffPolicy();
		System.out.println();
		testFixedBackoffPolicy();
		
		System.out.println("Done Main");
	}
	
	private static void testFixedBackoffPolicy() {
		System.out.println("***** Testing Fixed Backoff *********");
		RetryPolicy fixedBackoffPolicy =  PolicyType.FixedBackoff
	             .builder()
	             .withInitialDelay(1000)
	             .withMaxAttempt(2)
	             .build();
		RetryExecutor executor = RetryExecutor.newExecutor(fixedBackoffPolicy);
		executor.execute(getTask());
		System.out.println("***** Done Testing Fixed Backoff *********");
	}

	private static void testExponentialBackoffPolicy() {
		System.out.println("***** Testing Exponential Backoff *********");
		RetryPolicy exponentialBackoffPolicy =  PolicyType.ExponentialBackoff
	             .builder()
	             .withInitialDelay(1000)
	             .withMultiplier(2)
	             .build();
		RetryExecutor executor = RetryExecutor.newExecutor(exponentialBackoffPolicy);
		executor.execute(getTask());
		System.out.println("***** Done Testing Exponential Backoff *********");
	}

	private static Runnable getTask() {
		return ()->{
		System.out.println("Inside task");
		throw new RuntimeException("Exception inside task");
		};
	}
	
	public static void sleep(int delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

/*
 * 1. How to make PolicyBuilder Hierachy work without overriding uncessary method
 * 2. How can this method  int getNextExecutionDelay(RetryContext context); in RetryPolicy should be implemented if child class doesn't need the context
 *    to get calculate the nextExecutionDelay
 * 3. What is the better way to construct RetryPolicy using builder.
 * 
 */
