package module.logger;

public enum Level {

	INFO(1), DEBUG(2), ERROR(3);
	public int level;
	private Level(int level) {
	  this.level = level;	
	}
	
	public boolean lessThan(Level that) {
		if(that.level > this.level) return true;
		return false;
	}
}
