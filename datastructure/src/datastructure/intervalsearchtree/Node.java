package datastructure.intervalsearchtree;

public class Node {
	
	int low;
	int high;
	int value;
	
	Node left;
	Node right;
	
	public Node(int low, int high, int value) {
		this.low = low;
		this.high = high;
		this.value = value;
	}

}
