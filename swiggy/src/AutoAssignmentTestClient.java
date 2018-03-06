import java.text.ParseException;
import java.text.SimpleDateFormat;
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

		//Creating orders
		Order o1 = new Order(123, new Location( 17, 78) , sdf.parse("2018/03/03 11:10:45"));
		Order o2 = new Order(345, new Location (100, 150) , sdf.parse("2018/03/03 10:30:45"));
		List<Order> orders  = Arrays.asList(o1,o2);
		
		//Creating DeliveryExecutive Data
		DeliveryExecutive d1 = new DeliveryExecutive(712, new Location(17, 90), sdf.parse("2018/03/03 09:00:00"));
		DeliveryExecutive d2 = new DeliveryExecutive(723, new Location(10, 60), sdf.parse("2018/03/02 09:00:00"));
		DeliveryExecutive d3 = new DeliveryExecutive(745, new Location(70, 90), sdf.parse("2018/03/03 11:00:00"));
		List<DeliveryExecutive> deliveryExecutives = Arrays.asList(d1,d2,d3);
		
		//Initalizing AssingmentService data with orders and delivery executives and rule engine
		AssignmentService assigmentService = new AssignmentService(orders, deliveryExecutives);
		assigmentService.setRuleEngine(ruleEngine);
		
		//Invokes assginmentFunction to run through all the rules and make an assignment of all orders
		List<Assignment> assignments = assigmentService.assignmentFunction();
		for(Assignment a: assignments) {
			System.out.println(a);
		}
		
	}

}