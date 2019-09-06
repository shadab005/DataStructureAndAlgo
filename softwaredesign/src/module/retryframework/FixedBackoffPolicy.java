package module.retryframework;

public class FixedBackoffPolicy extends RetryPolicy {

	@Override
	public int getNextExecutionDelay(RetryContext context) {
		return getInitialDelay();
	}

}
