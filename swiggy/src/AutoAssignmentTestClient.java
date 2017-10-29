import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import swiggy.models.Assignment;
import swiggy.models.DeliveryExecutive;
import swiggy.models.Location;
import swiggy.models.Order;
import swiggy.rules.DelayRule;
import swiggy.rules.DistanceRule;
import swiggy.rules.RuleEngine;
import swiggy.rules.WaitingRule;
import swiggy.service.AssignmentService;

public class AutoAssignmentTestClient {

	public static void main(String[] args) throws ParseException {
	
		DistanceRule r1 = new DistanceRule();
		WaitingRule r2 = new WaitingRule();
		DelayRule r3 = new DelayRule();
		
		RuleEngine ruleEngine = new RuleEngine();
		//Add rules in sequence of priority
		ruleEngine.addRule(r1);
		ruleEngine.addRule(r2);
		ruleEngine.addRule(r3);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		Order o1 = new Order(123, new Location( 17, 78) , sdf.parse("2017/09/23 11:10:45"));
		Order o2 = new Order(345, new Location (100, 150) , sdf.parse("2017/09/23 10:30:45"));
		
		List<Order> orders  = new ArrayList<>(Arrays.asList(o1,o2));
		
		DeliveryExecutive d1 = new DeliveryExecutive(712, new Location(17, 90), sdf.parse("2017/09/23 09:00:00"));
		DeliveryExecutive d2 = new DeliveryExecutive(723, new Location(10, 60), sdf.parse("2017/09/22 09:00:00"));
		DeliveryExecutive d3 = new DeliveryExecutive(745, new Location(70, 90), sdf.parse("2017/09/23 11:00:00"));
		
		List<DeliveryExecutive> deliveryExecutives = new ArrayList<>(Arrays.asList(d1,d2,d3));
		
		AssignmentService assigmentService = new AssignmentService(orders, deliveryExecutives);
		assigmentService.setRuleEngine(ruleEngine);
		
		List<Assignment> assignments = assigmentService.assignmentFunction();
		for(Assignment a: assignments) {
			System.out.println(a);
		}
		
	}

}