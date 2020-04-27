import datastructure.trees.BinarySearchTree;
import datastructure.trees.BinaryTreePrinter;
import datastructure.trees.Node;

public class TwoNodesSwappedBST {
	
	static Node correctBST(Node root){
		if(root!=null){
			Node left = correctBST(root.left);
			if(left!=null && left.data > root.data){
				Node rightMin = getReplaceOfLeft(root.right, root, left);
				if(rightMin==null) rightMin=root;
				swap(left, rightMin);
			}
			Node right = correctBST(root.right);
			if(right!=null) return right;
			else return root;
		}
		return null;
	}

	private static Node getReplaceOfLeft(Node root, Node parent, Node left) {
		if(root!=null){
			boolean found = false;
			while(!found){
				if(root.data < parent.data) found = true;
				else if(root.data < left.data && root.right!=null) root = root.right;
				else if(root.left!=null) root = root.left;
				else if(root.right == null && root.left == null) found = true;
			}
			return root;
		}
		return null;
	}

	private static void swap(Node first, Node second) {
		int temp = first.data;
		first.data=second.data;
		second.data=temp;
	}
	public static void main(String[] args) {
		/*BinarySearchTree bst = new BinarySearchTree();
		bst.add(10);
		bst.add(5);
		bst.add(20);
		bst.add(2);
		bst.add(8);
		bst.root.right.data=8;
		bst.root.left.right.data=20;
		BinaryTreePrinter.printNode(bst.root);
		correctBST(bst.root);
		BinaryTreePrinter.printNode(bst.root);*/
		test();
	}
	
	public static void test() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(8);
		bst.add(3);
		bst.add(1);
		bst.add(5);
		bst.add(4);
		bst.add(13);
		bst.add(10);
		bst.add(18);
		bst.add(25);
		bst.add(27);
		bst.root.right.right.data=25;
		bst.root.right.right.right.data=18;
		BinaryTreePrinter.printNode(bst.root);
		correctBST(bst.root);
		BinaryTreePrinter.printNode(bst.root);
	}

}
