package datastructure.trees.application;

import java.util.LinkedList;
import java.util.Queue;

import datastructure.trees.Tree;

public class RangeSearch extends Tree{

	Node root;
	static class Node{
       int key;
       Node left;
       Node right;
       int size;//Total number of children
       Node(int key){
    	   this.key=key;
    	   size=1;
       }
       
       @Override
       public String toString() {
    	   return "["+key+" " + size + " ]";
       }
	}
	
	public void add(int k) {
		Node n = new Node(k);
		if(root==null) {
			root = n;
		}else {
			Node ptr  = root;
			Node preptr = root;
			while(ptr!=null) {
				preptr=ptr;
				if(ptr.key>n.key) {
					ptr.size++;
					ptr=ptr.left;
				}else if(ptr.key<n.key){
					ptr.size++;
					ptr=ptr.right;
				}else {
					System.out.println("Duplicate key case");
					return;
				}
			}
			if(preptr.key>n.key) {
				preptr.left=n;
			}else {
				preptr.right=n;
			}
		}
		
	}
	
	void levelOrder(Node root){
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Node temp;
		while(!q.isEmpty()){
			temp = q.remove();
			System.out.print(temp + " ");
			if(temp.left != null) q.add(temp.left);
			if(temp.right != null) q.add(temp.right);
		}
	}
	
	public void preOrder(Node root) {
		if (root != null) {
			System.out.print(root + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public int rank(int key) {
		return rank(key,root);
	}
	
	

	private int rank(int key, Node node) {
		if(node==null)return 0;
		if(key<node.key) {
			return rank(key,node.left);
		}else if(key>node.key) {
			return 1+size(node.left)+rank(key,node.right);
		}else {
		    return size(node.left);	
		}
	}
	
	public int rangeCount(int low, int high) {
		if(contains(high)) return rank(high)-rank(low)+1;
		return rank(high)-rank(low);
	}

	private boolean contains(int key) {
		return contains(key,root);
	}

	private boolean contains(int key, Node node) {
		if(node==null)return false;
		if(key<node.key)return contains(key,node.left);
		else if(key>node.key)return contains(key,node.right);
		else return true;
	}

	private int size(Node node) {
		if(node!=null)return node.size;
		return 0;
	}
	
	public void rangeSearch(int low, int high) {
		Queue<Integer> q = new LinkedList<>();
		rangeSearh(root,q,low,high);
		System.out.println(q);
	}

	//Doing inorder traversal and if the element lies in between adding it to the queue
	private void rangeSearh(Node node, Queue<Integer> q, int low, int high) {
		if(node==null)return;
		if(low<node.key)rangeSearh(node.left, q, low, high);
		if(low<=node.key && node.key<=high)q.add(node.key);
		if(high>node.key)rangeSearh(node.right, q, low, high);
	}

	public static void main(String[] args) {
		RangeSearch rs = new RangeSearch();
		rs.add(19);
		rs.add(5);
		rs.add(24);
		rs.add(1);
		rs.add(18);
		rs.add(3);
		rs.add(8);
		rs.add(13);
		//rs.preOrder(rs.root);
	 //   rs.levelOrder(rs.root);
	    //System.out.println(rs.rank(20));
	    System.out.println(rs.rangeCount(4, 19));
	    rs.rangeSearch(5, 20);

	}


}
