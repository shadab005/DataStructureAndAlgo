package design.bookfiltering;

public class AndCriteria<T> implements Criteria<T> {
	
	private Criteria<T> leftCondition;
    private Criteria<T> rightCondition;

    public AndCriteria(Criteria<T> left, Criteria<T> right) {
        leftCondition = left;
        rightCondition = right;
    }

	@Override
	public boolean matches(T candidate) {
		return leftCondition.matches(candidate) && rightCondition.matches(candidate);
	}

}
