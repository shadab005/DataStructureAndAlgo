package module.retryframework;

public class RetryContext {
	
	private int attempCount;
	private Exception exception;

	public RetryContext() {
		this.exception = null;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
	
	public Exception getException() {
		return exception;
	}

	public int getAttempCount() {
		return attempCount;
	}

	public void setAttempCount(int attempCount) {
		this.attempCount = attempCount;
	}
	
	public void updateForRetry() {
		attempCount++;
		exception = null;
	}
	
}
