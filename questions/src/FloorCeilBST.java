import datastructure.trees.BinarySearchTree;
import datastructure.trees.BinaryTreePrinter;
import datastructure.trees.Node;

public class FloorCeilBST {
	
	static int floor(Node root, int key){
		int floor = -1;
		boolean found = false;
		while(!found){
			if(key < root.data){
				if(root.left != null)root = root.left;
				else return floor;
			}
			else if(key > root.data){
				if(root.right!=null){
					floor = root.data;
					root=root.right;
				}
				else return root.data;
			}
			else return root.data;
			
		}
		return floor;
	}
	public static void main(String args[]){
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = new Node(8);
        tree.root.left = new Node(4);
        tree.root.right = new Node(12);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(10);
        tree.root.right.right = new Node(14);
        BinaryTreePrinter.printNode(tree.root);
        //floor of 7 should give 6
        //System.out.println(floor(tree.root, 5));
        for (int i = 0; i <= 16; i++) {
            System.out.println(i + " " + floor(tree.root, i));
        }
	}

}
