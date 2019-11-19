package design.bookfiltering;

public class NotCriteria<T> implements Criteria<T> {
	
	private Criteria<T> criteria;

	public NotCriteria(Criteria<T> criteria) {
        this.criteria = criteria;
    }
	
	@Override
	public boolean matches(T candidate) {
		return !criteria.matches(candidate);
	}

}
