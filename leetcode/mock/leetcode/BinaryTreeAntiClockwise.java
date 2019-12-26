package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeAntiClockwise {

	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(8);
		
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.left.left = new TreeNode(9);
		root.right.left.right = new TreeNode(10);
		
		System.out.println(boundaryOfBinaryTree(root));

	}
	
	static List<Integer> ans;
	static public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		ans = new ArrayList<>();
		if(root == null) return ans;
		ans.add(root.val);
		printLeftBounaryWithAllLeafs(root.left, true);
		printRightBounaryWithAllLeafs(root.right, true);
		return ans;
    }
	

	private static void printLeftBounaryWithAllLeafs(TreeNode root, boolean flag) {
		if(root == null) return;
		if(flag) ans.add(root.val);
		else if(root.left == null && root.right == null) ans.add(root.val);
		
		if(root.left == null) {
			printLeftBounaryWithAllLeafs(root.right, flag);
		} else {
			printLeftBounaryWithAllLeafs(root.left, flag);
			printLeftBounaryWithAllLeafs(root.right, false);
		}
	}

	private static void printRightBounaryWithAllLeafs(TreeNode root, boolean flag) {
		if(root == null) return;
		if(root.left == null && root.right == null) {
			ans.add(root.val);
			return;
		}
		if(root.right == null) {
			printRightBounaryWithAllLeafs(root.left, flag);
		} else {
			printRightBounaryWithAllLeafs(root.left, false);
			printRightBounaryWithAllLeafs(root.right, flag);
		}
		if(flag) ans.add(root.val);
	}


}
