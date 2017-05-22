import datastructure.trees.BinarySearchTree;
import datastructure.trees.BinaryTreePrinter;
import datastructure.trees.Node;

public class InOrderSuccessorBSTAndKthSmallest {

	static boolean flag = false;
	static int getInorderSuccessor(Node root, int key){
	  if(root!=null){
		  int x = getInorderSuccessor(root.left, key);
		  if(x!=-1) return x;
		  if(flag) return root.data;
		  if(root.data == key) flag = true;
		  int y = getInorderSuccessor(root.right, key);
		  if(y!=-1) return y;
	  }
	 return -1;
		
	}
	
	static int count = 0;
	static int kthSmallest(Node root, int k){
		if(root!=null){
			int x = kthSmallest(root.left, k);
			if(x!=-1) return x;
			count = count + 1;
			if(count == k) return root.data;
			int y = kthSmallest(root.right, k);
			if(y!=-1) return y;
		}
		return -1;
	}
	
	
	public static void main(String args[]){
		/*BinarySearchTree bst = new BinarySearchTree();
		bst.add(20);
		bst.add(8);
		bst.add(22);
		bst.add(4);
		bst.add(12);
		bst.add(10);
		bst.add(14);
		System.out.println();
		BinaryTreePrinter.printNode(bst.root);
		BinarySearchTree.inOrder(bst.root);
		System.out.println();
		//inorder : 4 8 10 12 14 20 22 
		int node = 4;
		System.out.println("Successor of " + node + " is " + getInorderSuccessor(bst.root, node));
		int k = 5;
		System.out.println(k + "th smallest of is " + kthSmallest(bst.root, k));*/
		System.out.println();
		BinarySearchTree b1 = new BinarySearchTree();
		b1.add(17);
		b1.add(8);
		b1.add(7);
		b1.add(10);
		b1.add(12);
		BinaryTreePrinter.printNode(b1.root);
		
		BinarySearchTree b2 = new BinarySearchTree();
		b2.add(15);
		b2.add(4);
		b2.add(2);
		b2.add(1);
		b2.add(6);
		BinaryTreePrinter.printNode(b2.root);
		
		
	}
}
