package datastructure.graph;
import java.util.ArrayList;

public class MaxDiameterKAryTree {
	
	ArrayList<Edge>[] g;
	int n;
	
	@SuppressWarnings("unchecked")
	public MaxDiameterKAryTree(int n) {
	  g = (ArrayList<Edge>[])new ArrayList[n+1];
	  for(int i=0;i<=n;i++)g[i]=new ArrayList<>();
	  this.n=n;
	}
	
	void addEdge(int first, int second, int cost) {
		g[first].add(new Edge(second, cost));
		g[second].add(new Edge(first, cost));
	}

	public static void main(String[] args) {
	   	int n = 5;
	   	MaxDiameterKAryTree m = new MaxDiameterKAryTree(n);
	   	m.addEdge(1	, 2, 4);
	   	m.addEdge(3	, 2, 3);
	   	m.addEdge(2	, 5, 2);
	   	m.addEdge(4	, 1, 1);
	   	System.out.println(m.getDiameter(1));

	}
	/*
	  1
	 / \
	4   2           diameter : 4->1->2->3 i.e cost = 1+4+3=8
	   /  \
	  3    5
	
	*/
	private int max=0;
	public int getDiameter(int source) {
		max=0;
		boolean visited[] = new boolean[n+1];
		int ans = dfs(source, visited);
		return Math.max(ans, max);
	}

	private int dfs(int source, boolean visited[]) {
		int fMax=0;
		int sMax=0;
		visited[source]=true;
		for(Edge e: g[source]) {
			if(!visited[e.id]) {
				int cost = dfs(e.id, visited)+e.cost;
				if(cost>=fMax) {
					sMax=fMax;
					fMax=cost;
				}else if(cost>sMax) {
					sMax=cost;
				}
			}
		}
		max=Math.max(max, fMax+sMax);
		return fMax;
	}

	class Edge{
		int id;
		int cost;
		Edge(int id, int cost){
			this.id=id;
			this.cost=cost;
		}
	}
	
}
