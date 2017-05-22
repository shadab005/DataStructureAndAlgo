import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	static HashMap<Integer, EdgeNode> g;
	static int count = 0;
	static boolean visited[];
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = in.nextInt();
		g = new HashMap<>();
		visited=new boolean[n];
	    for(int  i = 1; i<= n; i++){
	    	int e = in.nextInt();
	    	if(e==0){
	    		System.out.println(1);
	    		System.exit(0);
	    	}
	    	EdgeNode edge = getEdge(in.nextInt());
	    	g.put(i, edge);
	    	for(int j = 2; j<=e; j++){
	    		edge.next=getEdge(in.nextInt());
	    		edge=edge.next;
	    	}
	    }
	    //System.out.println("end");
	   // printGraph(n);
	    getCount(n);
	    in.close();

	}
	static int last=-1;
	static int sol=0;
	static void getCount(int n){
		//for(int i = 1;i<=n;i++)visited[i]=false;
		for(int i = 1; i <= n;i++){
			visited=new boolean[n];
		  count=0;
		  dfs(i);
		  if(count==n){
			  sol++;
		  }
		}
		System.out.println(sol);
	}
	
	static void dfs(int j){
		EdgeNode e=g.get(j);
		count++;
		while(e!=null){
			if(!visited[e.id]){
				visited[e.id]=true;
				dfs(e.id);
				e=e.next;////////
			}
		}
	}
	
	
	static EdgeNode getEdge(int x){
		return new EdgeNode(x);
	}
	
	static void printGraph(int n){
		//System.out.println("Here");
		for(int i = 1 ; i<= n ;i++){
			EdgeNode e = g.get(i);
			while(e!=null){
				System.out.print(e.id + " ");
				e=e.next;
			}
			System.out.println();
		}
	}
}

class EdgeNode{
	int id;
	EdgeNode next;
	EdgeNode(int x){
		id=x;
	}
}


