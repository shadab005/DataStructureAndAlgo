package module.logger;

public enum LogLevel {
	ERROR(1), INFO(2), DEBUG(3);

	private int priority;

	private LogLevel(int p) {
		priority = p;
	}

	public boolean isMorePriority(LogLevel l) {
		return this.priority - l.priority >= 0;
	}

}
