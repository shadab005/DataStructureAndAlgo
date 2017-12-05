package datastructure.graph.other;

import java.util.ArrayList;

public class WeightedGraph {

	private int n = 0; // No. of vertices
	private int e = 0; // No. of edges
	private ArrayList<Edge>[] vertex;

	@SuppressWarnings("unchecked")
	public WeightedGraph(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Number of vertices must be nonnegative");
		this.n = n;
		vertex = (ArrayList<Edge>[]) new ArrayList[n];
		for (int v = 0; v < n; v++) {
			vertex[v] = new ArrayList<Edge>();
		}
	}
	
	public Iterable<Edge> adj(int v){
		return vertex[v];
	}

	public int edgeCount() {
		return e;
	}

	public int n() {
		return n;
	}

	public int degree(int v) {
		return vertex[v].size();
	}

	public void addEdge(Edge edge) {
		int v = edge.either();
		int w = edge.other(v);
		vertex[v].add(edge);
		vertex[w].add(edge);
		e++;
	}

	public Iterable<Edge> edges() {
		ArrayList<Edge> list = new ArrayList<Edge>();
		for (int v = 0; v < n; v++) {
			int selfLoops = 0;
			for (Edge e : vertex[v]) {
				if (e.other(v) > v) {
					list.add(e);
				}
				// add only one copy of each self loop (self loops will be consecutive)
				else if (e.other(v) == v) {
					if (selfLoops % 2 == 0)
						list.add(e);
					selfLoops++;
				}
			}
		}
		return list;
	}

	public String toString() {
		String NEWLINE = System.getProperty("line.separator");
		StringBuilder s = new StringBuilder();
		s.append(n + " " + e + NEWLINE);
		for (int v = 0; v < n; v++) {
			s.append(v + ": ");
			for (Edge e : vertex[v]) {
				s.append(e + "  ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}

	public static void main(String[] args) {
		
		WeightedGraph g = new WeightedGraph(5);
		g.addEdge(new Edge(0,1,9));
		g.addEdge(new Edge(0,2,12));
		g.addEdge(new Edge(1,2,8));
		g.addEdge(new Edge(1,3,18));
		g.addEdge(new Edge(1,4,20));
		g.addEdge(new Edge(2,4,15));
		System.out.println(g);

	}

}
