package swiggy.rules;

import java.util.Date;

import swiggy.models.Assignment;
import swiggy.util.TimeUtil;

public class WaitingRule implements Rule{
    
	@Override
	public int contributionValue(Assignment assignment, int priority) {
		Date lastOrder= assignment.getDeliveryExecutive().getLastOrderTime();
		Date current = new Date();
		return priority*TimeUtil.hoursDiff(lastOrder, current);
	}
}
