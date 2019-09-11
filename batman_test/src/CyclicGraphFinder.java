import java.util.ArrayDeque;
import java.util.ArrayList;

public class CyclicGraphFinder {
	
	private boolean isCyclic;
	private ArrayDeque<Edge> potentialCycle;
	private Graph g;
	private boolean onStack[];
	private boolean visited[];
	private Edge edgeTo[];
	
	public CyclicGraphFinder(Graph g) {
	   this.g = g;
	   onStack = new boolean[g.nodeCount()];
	   visited = new boolean[g.nodeCount()];
	   edgeTo = new Edge[g.nodeCount()];
	   potentialCycle = new ArrayDeque<>();
	   boolean visited[] = new boolean[g.nodeCount()];
	   for(int i = 0; i < g.nodeCount() ; i++) {
		   if(!visited[i] && !hasCycle())dfsForCycle(i);
	   }
	}
	
	private int lastVisised = -1;
	private void dfsForCycle(int v) {
		visited[v] = true;
		onStack[v] = true;
		int last = lastVisised;
		for(Edge e : g.edges(v)) {
			if(isCyclic) return;
			if(last == e.other(v)) continue;
			
			if(onStack[e.other(v)]) {
				isCyclic = true;
				int w = e.other(v);
				edgeTo[w] = e;
				//build cycle
				potentialCycle = new ArrayDeque<>();
				potentialCycle.add(e);
				while(w != edgeTo[v].other(v)) {
					potentialCycle.add(edgeTo[v]);
					v = edgeTo[v].other(v);
				}
				potentialCycle.add(edgeTo[v]);
				return;
			} 
			else if(!visited[e.other(v)]) {
				edgeTo[e.other(v)] = e;
				lastVisised = v;
				dfsForCycle(e.other(v));
			}
		}
		onStack[v] = false;
		
	}

	public boolean hasCycle() {
		return isCyclic;
	}
	
	public Iterable<Edge> cycle() {
		return potentialCycle;
	}

	public static void main(String[] args) {
		
		Graph g = new Graph(5);
		g.addEdge(new Edge(0,1));
		g.addEdge(new Edge(1,2));
		g.addEdge(new Edge(2,3));
		//g.addEdge(new Edge(3,0));
		g.addEdge(new Edge(1,4));
		g.addEdge(new Edge(3,4));
		
		CyclicGraphFinder finder = new CyclicGraphFinder(g);
		System.out.println(finder.hasCycle());
		finder.cycle().forEach(System.out::println);

	}

}


class Edge{
	private int v;
	private int w;
	
	Edge(int v, int w){
		this.v = v;
		this.w = w;
	}
	
	public int either() {
		return v;
	}
	
	public int other(int o) {
		if(this.v == o) return w;
		if(this.w == o) return v;
		throw new IllegalArgumentException("Illegal end point.");
	}
	
	public String toString() {
		return "[ "+ v + " -- " + w + " ]"; 
	}
	
}

class Graph {
	
	private int nodeCount;
	private ArrayList<Edge>[] edges;//Adjacency list for graph
	@SuppressWarnings("unchecked")
	Graph(int nodeCount){
		this.nodeCount = nodeCount;
		edges =(ArrayList<Edge>[]) new ArrayList[nodeCount];
		for (int i = 0; i < nodeCount; i++) {
			edges[i] = new ArrayList<>();
		}
	}
	
	public int nodeCount() {
		return nodeCount;
	}
	
	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		edges[v].add(e);
		edges[w].add(e);
	}
	
	public Iterable<Edge> edges(int vertex) {
		return edges[vertex];
	}
}