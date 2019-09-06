package module.retryframework;

public class ExponentialBackoffPolicyBuilder extends PolicyBuilder {
	
	private ExponenetialBackoffPolicy exponenetialBackoffPolicy;
	
	public ExponentialBackoffPolicyBuilder() {
		exponenetialBackoffPolicy = new ExponenetialBackoffPolicy();
	}
	@Override
	protected ExponenetialBackoffPolicy getRetryPolicy() {
		return exponenetialBackoffPolicy;
	}
	@Override
	public ExponenetialBackoffPolicy build() {
		return exponenetialBackoffPolicy;
	}
	@Override
	public ExponentialBackoffPolicyBuilder withInitialDelay(int milis) {
		super.withInitialDelay(milis);
		return this;
	}
	@Override
	public ExponentialBackoffPolicyBuilder withMaxAttempt(int maxAttempt) {
		super.withMaxAttempt(maxAttempt);
		return this;
	}
	public ExponentialBackoffPolicyBuilder withMultiplier(int multiplier) {
		getRetryPolicy().setMultiplier(multiplier);
		return this;
	}
	
}
