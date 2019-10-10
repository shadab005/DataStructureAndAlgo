package leetcode;

import java.util.ArrayDeque;

/*
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *  "(()" => 2
 */
public class _32_LongestValidParentheses {

	public static void main(String[] args) {
		//System.out.println(process("()(()()", 0, 6));
		System.out.println(longestValidParentheses("))))()) ()()(()"));

	}
	
	static public int longestValidParentheses(String s) {
     
		if(s==null || s.isEmpty()) return 0;
		int i = 0;
		int n = s.length();
		while(i<n && s.charAt(i) != '(')i++;
		if(i==n) return 0;
		int ans = 0;
		int j = 0;
		int sum = 1; // '(' => +1 and ')' => -1
		j = i+1;
		while(j<n) {
			//System.out.println("i="+i+" and j="+j);
			if(s.charAt(j) == '(') {
				sum++;
			} else if(s.charAt(j) == ')') {
				sum--;
				if(sum<0) {
					//process i to j-1;
					//System.out.println("Pricessing " + "i="+i+" and j="+(j-1));
					int count = process(s,i,j-1);
					//System.out.println("Result = " + count);
					ans = Math.max(ans, count);
					i = j+1;
					//j = i;
					sum = 0;
				}
			}
			j++;
		}
		if(j==n) {
			//System.out.println("Processing " + "i="+i+" and j="+(j-1));
			int count = process(s, i, j-1);
			ans = Math.max(ans, count);
		}
		return ans*2;
    }

	private static int process(String s, int i, int j) {
		if(i>=j)return 0;
		int ans = 0;
		int sum = 0;
		ArrayDeque<Character> stack = new ArrayDeque<>();
		while(j>=i) {
			//System.out.println("j="+j);
			if(s.charAt(j) == ')') stack.push(')');
			else {
				//System.out.println(stack.peek());
				if(stack.isEmpty() || stack.peek() != ')') {
					//ignore
					sum = 0;
				} else {
					sum++;
					stack.pop();
					ans = Math.max(ans, sum);
				}
			}
			j--;
		}
		return ans;
	}

}
