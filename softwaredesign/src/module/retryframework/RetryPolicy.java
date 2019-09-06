package module.retryframework;

public abstract class RetryPolicy {
	
	private int maxAttempt = 3;
	
	private int initialDelay = 0; // 0 miliseconds
	
	//checks if the exception is eligible for retry
	//checks if the number of attempt is less than the maxAttempt
	public boolean canRetry(RetryContext context) {
		return context.getAttempCount() < maxAttempt && isExceptionRetryable(context.getException());
	}

	private boolean isExceptionRetryable(Exception exception) {
		//TODO
		return true;
	}


	public abstract int getNextExecutionDelay(RetryContext context);

	public int getInitialDelay() {
		return initialDelay;
	}

	public void setInitialDelay(int delay) {
		this.initialDelay = delay;
	}
	
	public int getMaxAttempt() {
		return maxAttempt;
	}

	public void setMaxAttempt(int maxAttempt) {
		this.maxAttempt = maxAttempt;
	}


}
