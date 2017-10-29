package swiggy.rules;

import java.util.ArrayList;
import java.util.List;

import swiggy.models.Assignment;

public class RuleEngine {

	private List<Rule> rules = new ArrayList<>();
	public void addRule(Rule rule) {
		rules.add(rule);
	}

	public int evalute(Assignment assignment) {
		int totalCost=0;
		int n = rules.size();
		for(int i=0;i<n;i++) {
			totalCost+=rules.get(i).contributionValue(assignment,n-i); //contributionValue(assginment, priority cost)
		}
		return totalCost;
	}

	
}
