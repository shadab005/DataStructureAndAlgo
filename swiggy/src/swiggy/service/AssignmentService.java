package swiggy.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

import swiggy.models.Assignment;
import swiggy.models.DeliveryExecutive;
import swiggy.models.Order;
import swiggy.models.WeightedAssignment;
import swiggy.rules.RuleEngine;

public class AssignmentService {
	private List<Order> orders;
	private List<DeliveryExecutive> deliveryExecutives;
	private RuleEngine ruleEngine;
	
	public AssignmentService(List<Order> orders, List<DeliveryExecutive> deliveryExecutives) {
		this.orders=orders;
		this.deliveryExecutives=deliveryExecutives;
	}
	
	public List<Assignment> assignmentFunction(){
		Comparator<WeightedAssignment> byCost = (o1,o2)->o2.getCost()-o1.getCost();//For max heap
		PriorityQueue<WeightedAssignment> pq = new PriorityQueue<>(byCost);
		for(Order o:orders) {
			for(DeliveryExecutive d : deliveryExecutives) {
				Assignment a = new Assignment(o, d);
				int prioritizationCost = ruleEngine.evalute(a);
				pq.add(new WeightedAssignment(a, prioritizationCost));
			}
		}
		List<Assignment> a = new ArrayList<>();
		HashSet<Integer> orderIdSet = new HashSet<>();
		HashSet<Integer> deliveryExectuveIdSet = new HashSet<>();
		while(!pq.isEmpty()) {
			Assignment as = pq.remove().getAssignment();
			if(!orderIdSet.contains(as.getOrder().getId()) && !deliveryExectuveIdSet.contains(as.getDeliveryExecutive().getId())) {
				a.add(as);
				orderIdSet.add(as.getOrder().getId());
				deliveryExectuveIdSet.add(as.getDeliveryExecutive().getId());
			}
		}
		return a;
	}

	public RuleEngine getRuleEngine() {
		return ruleEngine;
	}

	public void setRuleEngine(RuleEngine ruleEngine) {
		this.ruleEngine = ruleEngine;
	}
	
}

