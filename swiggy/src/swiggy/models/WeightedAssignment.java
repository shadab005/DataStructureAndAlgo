package swiggy.models;

public class WeightedAssignment{
	private Assignment assignment;
	private int cost;

	public WeightedAssignment(Assignment assignment, int cost) {
		this.assignment=assignment;
		this.cost = cost;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
}