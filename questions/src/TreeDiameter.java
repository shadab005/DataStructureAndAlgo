import datastructure.trees.BinaryTreePrinter;
import datastructure.trees.Node;
import datastructure.trees.Tree;

public class TreeDiameter {

	static int diameter = 0;
	static int treeDiameter(Node root){
		if(root == null)return -1;
		int ht_left = 1 + treeDiameter(root.left);
		int ht_right = 1 + treeDiameter(root.right);
		
		int diameterAthThisNode = 1 + ht_left + ht_right;
		if(diameterAthThisNode > diameter) diameter = diameterAthThisNode;
		return Math.max(ht_left, ht_right);
	}
	
	public static void main(String[] args) {
		/*int pre[] = {10, 4, 2, 6, 7, 12};
		int in[] =  {2, 4, 6, 7, 10, 12};*/
		int pre[] = {10, 4, 3, 2, 1, 5, 6, 7, 20};
		int in[] =  {1, 2, 3, 4, 5, 6, 7, 10, 20};
		Tree t = new Tree();
		t.root = t.makeTree(pre, in, 0, 0, pre.length);
		BinaryTreePrinter.printNode(t.root);
		treeDiameter(t.root);
		System.out.println("Diameter of the tree is : " + diameter);
		

	}

}
