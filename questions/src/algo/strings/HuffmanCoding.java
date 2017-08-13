package algo.strings;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class HuffmanCoding {

	public static void main(String[] args) {
		char arr[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
	    int freq[] = { 5, 9, 12, 13, 16, 45 };
	    int size = arr.length;
	    new HuffmanCoding().generateHuffmanCode(arr,freq,size);
	}

	public void generateHuffmanCode(char[] arr, int[] freq, int n) {
		System.out.println("Solving");
			Comparator<Node> byFreq = (o1,o2)->o1.freq-o2.freq;
			PriorityQueue<Node> pq = new PriorityQueue<>(byFreq);
			Node temp;
			for(int i=0;i<n;i++){
				pq.add(new Node(arr[i],freq[i]));
			}
			
			for(int i=1 ;i<n;i++){
				temp = new Node();
				temp.left = pq.remove();
				temp.right = pq.remove();
				temp.freq=temp.left.freq+temp.right.freq;
				pq.add(temp);
			}
			
			//System.out.println(pq.peek().freq);
			//System.out.println(pq.size());
			
			printTree(pq.peek());
			printCode(pq.peek(), new Stack<Integer>());
		
	}
	
	private void printTree(Node root) {
		if(root!=null){
			printTree(root.left);
			System.out.println(root.freq);
			printTree(root.right);
		}
	}

	private void printCode(Node root, Stack<Integer> s) {
		if(root!=null){
			if(root.left==null && root.right==null){
				System.out.println(root.c +" : " + s);
				return;
			}
			s.push(0);
			printCode(root.left, s);
			s.pop();
			s.push(1);
			printCode(root.right, s);
			s.pop();
			
		}
		
	}

	static class Node{
		char c;
		int freq;
		Node left,right;
		Node(){}
		Node(char c, int freq){
			this.c=c;
			this.freq=freq;
		}
	}

}
