package datastructure.trees;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
   public Node root;
   
	public static void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	public static void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}
	public static void postOrder(Node root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	static int height(Node root){
		if(root == null)return -1;
		int ht_left = 1+ height(root.left);
		int ht_right = 1+ height(root.right);
		return Math.max(ht_left,ht_right);
	}
	
	static int numNodes(Node root){
		if(root == null) return 0;
		int num_left = numNodes(root.left);
		int num_right = numNodes(root.right);
		return 1+num_left+num_right;
	}
  
	static void levelOrder(Node root){
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Node temp;
		while(!q.isEmpty()){
			temp = q.remove();
			System.out.print(temp.data + " ");
			if(temp.left != null) q.add(temp.left);
			if(temp.right != null) q.add(temp.right);
		}
	}
	
	static void countNodeAtEachLevel(Node root, int level, int[] countLevel){
	  	if(root!=null){
	  		countLevel[level]++;
	  		countNodeAtEachLevel(root.left, level+1, countLevel);
	  		countNodeAtEachLevel(root.right, level+1, countLevel);
	  	}
	}
	
	public Node makeTree(int pre[], int in[], int preIndex, int inIndex, int numNodes){
		if(numNodes == 0) return null;
		int data = pre[preIndex];
		Node node = new Node(data);
		int searchIndexInInorder  = searchInorder(data, in, inIndex); 
		int numberOfNodesLeft = searchIndexInInorder-inIndex;
		int numberOfNodesRight = numNodes - numberOfNodesLeft - 1;
		Node left = makeTree(pre, in, preIndex + 1, inIndex, numberOfNodesLeft);
		Node right = makeTree(pre, in, preIndex  + numberOfNodesLeft + 1, searchIndexInInorder + 1,  numberOfNodesRight);
		node.left=left;
		node.right=right;
		return node;
	}
	
	int searchInorder(int data, int in[], int inIndex){
		int i = 0;
		for(i=inIndex;i < in.length;i++){
			if(data == in[i]) return i;
		}
		return -1;
	}
	
   Node copy(Node root){
	   if(root == null) return null;
	   Node temp = new Node(root.data);
	   temp.left = copy(root.left);
	   temp.right = copy(root.right);
	   return temp;
   }
   
   void mirror(Node root){
	   if(root != null){
		   Node temp = root.left;
		   root.left = root.right;
		   root.right = temp;
		   mirror(root.left);
		   mirror(root.right);
	   }
   }
   
   //should return head of the dll//
   /*
    * dll is formed in a fashion of inorder traversal
    * root is node of current stack
    * 
    * recursive function is  root, root left and root right is converted to dll and returned is right most element
    * Also, parameter passed to recursive function is the root on which dll is to be applied and 
    * additionally ptr which is just smaller than the left most element of the subtree (Inorder predecessor)
    * On going left ptr is same as ptr from previous stack of root
    * On going right ptr is same as root
    */
   //return finally the right most node of the linked list formed
   Node binaryTreeToLinkedList(Node root, Node ptr){
	   if(root == null) return root;
	   Node lptr = binaryTreeToLinkedList(root.left, ptr);
	   if(lptr != null){
		   lptr.right = root;
		   root.left = lptr;
	   }else if(ptr != null){
		   ptr.right = root;
		   root.left = ptr;
	   }
	   Node rptr = binaryTreeToLinkedList(root.right, root);
	   if(rptr != null){
		   return rptr;
	   }
	   return root;
   }  
   
   int lca = -1;
   public void lca(Node root, int a, int b) {
	  lca = -1;
      lowestCommonAncestor(root,a , b);   	
   	  System.out.println("Lowest common ancestor is " + lca);
   }
   
	private boolean lowestCommonAncestor(Node root, int a, int b) {
		if (root == null)
			return false;
		boolean left = lowestCommonAncestor(root.left, a, b);
		boolean right = lowestCommonAncestor(root.right, a, b);
		if (lca == -1) {
			if (left == true && right == true) {
				lca = root.data;
				return true;
			}else if((left == true || right == true) && (root.data == a || root.data ==b)){
				lca = root.data;
				return true;
			}
		}
		if (root.data == a || root.data == b)
			return true;
		return left || right;
	}
   
public static void main(String args[]){
	  /* Tree t = new Tree();
	   t.root = new Node(1);
	   t.root.left = new Node(2);
	   t.root.left.right = new Node(4);
	   t.root.right = new Node(3);
	   t.root.right.left = new Node(5);
	   t.root.right.left.right = new Node(7);
	   t.root.right.right = new Node(6);
	   preOrder(t.root);
	   System.out.println();
	   levelOrder(t.root);
	   System.out.println();
	   System.out.println("Height of the tree is : " +  height(t.root));
	   System.out.println("Number of nodes of the tree is : " +  numNodes(t.root));
	   int[] countLevel = new int[height(t.root)+1];
	   countNodeAtEachLevel(t.root, 0, countLevel);//after this call countLevel will have information 
	   */
	   int pre[] = {100,40,30,20,60,80,70,90,120,110};
	   int in [] = {20,30,40,60,70,80,90,100,110,120};
	   Tree t = new Tree();
	   t.root = t.makeTree(pre, in, 0, 0, pre.length);
	   BinaryTreePrinter.printNode(t.root);
	  // Tree.preOrder(t.root);
	  /* Tree copy = new Tree();
	   copy.root = copy.copy(t.root);
	   BTreePrinter.printNode(t.root);
	   BTreePrinter.printNode(copy.root);
	   t.mirror(t.root);*/
	   //BTreePrinter.printNode(t.root);
	  /* Tree t = new Tree();
	   t.root = new Node(5);
	   t.root.left = new Node(3);
	   t.root.right = new Node(7);*/
	   System.out.println();
	   //Node head = t.binaryTreeToLinkedList(t.root, null);
	   Node head = t.binaryTreeToLinkedList(t.root, null);
	   Node temp = head;
	   //System.out.println(temp.right.data);
	   while(temp != null){
		   System.out.print(temp.data + " ");
		   temp = temp.left;
	   }
	   System.out.println("\n\nEnd of main");
   }
   /*
    *       1
    *   2      3
    *    4   5    6
    *         7      
    */
 
}
