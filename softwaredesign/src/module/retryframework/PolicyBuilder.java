package module.retryframework;

public abstract class PolicyBuilder {

	protected abstract RetryPolicy getRetryPolicy();
	public abstract RetryPolicy build();
	
	public PolicyBuilder withInitialDelay(int milis) {
		getRetryPolicy().setInitialDelay(milis);
		return this;
	}
	
	public PolicyBuilder withMaxAttempt(int maxAttempt) {
		getRetryPolicy().setMaxAttempt(maxAttempt);
		return this;
	}
	
}
