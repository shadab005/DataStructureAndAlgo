import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TreeLCA {
	
	//http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/

	Node root;
	
	/*
	    LCA of 4 and 5 is 2
		LCA of 4 and 6 is 1
		LCA of 3 and 4 is 1
		LCA of 2 and 4 is 2
	 */
	Node lca(Node root, int n1, int n2) 
    {
		if(root==null)return null;
		Node left = lca(root.left,n1,n2);
		Node right = lca(root.right,n1,n2);
		if(left!=null && right!=null)return root;
		if(root.data == n1 || root.data == n2)return root;
		if(left!=null)return left;
		else return right;
    }
	
	public void insert(int data) {
		Node node = new Node(data);
		if(root == null){
			root = node;
		}else{
			Node temp = root;
			Node prev = root;
			while(temp!=null){
				prev = temp;
				if(data < temp.data) temp = temp.left;
				else temp = temp.right;
			}
			if(data < prev.data) prev.left = node;
			else prev.right = node;
		}
	}
	
	public static void main(String[] args) {
		
		TreeLCA tree = new TreeLCA();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        
        BinaryTreePrinter.printNode(tree.root);
        System.out.println(tree.lca(tree.root, 4, 5).data);
        System.out.println(tree.lca(tree.root, 4, 6).data);
        System.out.println(tree.lca(tree.root, 3, 4).data);
        System.out.println(tree.lca(tree.root, 2, 4).data);

	}
	
	
	
	static class Node
	{
	    int data;
	    Node left, right;
	    Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}
	
	static class BinaryTreePrinter {
		public static void printNode(Node root) {
		    int maxLevel = BinaryTreePrinter.maxLevel(root);

		    printNodeInternal(Collections.singletonList(root), 1, maxLevel);
		}

		private static void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
		    if (nodes.isEmpty() || BinaryTreePrinter.isAllElementsNull(nodes))
		        return;

		    int floor = maxLevel - level;
		    int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		    int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		    int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		    BinaryTreePrinter.printWhitespaces(firstSpaces);

		    List<Node> newNodes = new ArrayList<Node>();
		    for (Node node : nodes) {
		        if (node != null) {
		            System.out.print(node.data);
		            newNodes.add(node.left);
		            newNodes.add(node.right);
		        } else {
		            newNodes.add(null);
		            newNodes.add(null);
		            System.out.print(" ");
		        }

		        BinaryTreePrinter.printWhitespaces(betweenSpaces);
		    }
		    System.out.println("");

		    for (int i = 1; i <= endgeLines; i++) {
		        for (int j = 0; j < nodes.size(); j++) {
		            BinaryTreePrinter.printWhitespaces(firstSpaces - i);
		            if (nodes.get(j) == null) {
		                BinaryTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
		                continue;
		            }

		            if (nodes.get(j).left != null)
		                System.out.print("/");
		            else
		                BinaryTreePrinter.printWhitespaces(1);

		            BinaryTreePrinter.printWhitespaces(i + i - 1);

		            if (nodes.get(j).right != null)
		                System.out.print("\\");
		            else
		                BinaryTreePrinter.printWhitespaces(1);

		            BinaryTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
		        }

		        System.out.println("");
		    }

		    printNodeInternal(newNodes, level + 1, maxLevel);
		}

		private static void printWhitespaces(int count) {
		    for (int i = 0; i < count; i++)
		        System.out.print(" ");
		}

		private static int maxLevel(Node node) {
		    if (node == null)
		        return 0;

		    return Math.max(BinaryTreePrinter.maxLevel(node.left), BinaryTreePrinter.maxLevel(node.right)) + 1;
		}

		private static  boolean isAllElementsNull(List<Node> list) {
		    for (Object object : list) {
		        if (object != null)
		            return false;
		    }

		    return true;
		}

}
}
