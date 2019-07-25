package batman_test.logger;

public enum LogLevel {
	INFO(1), DEBUG(2), ERROR(3);

	private int priority;

	private LogLevel(int p) {
		priority = p;
	}

	public boolean isLessPriority(LogLevel l) {
		return this.priority - l.priority <= 0;
	}

}
