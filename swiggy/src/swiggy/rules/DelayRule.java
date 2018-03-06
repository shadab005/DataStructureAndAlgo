package swiggy.rules;

import java.util.Date;

import swiggy.models.Assignment;
import swiggy.util.TimeUtil;

/*
 * Higher the Delay higher the contribution value
 */
public class DelayRule implements Rule {

	@Override
	public int contributionValue(Assignment assignment, int priority) {
		Date orderTime = assignment.getOrder().getOrderTime();
		Date current = new Date();
		int diff = TimeUtil.hoursDiff(orderTime, current);
		// more the diff more the prioritization cost
		return diff*priority;
	}

}
