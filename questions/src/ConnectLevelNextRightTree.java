import java.util.ArrayDeque;
import java.util.Queue;

public class ConnectLevelNextRightTree
{
	 static class Node
	 {
	     int data;
	     Node left, right, nextRight;
	     Node(int item)
	     {
	         data = item;
	         left = right = nextRight = null;
	 		
	     }
	 }
	 
    /*void connect(Node root)
    {
        // Your code here	
    	Queue<Node> q = new ArrayDeque<>();
    	q.add(root);
    	int count = 1;
    	int childCount = 0;
    	while(!q.isEmpty()) {
    		Node node = q.poll();
    		Node prev = node;
    		childCount = 0;
    		if(node.left!=null) {
    			q.add(node.left);
    			childCount++;
    		}
    		if(node.right!=null) {
    			q.add(node.right);
    			childCount++;
    		}
    		count--;
    		while(count>0) {
    			node = q.poll();
    			prev.nextRight = node;
    			prev = node;
    			if(node.left!=null) {
        			q.add(node.left);
        			childCount++;
        		}
        		if(node.right!=null) {
        			q.add(node.right);
        			childCount++;
        		}
        		count--;
    		}
    		count = childCount;
    	}
    }*/
	void connect(Node root) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		Node prev = null;
		Node node = null;
		int size = 0;
		while (!q.isEmpty()) {
			size = q.size();
			prev = null;
			while (size-- > 0) {
				node = q.poll();
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
				if (prev != null)
					prev.nextRight = node;
				prev = node;
			}
		}
	}
	
	/*
	 * In iterative, we have two loops.
	 * Inner loop connect nextRight of each node at that level.
	 * Outer loop finds the first node of each level
	 */
	void connectIterative(Node root) {
		if(root==null)return;
		root.nextRight = null;
		
		Node q = null;
		while(root!=null) {
			q=root;
			while(q!=null) {
				if(q.left!=null) {
					if(q.right!=null)q.left.nextRight = q.right;
					else q.left.nextRight = getNext(q);
				}
				if(q.right!=null) q.right.nextRight = getNext(q);
				q=q.nextRight;
			}
			if(root.left!=null)root=root.left;
			else if(root.right!=null)root=root.right;
			else root = getNext(q);
		}
	}
    
    private Node getNext(Node q) {
		Node temp = q.nextRight;
		while(temp!=null) {
			if(temp.left!=null)return temp.left;
			if(temp.right!=null)return temp.right;
			temp = temp.nextRight;
		}
		return null;
	}

	public static void main(String args[]) {
    	Node root = new Node(10);
    	root.left = new Node(20);
    	root.right = new Node(30);
    	root.left.left = new Node(40);
    	root.left.right = new Node(60);
    	
    	ConnectLevelNextRightTree tree = new ConnectLevelNextRightTree();
    	tree.inorder(root);
    	tree.connect(root);
        tree.inorder(root);
        tree.levelOrder(root);
    }

	public void levelOrder(Node root) {
		System.out.println("Level order");
		Node node = null;
		while(root!=null) {
			node = root;
			System.out.print(root.data + " ");
			while(root.nextRight!=null) {
				root = root.nextRight;
				System.out.print(root.data + " ");	
			}
			System.out.println();
			root = node.left;
		}
		
	}

	public void inorder(Node root) {
		if(root!=null) {
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
		
	}
}