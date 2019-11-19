package design.bookfiltering;

/*
 * Note : Criteria class is similar to Java 8 Predicate class and hence in actual design we can get rid of this
 */
public interface Criteria<T> {

	 public boolean matches(T candidate);
	 
	 /*
	  * But how can we compose or chain multiple criteria using logical operators like AND, OR, NOT etc. 
	  * For this we will add few more methods in our interface.
	  */
	 public default Criteria<T> and(Criteria<T> other) {
	        return new AndCriteria<T>(this, other);
	    }

	    public default Criteria<T> or(Criteria<T> other) {
	        return new OrCriteria<T>(this, other);
	    }

	    public default Criteria<T> not() {
	        return new NotCriteria<T>(this);
	    }
	
}
