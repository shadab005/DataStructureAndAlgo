package datastructure.graph.other;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import datastructure.unionfind.UnionFind;

public class KruskalMST {

	private Queue<Edge> mst = new LinkedList<Edge>();
	public void printMST(WeightedGraph g) {
		Comparator<Edge> byEdgeWeight = (o1,o2)->Double.compare(o1.weight(), o2.weight());
		PriorityQueue<Edge> pq = new PriorityQueue<>(byEdgeWeight);
		for(Edge e:g.edges()) {
			pq.add(e);
		}
		//Coloring the graph will not work.
		UnionFind uf = new UnionFind(g.n());
		while(!pq.isEmpty() && mst.size()<g.n()-1) {
			Edge e = pq.remove();
			int v = e.either();
			int w = e.other(v);
			if(uf.isConnected(v, w))continue;
			uf.union(v, w);
			mst.add(e);
		}
		
		for(Edge e:mst) {
			System.out.println(e);
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
		//System.out.println(g);
		new KruskalMST().printMST(g);

	}

}
