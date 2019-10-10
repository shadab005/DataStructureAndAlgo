package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _22_GenerateParentheses {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(4));

	}
	
	static public List<String> generateParenthesis(int n) {
     List<String> ans = new ArrayList<>();
     if(n<=0) return ans;
     process(n, new StringBuilder(), ans, n);
     return ans;
    }

	private static void process(int leftRemaining, StringBuilder sb, List<String> ans, int n) {
		//System.out.println(leftRemaining + " ## " + sb + " ## " + n);
		int leftUsed = n - leftRemaining;
		int rightUsed = sb.length()-leftUsed;
		int rightRemaining = n - rightUsed;
		//Base Case
		if(leftRemaining == 0 && rightRemaining == 0) {
			//System.out.println("Here : " + sb.toString());
			ans.add(sb.toString()+"");
			return;
		}
		
		//Note : leftRemaing <= rightRemaining
		if(leftRemaining > 0) {
			sb.append('(');
			process(leftRemaining-1, sb, ans, n);
			sb.deleteCharAt(sb.length()-1);
		}
		if(rightRemaining > leftRemaining) {
			sb.append(')');
			process(leftRemaining, sb, ans, n);
			sb.deleteCharAt(sb.length()-1);
		}
	}

}
