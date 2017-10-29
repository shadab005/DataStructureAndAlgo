package swiggy.rules;

import swiggy.models.Assignment;

public interface Rule {

	int contributionValue(Assignment assignment, int priority);

}
