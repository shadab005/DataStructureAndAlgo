import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;


public class KarenGame {

	static class Node{
		int index;
		int sum;
		Node(int id, int sum){
			this.index=id;
			this.sum=sum;
		}
		
		@Override
		public String toString(){
			return "index = " + index +" sum = " + sum;
		}
	}
	
	public static void main(String[] args) {
		Comparator<Node> bySum = (o1,o2)->o2.sum-o1.sum; //To create max heap
		
		Scanner in = new Scanner(System.in);
		int n =  in.nextInt();
		int m = in.nextInt();
		int a[][] = new int[n][m];
		
		PriorityQueue<Node> rowSumHeap = new PriorityQueue<>(n,bySum);
		PriorityQueue<Node> colSumHeap = new PriorityQueue<>(m,bySum);
		HashMap<Integer,Integer> colIndexSumMap = new HashMap<>();
		for(int j = 0 ; j < m; j++)colIndexSumMap.put(j, 0);
		int sum = 0;
		for(int i = 0; i < n; i++){
			sum = 0;
			for(int j=0;j<m;j++){
				a[i][j] = in.nextInt();
				colIndexSumMap.put(j, colIndexSumMap.get(j)+a[i][j]);
				sum+=a[i][j];
			}
			//if(sum>=m)
			rowSumHeap.add(new Node(i,sum));
		}
		for(int j = 0 ; j < m ;j++){
		//	if(colIndexSumMap.get(j)>=n)
			colSumHeap.add(new Node(j,colIndexSumMap.get(j)));
		}
		
		System.out.println("Row Heap Info");
		for(Node node:rowSumHeap){
			System.out.println(node);
		}
		
		System.out.println("Column Heap Info");
		for(Node node:colSumHeap){
			System.out.println(node);
		}
		
		System.out.println("Solving....");
		ArrayList<String> operation = new ArrayList<>();
		
		boolean done = false;
		boolean valid = true;
		int rowdeducted = 0;
		int coldeducted = 0;
		while(!done){
			Node row = rowSumHeap.remove();
			Node col = colSumHeap.remove();
			System.out.println(row +" rowdeducted = " + rowdeducted);
			System.out.println(col +" coldeducted = " + coldeducted);
			if(row.sum-rowdeducted==0 && col.sum-coldeducted==0){
				done=true;
				break;
			}
			else if(row.sum-rowdeducted<m && col.sum-coldeducted<n){
				System.out.println("Here");
				done=true;
				valid=false;
				break;
			}
			
			if(row.sum-rowdeducted>=col.sum-coldeducted){
			  System.out.println("row selected\n");
				row.sum=row.sum-m;
				coldeducted+=1;
				operation.add("row "+(row.index+1));
			}else{
				System.out.println("col selected\n");
				col.sum=col.sum-n;
				rowdeducted+=1;
				operation.add("col "+(col.index+1));
			}
			rowSumHeap.add(row);
			colSumHeap.add(col);
		}
		
	//	System.out.println("Validity : " + valid);
		
		if(!valid){
			System.out.println(-1);
		}else{
			System.out.println(operation.size());
			for(String op : operation){
				System.out.println(op);
			}	
		}
		in.close();
	}

}
