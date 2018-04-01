package datastructure.intervalsearchtree;

/*
 * Assumption: No two interval have same left end point
 * 
 * Idea: 
 * 1. Use left end point as binary search tree key
 * 2. Store maximum end point in subtree rooted at node
 * 
 */
public class IntervalSearchTree {

	Node root;
	public IntervalSearchTree() {
		
	}
	//Key lo, Key hi, Value value
	public void put(int lo, int hi, int value) {
		if(root==null)root=new Node(lo,hi,value);
		else {
			
		}
	}
	
	//Key lo, Key hi
	public int get(int lo, int hi) {
		
		return 0;
	}
	
	//Key lo, Key hi 
	public void delete(int lo, int hi) {
		
	}
	
	// return Iterable<Value>. Key lo, Key hi
	Iterable<Integer> intersects(int lo, int hi){
	
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
