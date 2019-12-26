package datastructure.graph.other;

import java.util.ArrayDeque;


//Check GraphCyclicFinder for simple solution
public class WeightedGraphCycleFinder {
	
	private ArrayDeque<Edge> stack;    // directed cycle (or null if no such cycle)
	private boolean visited[];
	private boolean[] onStack;
	private Edge[] edgeTo;
	public WeightedGraphCycleFinder(WeightedGraph g) {
		visited = new boolean[g.n()];
		onStack = new boolean[g.n()];
		edgeTo = new Edge[g.n()];
		for(int v = 0;v<g.n();v++) {
			if(!visited[v]) {
				dfs(g,v);
			}
		}
	}

	private int lastVisitNode = -1;
	private void dfs(WeightedGraph g, int v) {
		int last = lastVisitNode;
		onStack[v] = true;
		visited[v] = true;
		for(Edge e: g.adj(v)) {
			int w = e.other(v);
			//This is to avoid repeation of the same edge that 
			//was traversed in last recusrsive call. It will not be required in case of digraph.
			if(last == w)continue;
			if(isCyclic())return;
			else if(!visited[w]) {
				lastVisitNode = v;
				edgeTo[w] = e;
				dfs(g,w);
			}else if (onStack[w]) { // trace back directed cycle
               stack = new ArrayDeque<>();
               Edge edge = e;
               int i = edge.other(w);
               while(i!=w) {
            	   stack.add(edge);
            	   edge = edgeTo[i];
            	   i = edge.other(i);
               }
               stack.add(edge);
               return;
            }
			
		}
		onStack[v] = false;
	}

	public Iterable<Edge> cycle() {
        return stack;
    }
	
	public boolean isCyclic() {
		return stack != null;
	}
	
	public static void main(String[] args) {
		WeightedGraph g = new WeightedGraph(5);
		g.addEdge(new Edge(0,1,0));
		//g.addEdge(new Edge(0,4,0));
		g.addEdge(new Edge(1,2,0));
		g.addEdge(new Edge(2,3,0));
		g.addEdge(new Edge(1,4,0));
		g.addEdge(new Edge(4,3,0));
		WeightedGraphCycleFinder finder = new WeightedGraphCycleFinder(g);
		System.out.println(finder.isCyclic());
		for(Edge e : finder.cycle()) {
			System.out.println(e);
		}
		
	}

}
;