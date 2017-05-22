package datastructure.trees;

import java.util.LinkedList;
import java.util.Queue;

/*

Algorithm	Average	    Worst Case
Space		O(n)	    O(n)
Search		O(log n)	O(log n)
Insert		O(log n)	O(log n)
Delete		O(log n)	O(log n)

 best case height: log{m}(N+1)
 Worst case height: log{m/2}(N)
*/

public class BTree {

	public Node root;
	private static final int M = 4;

	public static class Node {

		// Each Node object is a B-tree node.

		private int size; //Number of keys
		private int[] data; //keys
		private Node[] childs; //Number of children
		public Node()
		{
			data = new int[M];
			childs = new Node[M+1];
		}

	}

	public Node search(Node root, int key) 
	{
		if(root == null) return null;
		int i = searchInNode(root, key);
		if(i < root.size && root.data[i] == key) return root;
		return search(root.childs[i], key);
	}

	private int searchInNode(Node node, int key) //return the index below which I have to do
	{
		int i = 0;
		while(i< node.size && key > node.data[i]) i++;
		return i;
	}
	
    public void delete(int key){
    	if(search(root,key)!=null)
	       deleteData(this.root, key);
    	else
    		System.out.println("Key not found");
	}

	private int deleteData(Node root, int key) {
		if(root == null) return -1;
		int i = 0, countChildNode =0;
		while(i< root.size && key > root.data[i]) i++;
		if(root.data[i] != key){
			countChildNode = deleteData(root.childs[i], key);
		}else{
			if(root.childs[0] == null){
				deleteFromLeaf(root,key,i);
				return root.size;				
			}else{
				//root contains key and it is at ith index
				//find rightsubtree left most element
				//replace it with current node data
				//now we have to delete the right subtree left most element
				int successor = findSuccessor(root.childs[i+1]); //success is the leftmost node of the right subtree and will be in leaf
				root.data[i] = successor;
				countChildNode = deleteData(root.childs[i+1], successor);
				i+=1;
			}
		}
		 if(countChildNode < M/2){
			   int leftNodeChildCount = 0;
			   int rightNodeChildCount = 0;
			   if(i>0){
				   leftNodeChildCount = root.childs[i-1].size;
			   }
			   if(i<root.size){
				   rightNodeChildCount = root.childs[i+1].size;
			   }
			   if(leftNodeChildCount > M/2){
				   //pullFromLeft
				  Node rootChild = root.childs[i];
				  shiftRight(rootChild);
				  Node leftChild = root.childs[i-1];
				  rootChild.data[0] = root.data[i-1];
				  rootChild.childs[0] = leftChild.childs[leftChild.size];
				  rootChild.size+=1;
				  root.data[i-1] = leftChild.data[leftChild.size-1];
				  leftChild.data[leftChild.size-1] = 0;
				  leftChild.childs[leftChild.size] = null;
				  leftChild.size-=1;
				   
			   }else if(rightNodeChildCount > M/2){
				   //pull from right
				   Node rootChild = root.childs[i];
				   rootChild.data[rootChild.size] = root.data[i];
				   rootChild.childs[rootChild.size+1] = root.childs[i+1].childs[0];
				   rootChild.size+=1;
				   root.data[i] = root.childs[i+1].data[0];
				   shiftLeft(root.childs[i+1],0);
			   }else{
				   //combine
				   combine(root,i);
			   }
			}
		return root.size;
	}

	private void combine(Node root, int i) {
		// TODO Auto-generated method stub
		Node leftNode=null,rightNode=null;
		if(i>0){
			leftNode=root.childs[i-1];
			rightNode=root.childs[i];
			i=i-1;
		}else{
			leftNode=root.childs[i];
			rightNode=root.childs[i+1];
		}
		int rootData = root.data[i];
		int j = leftNode.size;
		leftNode.data[j]=rootData;
		leftNode.size+=1;
		j++;
		int k = 0;
		while(k<rightNode.size){
			leftNode.data[j]=rightNode.data[k];
			leftNode.childs[j]=rightNode.childs[k];
			leftNode.size+=1;
			j++;
			k++;
		}
		leftNode.childs[j]=rightNode.childs[k];
		root.data[i]=root.data[i+1];
		shiftLeft(root, i+1);
		if(root==this.root && root.size==0)this.root=leftNode;
	}

	private void shiftRight(Node root) {
		int i = root.size;
		root.childs[i+1] = root.childs[i];
		while( i > 0){
			root.data[i] = root.data[i-1];
			root.childs[i] = root.childs[i-1];
			i--;
		}
		root.data[i] = 0;
		root.childs[i] = null;
	}

	private void shiftLeft(Node root, int j) {
		int i = j;
		for(; i < root.size-1; i++){
			root.data[i] = root.data[i+1];
			root.childs[i] = root.childs[i+1];
		}
		root.data[i] = 0;
		root.childs[i] = root.childs[i+1];
		root.size-=1;
	}

	private void deleteFromLeaf(Node root, int key, int keyIndex) {
		for(int j = keyIndex; j < root.size - 1 ; j++){
			if(root.data[j] == key){
				root.data[j] = root.data[j+1];
				key  = root.data[j];
			}
		}
		root.data[root.size-1] = 0;
		root.size-=1;
	}

	private int findSuccessor(Node root) {
		if(root == null) return -1;
		while(root.childs[0] != null){
			root = root.childs[0];
		}
		return root.data[0];
	}

	public void insert(int key)
	{
		if(this.root == null)
		{
			root = new Node();
			root.data[0] = key;
			root.size = 1 ;
			return;
		}else{
			int median = pushDown(root,key);
			if(median != -1){
				Node n = new Node();
				n.data[0] = median;
				n.size+=1;
				root=n;
				root.childs[0] = left;
				root.childs[1] =right;
			}
			left=right=null;
		}
	}

	private int pushDown(Node root, int key) {
		int median = -1;
		if(root==null) return median;
		if(root.childs[0] == null){  // Leaf node case
			if(root.size == M)//split case
				median = split(root, key); // it will split root produce left and right and then return the median
			else 
				insertInNode(root,key, -1);

			return median;
		}
		int j = searchInNode(root, key);
		median = pushDown(root.childs[j], key);
		if(median!=-1){ //split has occured below and 
			if(root.size == M){
				median  = split(root,median);

			}else{
				insertInNode(root, median, j);
				median = -1;
			}
		}
		return median;

	}

	private void insertInNode(Node root, int key, int j) {
		//j=-1 indicates insertion in leaf node otherwise internal nodes
		//this method is called when we know for this root the split is not going to happen
		//for internal nodes it handles the child pointer
		int i = j;
		int tempVal = key;
		Node tempNode = null;
		if(j==-1){
			left=right=null;
			i = 0;
			while(i<root.size){
				if(tempVal < root.data[i]){
					int x = root.data[i];
					root.data[i] = tempVal;
					tempVal = x;
				}
				i++;
			}
			root.data[i] = tempVal;

		}else if( i< root.size){
			tempVal = root.data[i];
			root.data[i] = key;
			root.childs[i] = left;
			tempNode = right;
			i++;
			while(i<root.size){
				int x = root.data[i];
				root.data[i]=tempVal;
				tempVal=x;
				Node xx = root.childs[i];
				root.childs[i] = tempNode;
				tempNode = xx;
				i++;
			}
			root.data[i] = tempVal;
			Node xx = root.childs[i];
			root.childs[i] = tempNode;
			root.childs[i+1] = xx;
		}else{
			root.data[i] = key;
			root.childs[i] = left;
			root.childs[i+1] = right;
		}
		root.size+=1;
	}

	private Node left;
	private Node right;
	private int split(Node root, int key) { //called only when the size of node = M and a key has to be inserted

		int median = -1;
		Node newLeft = new Node();
		Node newRight = new Node();
		int mid = M/2, i =0;
		int keyIndex = -1;
		//Simplying copying the data from root to newLeft ane newRight
		while(i < mid ){
			newLeft.data[i] = root.data[i];
			newLeft.childs[i] = root.childs[i];
			newLeft.size+=1;
			if(key < root.data[i] && keyIndex == -1) keyIndex = i;
			i++;
		}
		//if(keyIndex != -1) median = key;

		while(i < root.size){
			newRight.data[i-mid] = root.data[i];
			newRight.childs[i-mid] = root.childs[i];
			newRight.size+=1;
			if(key < root.data[i] && keyIndex == -1) keyIndex = i;
			i++;
		}
		newRight.childs[i-mid] = root.childs[i];
		if(keyIndex == -1) keyIndex = i;

		//shifting the data and child
		i=keyIndex;
		if(keyIndex < mid){
			median = root.data[mid-1];
			insertInNode(newLeft, key, keyIndex);
			newLeft.data[newLeft.size-1] = 0;
			newLeft.size-=1;
		}else if(keyIndex == mid){
			median = key;
			newLeft.childs[newLeft.size] = left;
			newRight.childs[0] = right;
		}else{
			median = root.data[mid];
			newLeft.childs[newLeft.size] = newRight.childs[0];
			insertInNode(newRight, key, keyIndex-mid);
			for(i =0 ; i < newRight.size-1; i++){
				newRight.data[i] = newRight.data[i+1];
				newRight.childs[i] = newRight.childs[i+1];
			}
			newRight.data[i] = 0;//not needed size will take care
			newRight.childs[i] = newRight.childs[i+1];
			newRight.childs[i+1] = null;
			newRight.size-=1;	    	
		}
		left = newLeft;
		right = newRight;

		return median;
	}
	
	
	public void traverse()
	{
		if(root==null || root.size==0) System.out.print("B-Tree is empty");
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		Node temp;
		int i = 0;
		while(!q.isEmpty()){
			temp = q.remove();
			for(i = 0; i< temp.size; i++){
				System.out.print(temp.data[i]+ " ");
				if(temp.childs[i]!= null) q.add(temp.childs[i]);
			}
			if(temp.childs[i]!= null) q.add(temp.childs[i]);
		}
		System.out.println();
	}
	public void traverseNodeData(Node root){
		if(root == null){System.out.println("Node data is empty"); return;}
		for(int i = 0 ; i < root.size; i++){
			System.out.print(root.data[i] + " ");
		}
		System.out.println();
	}

}
