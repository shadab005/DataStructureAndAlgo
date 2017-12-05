package datastructure.graph;

import java.util.ArrayList;
import java.util.Stack;


/*
 * Topological Sort - Notes in Graph class
 * Strongly Connected
 * Vertex v and w are strongly connected if there is a directed path from v to w 
 * and there is a directed path from w to v. So it is equivalence relation(reflexive, symettric, transitive)
 * 
 * Kosaraju-Sharir algorithm
 * Compute topological order (reverse dfs)
 * Compute dfs considering considering vertices in topological order
 */
public class DiGraph {
	ArrayList<ArrayList<Integer>> vertex;
	int n;

	Stack<Integer> reverseDfs;
	boolean visited[];
	DiGraph(int n) {
		this.n = n;
		vertex = new ArrayList<>();
		for (int i = 0; i < n; i++)
			vertex.add(new ArrayList<>());
	}

	// Connection first to second because it is a diagraph
	public void connect(int first, int second) {
		vertex.get(first).add(second);
	}
	
	public void printTopologicalSort() {
		topologicalSort();	
		while (!reverseDfs.isEmpty()) {
			System.out.print(reverseDfs.pop() + " ");
		}
		System.out.println();
	}

	// A digraph has topppolical order iff no directed cylcle
	public void topologicalSort() {
		
		visited = new boolean[n];
        reverseDfs = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}
	
	int scc[];
	int count = 0;
	public void preporcessingForStronglyConnected() {
		count = 0;
		scc = new int[n];
		topologicalSort();
		visited = new boolean[n];
		System.out.println("Topo stack is ");
		System.out.println(reverseDfs);
		for(int x : reverseDfs) {
			if(!visited[x]) {
				System.out.println("Dfsing on node : " + x);
				depthFirstTraversal(x);
				count++;
			}
		}
		for(int i=0;i<n;i++) {
			System.out.println(i+ "  " + scc[i]);
		}
	}
	
	private void depthFirstTraversal(int x) {
		visited[x] = true;
		scc[x]=count;
		for (int e : vertex.get(x)) {
			if (!visited[e])
				depthFirstTraversal(e);
		}
	}

	public boolean isStronglyConnected(int v, int w) {
		
		return true;
	}

	public void dfs(int v) {
		visited[v] = true;
		for (int e : vertex.get(v)) {
			if (!visited[e])
				dfs(e);
		}
		reverseDfs.push(v);
	}
	
	public static void main(String[] args) {
		test2();
		

	}
	
	static void test2() {
		DiGraph g = new DiGraph(13);
		g.connect(0, 1);
		g.connect(0, 5);
		
		g.connect(2, 0);
		g.connect(2, 3);
		
		g.connect(3, 2);
		g.connect(3, 5);
		
		g.connect(4, 2);
		g.connect(4, 3);
		
		g.connect(5, 4);
		
		g.connect(6, 0);
		g.connect(6, 4);
		g.connect(6, 8);
		g.connect(6, 9);
		
		g.connect(7, 6);
		g.connect(7, 9);
		
		g.connect(8, 6);
		
		g.connect(9, 10);
		g.connect(9, 11);
		
		g.connect(10, 12);
		
		g.connect(11, 4);
		g.connect(11, 12);
		
		g.connect(12, 9);
		
		g.printTopologicalSort();
		g.preporcessingForStronglyConnected();
	}
	
    static void test1() {
    	DiGraph g = new DiGraph(7);
		g.connect(0, 2);
		g.connect(0, 5);
		g.connect(0, 1);
		g.connect(1, 4);
		g.connect(3, 2);
		g.connect(3, 5);
		g.connect(3, 4);
		g.connect(3, 6);
		g.connect(5, 2);
		g.connect(6, 0);
		g.connect(6, 4);
		g.printTopologicalSort();
    }

}
