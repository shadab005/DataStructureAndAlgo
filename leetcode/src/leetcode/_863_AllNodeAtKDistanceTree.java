package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _863_AllNodeAtKDistanceTree {

	public static void main(String[] args) {

	}

	static public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		List<Integer> ans = new ArrayList<>();
		solve(root, target,  k, ans);
		return ans;
	}

	private static int solve(TreeNode root, TreeNode target, int k, List<Integer> ans) {
		if(root == null) return -1;
		if(root==target) {
			printKLevelsDownFromHere(root, k, ans);
			return k-1;
		}
		int left = solve(root.left, target, k, ans);
		if(left!=-1) {
			if(left == 0 ) {
				ans.add(root.val);
			} else {
				printKLevelsDownFromHere(root.right, left-1, ans);
			}
			return left-1;
		}
		
		int right = solve(root.right, target, k, ans);
		if(right!=-1) {
			if(right == 0) {
				ans.add(root.val);
			}
			else printKLevelsDownFromHere(root.left, right-1, ans);
			return right-1;
		}
		return -1;
	}

	private static void printKLevelsDownFromHere(TreeNode root, int k,  List<Integer> ans) {
		if(k<0 || root == null) return;
		if(k==0) {
			ans.add(root.val);
			return;
		}
		printKLevelsDownFromHere(root.left, k-1, ans);
		printKLevelsDownFromHere(root.right, k-1, ans);
	}

}
