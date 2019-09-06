package module.retryframework;

public class FixedBackoffPolicyBuilder extends PolicyBuilder {
	
	private FixedBackoffPolicy fixedBackoffPolicy;
	
	public FixedBackoffPolicyBuilder() {
		fixedBackoffPolicy = new FixedBackoffPolicy();
	}

	@Override
	protected RetryPolicy getRetryPolicy() {
		return fixedBackoffPolicy;
	}

	@Override
	public RetryPolicy build() {
		return fixedBackoffPolicy;
	}
	
	@Override
	public FixedBackoffPolicyBuilder withInitialDelay(int milis) {
		super.withInitialDelay(milis);
		return this;
	}
	@Override
	public FixedBackoffPolicyBuilder withMaxAttempt(int maxAttempt) {
		super.withMaxAttempt(maxAttempt);
		return this;
	}

}
