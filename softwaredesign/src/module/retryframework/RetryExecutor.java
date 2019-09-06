package module.retryframework;

import java.util.Date;

public class RetryExecutor {

	private RetryPolicy retryPolicy;
	private RetryExecutor(RetryPolicy retryPolicy) {
		this.retryPolicy = retryPolicy;
	}

	public void execute(Runnable task) {
		RetryContext context = new RetryContext();
		executeWithContext(task,context);
	}
	
	private void executeWithContext(Runnable task, RetryContext context) {
		try {
			System.out.println("Executing Task | [" + new Date() + "] | Retry Attempt Number : " + context.getAttempCount());
			task.run();
		} catch (Exception ex) {
			System.out.println("Task Failed");
			context.setException(ex);
			if(retryPolicy.canRetry(context)) {
				System.out.println("Building next execution context");
				System.out.println();
				context.updateForRetry();
				sleep(retryPolicy.getNextExecutionDelay(context));
				executeWithContext(task, context);
			}	
		}
	}
	
	private void executeWithContextYetAnother(Runnable task, RetryContext context) {
		/*CompletableFuture.runAsync(task)
		                 .handle((v,ex) -> ex!=null ? retry():completeSuccessfully());
		*/
	}
	
	private void sleep(int delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static RetryExecutor newExecutor(RetryPolicy policy) {
		return new RetryExecutor(policy);
	}
}

//Delayable Task
//Method with delay parameter
//Before calling executeWithContext, create a delay there itself
//Keep the delay information in context itself
