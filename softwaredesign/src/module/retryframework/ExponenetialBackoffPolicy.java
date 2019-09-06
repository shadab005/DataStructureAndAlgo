package module.retryframework;

public class ExponenetialBackoffPolicy extends RetryPolicy {
	
	private int multiplier = 2;

	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}
	
	@Override
	public int getNextExecutionDelay(RetryContext context) {
		//Formula : mutliplier^(attemp-1)*initialDelay
		return (int) (Math.pow(multiplier, context.getAttempCount()-1)*getInitialDelay());
	}
	
}
