package leetcode;

import java.util.Arrays;

public class _337_HouseRoberIII {

	public static void main(String[] args) {
		System.out.println(max(1,1,1,1));

	}

	static public int rob(TreeNode root) {
		ResultNode resultNode = solve(root);
		return Math.max(resultNode.inc, resultNode.exc);
	}
	
	static class ResultNode {
		int inc;
		int exc;
		ResultNode(int including, int excluding) {
			inc = including;
			exc = excluding;
		}
	}
	
	static ResultNode solve(TreeNode root) {
		if(root == null) return new ResultNode(0, 0);
		ResultNode left = solve(root.left);
		ResultNode right = solve(root.right);
		int inc = root.val+left.exc+right.exc;
		int exc = max(left.inc+right.inc, left.inc+right.exc, left.exc+right.inc, left.exc+right.exc);
		return new ResultNode(inc, exc);
	}
	
	static int max(int... a) {
		return Arrays.stream(a).max().getAsInt();
	}
}
