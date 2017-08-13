import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BfsShortestReach {

	final static int cost = 6;
	static ArrayList<Integer>[] vertex;
	static int d[];
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		while(q-->0){
		   int n = in.nextInt();
		   int m = in.nextInt();
		   vertex = (ArrayList<Integer>[])new ArrayList[n];
		   d = new int[n];
		   for(int i = 0; i<n ; i++){
				vertex[i]=new ArrayList<>();
				d[i]  = -1;
				
			}
		   while(m-->0){
			 connect(in.nextInt(), in.nextInt());  
		   }
		   int source = in.nextInt()-1;
		   bfs(source, n);
		}
		in.close();

	}
	private static void bfs(int source, int n) {
		int visited[] = new int[n];
		visited[source] = 1;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(source, 0));
		while(!q.isEmpty()){
			Node x = q.remove();
			d[x.id] = x.cost;
			for(Integer z : vertex[x.id]){
				if(visited[z]==0){
					q.add(new Node(z,x.cost+6));
					visited[z] = 1;
				}
			}
		}
		for(int i = 0; i<n ;i++){
			if(i!=source)
				System.out.print(d[i] + " ");
		}
		System.out.println();
		
	}
	static void connect(int i, int j){
		vertex[i-1].add(j-1);
		vertex[j-1].add(i-1);
	}
	static class Node{
	  int id, cost;
	  Node(int ID, int COST){id = ID;cost=COST;}
	}

}
