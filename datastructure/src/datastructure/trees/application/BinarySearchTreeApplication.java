package datastructure.trees.application;

import datastructure.trees.Node;

public class BinarySearchTreeApplication {
	
	
	public boolean isValidBinarySearchTree(Node root) {
		//isBst(root, null);
		return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean isBst(Node root, int min, int max) {
		if(root==null)return true;
		if(root.data <= min || root.data >= max) return false;
		return isBst(root.left, min, root.data) && isBst(root.right, root.data, max);
	}

	public static void main(String[] args) {
		BinarySearchTreeApplication solver = new BinarySearchTreeApplication();

		Node root = new Node(4);
		root.right = new Node(5);
		root.right.left = new Node(3);
		
		
		System.out.println(solver.isValidBinarySearchTree(root));
		
		
	}

}

