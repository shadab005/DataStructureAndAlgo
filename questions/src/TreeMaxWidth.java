import datastructure.trees.BinaryTreePrinter;
import datastructure.trees.Node;
import datastructure.trees.Tree;

public class TreeMaxWidth {

	static int maxwidht = 0;
	
	static void width(Node root, int indexOfNode, int level){
		
	}
	public static void main(String args[]){
	   	int pre[] = {1,2,4,5,3,8,6,7};
	   	int in[] =  {4,2,5,1,3,6,8,7};
		Tree t = new Tree();
		t.root = t.makeTree(pre, in, 0, 0, pre.length);
		BinaryTreePrinter.printNode(t.root);
	   	
	}
}
