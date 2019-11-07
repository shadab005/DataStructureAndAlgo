package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _545_BoundaryOfBinaryTree {

	public static void main(String[] args) {
		TreeNode r = new TreeNode(1);
		r.left = new TreeNode(2);
		r.left.left = new TreeNode(3);
		r.left.left.left = new TreeNode(4);
		r.left.left.left.left = new TreeNode(6);
		
		r.left.right = new TreeNode(5);
		r.left.right.left = new TreeNode(7);
		
		r.right = new TreeNode(8);
		r.right.left = new TreeNode(9);
		
		r.right.right = new TreeNode(10);
		r.right.right.left = new TreeNode(11);
		r.right.right.right = new TreeNode(12);
		
		System.out.println(boundaryOfBinaryTree(r));

	}
	
	static public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeNode rightSubTreeRoot = root.right;
        root.right = null;
        printLeftTree(root, true, ans);
        printRightTree(rightSubTreeRoot, true, ans);
        root.right = rightSubTreeRoot;
		return ans;
    }

	private static void printRightTree(TreeNode root, boolean shouldPrintNodesOnPath, List<Integer> ans) {
		if(root == null) return;
		if(root.left == null && root.right == null) ans.add(root.val);
		else if(root.right == null && shouldPrintNodesOnPath) {
			printRightTree(root.left, shouldPrintNodesOnPath, ans);
			ans.add(root.val);
		} else {
			printRightTree(root.left, false, ans);
			printRightTree(root.right, shouldPrintNodesOnPath,  ans);
			if(shouldPrintNodesOnPath) ans.add(root.val);
		}
	}

	private static void printLeftTree(TreeNode root, boolean shouldPrintNodesOnPath, List<Integer> ans) {
		if(root == null) return;
		if(root.left == null && root.right == null) ans.add(root.val);
		else if(root.left==null && shouldPrintNodesOnPath) {
			ans.add(root.val);
			printLeftTree(root.right, shouldPrintNodesOnPath, ans);
		} else {
			if(shouldPrintNodesOnPath)ans.add(root.val);
			printLeftTree(root.left, shouldPrintNodesOnPath, ans);
			printLeftTree(root.right, false, ans);
		}
		
	}
}

