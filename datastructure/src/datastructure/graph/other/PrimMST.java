package datastructure.graph.other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimMST {

	public void printMST(WeightedGraph g) {
		Comparator<Pair> byCost = (o1,o2)->Double.compare(o1.cost,o2.cost);
		PriorityQueue<Pair> pq = new PriorityQueue<>(byCost);
	   	int closest[] = new int[g.n()];
	   	double cost[] = new double[g.n()];
	   	Arrays.fill(cost, Integer.MAX_VALUE);
	   	Arrays.fill(closest, -1);
	   	int source = 0;
	   	boolean visited[] = new boolean[g.n()];
	   	cost[source]=0;
	   	for(Edge e: g.adj(source)) {
	   		closest[e.other(source)]=source;
	   		cost[e.other(source)]=e.weight();
	   		pq.add(new Pair(e.other(source),e.weight()));
	   	}
	   	visited[source]=true;
	   	boolean found = false;
	   	Pair p = null;
	   	for(int i=1; i < g.n() ; i++){
	   	   	found= false;
	   	   	while(!found) {
	   	   		p = pq.remove();
	   	   		if(!visited[p.id]) {
	   	   			found = true;
	   	   		}
	   	   	}
	   	   	visited[p.id]=true;
	   	   	for(Edge e:g.adj(p.id)) {
	   	   		int w = e.other(p.id);
	   	   		if(!visited[w]) {
	   	   			if(e.weight()<cost[w]) {
	   	   				cost[w]=e.weight();
	   	   				closest[w]=p.id;
	   	   				pq.add(new Pair(w,cost[w]));
	   	   			}
	   	   		}
	   	   	}
	   	}
	   	for(int x:closest)System.out.print(x+" ");
	   	System.out.println();
	   	for(double x:cost)System.out.print(x+" ");
	   	//System.out.println(cost);
	   	
	}
	
	static class Pair{
		int id;
		Double cost;
		Pair(int id, double cost){
			this.id = id;
			this.cost = cost;
		}
	}
	
	private Queue<Edge> mst = new LinkedList<Edge>();
	private boolean visited[];
	private PriorityQueue<Edge> pq;
	public void printLazyMST(WeightedGraph g) {
		Comparator<Edge> byEdgeWeight = (o1,o2)->Double.compare(o1.weight(), o2.weight());
		pq = new PriorityQueue<>(byEdgeWeight);
		visited = new boolean[g.n()];
		visit(g,0);
		while(!pq.isEmpty() && mst.size()<g.n()-1) {
			Edge e = pq.remove();
			int v = e.either();
			int w = e.other(v);
			if(visited[v] && visited[w])continue;
			mst.add(e);
			if(!visited[v])visit(g, v);
			else visit(g, w);
		}
		for(Edge e:mst) {
			System.out.println(e);
		}
	}
	
	private void visit(WeightedGraph g, int v) {
		visited[v]=true;
		for(Edge e:g.adj(v)) {
			int w = e.other(v);
			if(!visited[w]) {
				pq.add(e);
			}
		}
		
	}

	public static void main(String[] args) {
		WeightedGraph g = new WeightedGraph(5);
		g.addEdge(new Edge(0,1,9));
		g.addEdge(new Edge(0,2,12));
		g.addEdge(new Edge(1,2,6));
		g.addEdge(new Edge(1,3,18));
		g.addEdge(new Edge(1,4,20));
		g.addEdge(new Edge(2,4,15));
		new PrimMST().printLazyMST(g);
		System.out.println();
		new KruskalMST().printMST(g);

	}

}
