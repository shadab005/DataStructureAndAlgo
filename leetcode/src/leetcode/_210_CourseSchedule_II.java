package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class _210_CourseSchedule_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public int[] findOrder(int n, int[][] p) {
		DiGraph g = new DiGraph(n);
		for(int i=0;i<p.length;i++) {
			g.connect(p[i][0], p[i][1]);
		}
		return g.getTopologicalOrdering();
    }
	
	
	private static class DiGraph {
		ArrayList<ArrayList<Integer>> vertex;
		int n;
		Stack<Integer> reverseDfs;
		boolean visited[];
		boolean isCyclic;
		DiGraph(int n) {
			this.n = n;
			vertex = new ArrayList<>();
			for (int i = 0; i < n; i++)vertex.add(new ArrayList<>());
		}
		
		public void connect(int first, int second) {
			vertex.get(first).add(second);
		}
		
		public int[] getTopologicalOrdering() {
			topologicalSort();
			int topological[] = new int[n];
			int i = 0;
			if(!isCyclic) {
				while (!reverseDfs.isEmpty()) {
					topological[i++] = reverseDfs.pop();
				}
			} else {
				return new int[0];
			}
			return topological;
		}
		
		public void topologicalSort() {
			visited = new boolean[n];
			boolean onStack[] = new boolean[n];
	        reverseDfs = new Stack<>();
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					dfs(i,onStack);
				}
			}
		}
		public void dfs(int v, boolean onStack[]) {
			visited[v] = true;
			onStack[v] = true;
			for (int e : vertex.get(v)) {
				if(onStack[e]) isCyclic = true;
				if (!visited[e])
					dfs(e, onStack);
			}
			reverseDfs.push(v);
			onStack[v] = false;
		}
		
	}
}
