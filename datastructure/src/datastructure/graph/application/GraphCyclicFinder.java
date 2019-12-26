package datastructure.graph.application;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import datastructure.graph.MyGraph;
public class GraphCyclicFinder {
	
	int parent[];
	boolean visited[];
	Deque<Integer> stack;
	
	public GraphCyclicFinder(MyGraph g) {
		parent = new int[g.size()];
		visited = new boolean[g.size()];
		Arrays.fill(parent, -1);
		
		for(int v = 0; v <g.size(); v++) {
			if(!visited[v]) {
				dfs(g, v , v);
			}
		}
	}
	
	public boolean hasCycle() {
		return stack != null;
	}
	
	public Iterable<Integer> cycle() {
		if(!hasCycle()) throw new RuntimeException("Cycle doesn't exist");
		return stack;
	}

	private void dfs(MyGraph g, int p, int v) {
		visited[v] = true;
		for(int w : g.adj(v)) {
			//cycle found already
			if (stack != null) return;
			if(!visited[w]) {
				parent[w] = v;
				dfs(g, v, w);
			} else if(p!=w) {
				//this is a cycle
				stack = new ArrayDeque<>();
				for(int x = v ; x != w ; x = parent[x]) {
					stack.push(x);
				}
				stack.push(w);
				stack.push(v);
			}
		}
		
	}

	public static void main(String[] args) {
		MyGraph g = new MyGraph(5);
		g.connect(0, 2);
		g.connect(3, 2);
		g.connect(4, 2);
		g.connect(4, 1);
		
		
		GraphCyclicFinder c = new GraphCyclicFinder(g);
		if(c.hasCycle()) {
			System.out.println("Printing cycle");
			for(Integer x: c.cycle()) {
				System.out.print(x + " ");
			}
			System.out.println();
		} else {
			System.out.println("Cycle not found");
		}
	}

}
