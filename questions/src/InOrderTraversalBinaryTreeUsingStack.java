import java.util.Stack;

import datastructure.trees.Node;
import datastructure.trees.Tree;

public class InOrderTraversalBinaryTreeUsingStack {
	
	public static void inOrder(Node root){
		Stack<Node> s = new Stack<>();
		while(root != null){
			s.push(root);
			root=root.left;
		}
		s.push(root);
		while (!s.isEmpty()) {
			Node current = s.pop();
			System.out.print(current.data + " ");
			current = current.right;
			while (current != null) {
				s.push(current);
				current = current.left;
			}
		}
	}

	public static void main(String args[]){
		Tree tree = new Tree();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        Tree.inOrder(tree.root); //4 2 5 1 3 
        System.out.println();
        inOrder(tree.root);
        
	}
	
}
