package datastructure.trees.application;

import java.util.ArrayList;

import datastructure.trees.BinaryTreePrinter;
import datastructure.trees.Node;
import datastructure.trees.Tree;

public class PrintAllKSumPathInBinaryTree {

	public static void main(String[] args) {
		PrintAllKSumPathInBinaryTree p = new PrintAllKSumPathInBinaryTree();
		Tree tree  = p.constructTree();
		BinaryTreePrinter.printNode(tree.root);
		ArrayList<Integer> path = new ArrayList<>();
		int sum = 5;
		p.printKSumPathFromParentToChild(tree.root, sum, path);
		

	}

	
	
	
	
	
	public void printKSumPathFromParentToChild(Node root, int k, ArrayList<Integer> path) {
		if(root==null)return;
		path.add(root.data);
		printKSumPathFromParentToChild(root.left, k, path);
		printKSumPathFromParentToChild(root.right, k, path);
		int sum = 0;
		for(int i=path.size()-1;i>=0;i--) {
			sum+=path.get(i);
			if(sum==k)printPath(path, i);
		}
		path.remove(path.size()-1);
	}

	private void printPath(ArrayList<Integer> path, int i) {
		for(int j=i;j<path.size();j++) {
			System.out.print(path.get(j)+ " ");
		}
		System.out.println();
	}






	private Tree constructTree() {
		Tree t = new Tree();
		t.root = new Node(1);
		t.root.left = new Node(3);
		t.root.right = new Node(-1);
		
		t.root.left.left = new Node(2);
		t.root.left.right = new Node(1);
		
		t.root.left.right.left = new Node(1);
		
		t.root.right.left = new Node(4);
		t.root.right.right = new Node(5);
		
		t.root.right.right.right = new Node(6);
		
		t.root.right.left.left = new Node(1);
		t.root.right.left.right = new Node(2);
		return t;
	}

}
