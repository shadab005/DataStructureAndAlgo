package datastructure.trees;

public class BinarySearchTree extends Tree {

	
	public void add(int data){
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
	
	
	//will delete the node and bring the rightmost element(α) of the left subtree in its place and and 
	// α left subtree will become the right subtree of α parent
    public void deleteNodeInBST(int data){
		Node root = this.root;
		if(root == null){
			System.out.println("Node to be deleted doesn't exist");
			return;
		}
		Node prev = root;
		Node temp = root;
		while(temp!=null){
			if(data < temp.data){prev = temp; temp = temp.left;}
			else if(data > temp.data){prev = temp; temp = temp.right;}
			else break;
			
		}
		if(temp == null){
			System.out.println("Node to be deleted doesn't exist");
		}
		else
		{
			if(prev == temp)
			{
				//Node to be deleted is the first node i.e head
				if(temp.left == null){
					this.root = temp.right; 
				}
				else
				{
					Node q = null, prevq =null;
					for(prevq=q=temp.left;q.right!=null;)
					{
						prevq=q;
						q=q.right;
					}
					this.root = q;
			    	this.root.right = temp.right;
				    if(temp.left == q)
				    {
				    	this.root.left = q.left;
				    }
				    else
				    {
				    	this.root.left = temp.left;
				    	prevq.right = q.left;
				    }
				    temp = null;
				}
			}
			else
			{
				if(temp.left ==null)
				{
					prev.right = temp.right;
				}
				else
				{
					Node q = null, prevq =null;
					for(prevq=q=temp.left;q.right!=null;)
					{
						prevq=q;
						q=q.right;
					}
					prevq.right = q.left;
					prev.right = q;
					q.left = temp.left;
					q.right = temp.right;
					temp=null; //freeing the reference to the node pointed by temp
				}
			}
		}
		
	}
	
	
	
	public Node searchNode(int data){
	   Node temp = this.root;
	   while(temp != null && temp.data!=data){
		   if(data < temp.data) temp = temp.left;
		   else  temp = temp.right;
	   }
	   return temp;
	}
	
	
	public static void main(String args[]){

		BinarySearchTree bst = new BinarySearchTree();
		bst.add(10);
		bst.add(6);
		bst.add(15);
		bst.add(2);
		bst.add(9);
		bst.add(12);
		bst.add(20);
		bst.add(1);
		bst.add(18);
		bst.add(14);
		bst.add(13);
		
		inOrder(bst.root);
		System.out.println();
		if(bst.searchNode(1) != null) System.out.println("Node found");
		else System.out.println("Node not found");
		BinaryTreePrinter.printNode(bst.root);
		bst.deleteNodeInBST(15);
		System.out.println("Deleted");
		BinaryTreePrinter.printNode(bst.root);
	}
}
