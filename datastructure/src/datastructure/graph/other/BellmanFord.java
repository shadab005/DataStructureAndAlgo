package datastructure.graph.other;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/*
 * Calculates shortest path in a graph with negative edges.
 * Note: Shortest path exist only if there is no negative cycle in a graph.
 * 
 * for (int i = 0; i < g.totalVertex(); i++) {
		for (int j = 0; j < g.totalVertex(); j++) {
			for (Edge e : g.adj(j)) {
				relax(e);
			}
		}
	}
 * 
 * If distanceTo[v] doesn't change during pass i, then no need to relax any edge pointing from 
 * v in i+1 edge
 * 
 * To solve this maintain queue of vertices whos distTo[] changed.
 * Be careful to keep only one copy of each vertex on queue.
 * 
 * Shortest path in undirected graph with negative edge makes little less sense. (1,2,1), (1,3,1), (2,3,-1)
 * 
 */
public class BellmanFord {

	private double distTo[]; // distTo[v] = distance  of shortest s->v path
	private Edge edgeTo[]; // edgeTo[v] = last edge on shortest s->v path
	private boolean[] onQueue; // onQueue[v] = is v currently on the queue?
	private Queue<Integer> queue;          // queue of vertices to relax
	private int cost;                      // number of calls to relax()
    private Iterable<Edge> cycle;  // negative cycle (or null if no such cycle)
	
	public BellmanFord(WeightedGraph g, int s) {
		distTo = new double[g.n()];
		edgeTo = new Edge[g.n()];
		onQueue = new boolean[g.n()];
		queue = new ArrayDeque<>();
	    
		Arrays.fill(distTo, Integer.MAX_VALUE);
		
		distTo[s] = 0;
		queue.add(s);
		onQueue[s] = true;
		while(!queue.isEmpty() && !hasNegativeCycle()) {
			System.out.println("Lol");
			int v = queue.remove();
			onQueue[v] = false;
			relax(g,v);
		}
	}
	
	private void relax(WeightedGraph g, int v) {
		Edge edge = edgeTo[v];
		int parentOfV = -1;
		if(edge!=null) {
			//This is required in undirected graph so that once the we enconter negative edge
			//it should keep on oscillating
			parentOfV = edge.other(v);
		}
		for(Edge e: g.adj(v)) {
			int w = e.other(v);
			if(w==parentOfV)continue;
			if(distTo[w] > distTo[v]+e.weight()) {
				distTo[w] = distTo[v]+e.weight();
				edgeTo[w] = e;
				if(!onQueue[w]) {
					queue.add(w);
					onQueue[w] = true;
				}
			}
			if (cost++ % g.n() == 0) {
                findNegativeCycle();
                if (hasNegativeCycle()) return;  // found a negative cycle
            }
		}
	}
	
	//Returns the length of a shortest path from the source vertex
	public double distTo(int v) {
		validateVertex(v);
		if (hasNegativeCycle()) throw new UnsupportedOperationException("Negative cost cycle exists");
		return distTo[v];
	}

	private void findNegativeCycle() {
		int n = edgeTo.length;
		WeightedGraph wg = new WeightedGraph(n);
		for (int v = 0; v < n; v++) {
			if (edgeTo[v] != null) wg.addEdge(edgeTo[v]);
		}
		WeightedGraphCycleFinder finder = new WeightedGraphCycleFinder(wg);
		cycle = finder.cycle();
	}

	private boolean hasNegativeCycle() {
		if(cycle != null)System.out.println("Graph has negative cycle. Bellman ford can't be aplied");
		return cycle != null;
	}
	
	// throw an IllegalArgumentException unless {@code 0 <= v < V}
	private void validateVertex(int v) {
        int V = distTo.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

	public static void main(String[] args) {
		int n = 5;
		WeightedGraph g = new WeightedGraph(n);
	/*	g.addEdge(new Edge(0, 1, 2));
		g.addEdge(new Edge(0, 2, 4));
		g.addEdge(new Edge(2, 1, -3));
		*/
		g.addEdge(new Edge(0,1,3));
		g.addEdge(new Edge(0,4,2));
		g.addEdge(new Edge(0,2,-1));
		g.addEdge(new Edge(1,2,2));
		g.addEdge(new Edge(4,2,8));
		g.addEdge(new Edge(3,2,1));
		
		g.addEdge(new Edge(3,4,-2));
		BellmanFord b = new BellmanFord(g, 0);
		for(int i =0 ;i<n;i++) {
			System.out.println("["+i+"]="+b.distTo[i]);
		}
	}

}
