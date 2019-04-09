package javaconcepts.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
  -- Styles of writing lambda comparator 
Comparator<Duck> byWeight = (d1, d2) -> d1.getWeight()-d2.getWeight();
Comparator<Duck> byWeight = (d1, d2) -> { return d1.getWeight()-d2.getWeight(); };
Comparator<Duck> byWeight = (Duck d1, Duck d2) -> d1.getWeight()-d2.getWeight();
Comparator<Duck> byWeight = (Duck d1, Duck d2) -> {return d1.getWeight()-d2.getWeight();};
*/
public class LambdaComparatorExample {

	static class Node{
		int id;
		int sum;
		Node(int id, int sum){
			this.id=id;
			this.sum=sum;
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Node> al=new ArrayList<>();
		al.add(new Node(1,15));
		al.add(new Node(2,6));
		al.add(new Node(3,4));
		al.add(new Node(4,12));
		
		/*
		 * Sort Without Lambda using anonymous class
		 */
		Collections.sort(al, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.sum-o2.sum;
			}
		});
		
		for(Node n: al){
			System.out.println("Node id : " + n.id +" sum : " + n.sum);
		}
		
		/*
		 * Sorting with proper class
		 */
        Collections.sort(al, new NodeComparator());
		
		for(Node n: al){
			System.out.println("Node id : " + n.id +" sum : " + n.sum);
		}
		
		/*
		 * In Java 8, the List interface is supports the sort method directly, no need to use collection
		 */
		al.sort(new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2) {
				return o1.sum-o2.sum;
			}
		});
		
		
		/*
		 * Sorting using Lambda
		 * Comparator<Node> byName =(Node o1, Node o2)->o1.getName().compareTo(o2.getName());
		 */
		Comparator<Node> bySum = (o1, o2)->o1.sum-o2.sum;
		al.sort(bySum);
		//or
		al.sort((Node o1, Node o2)->o1.sum-o2.sum);
		for(Node n: al){
			System.out.println("Node id : " + n.id +" sum : " + n.sum);
		}
		

	}
	
	static class NodeComparator implements Comparator<Node>{

		@Override
		public int compare(Node n1, Node n2) {
			if(n1.sum==n2.sum)return 0;
			if(n1.sum > n2.sum)return 1;
			else return -1;
		}
		
	}

}
