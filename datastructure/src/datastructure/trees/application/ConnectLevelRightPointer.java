package datastructure.trees.application;

public class ConnectLevelRightPointer {

	static class TreeLinkNode
	 {
	     int data;
	     TreeLinkNode left, right, next;
	     TreeLinkNode(int item)
	     {
	         data = item;
	         left = right = next = null;
	 		
	     }
	 }
	
	public void connect(TreeLinkNode root) {
		TreeLinkNode prev = null;
	    while(root!=null){
	    	connectLevel(root, prev);
	    	prev = firstParent(root);
	    	if(prev==null)root=null;
	    	else if(prev.left!=null)root=prev.left;
	    	else root = prev.right;
	    }
	}
	
	private void connectLevel(TreeLinkNode root, TreeLinkNode prev) {
		while(prev!=null) {
			if(prev.left!=root && prev.left!=null) {
				root.next = prev.left;
				root = root.next;
			}else if(prev.right!=root && prev.right!=null) {
				root.next = prev.right;
				root = root.next;
				prev = prev.next;
			}else {
				prev = prev.next;
			}
		}
	}
	
	private TreeLinkNode firstParent(TreeLinkNode root) {
		while(root!=null) {
			if(root.left!=null || root.right!=null)return root;
			root=root.next;
		}
		return root;
	}
	
	public void levelOrder(TreeLinkNode root) {
		System.out.println("Level order");
		TreeLinkNode node = null;
		while(root!=null) {
			node = root;
			System.out.print(root.data + " ");
			while(root.next!=null) {
				root = root.next;
				System.out.print(root.data + " ");	
			}
			System.out.println();
			root = node.left;
		}
		
	}
	
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(10);
    	root.left = new TreeLinkNode(20);
    	root.right = new TreeLinkNode(30);
    	root.left.left = new TreeLinkNode(40);
    	root.left.right = new TreeLinkNode(60);
    	
    	ConnectLevelRightPointer tree = new ConnectLevelRightPointer();
    	tree.connect(root);
    	tree.levelOrder(root);

	}

}
