package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _207_CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public boolean canFinish(int n, int[][] p) {
		Graph g = new Graph(n);
		for(int  i = 0 ; i < p.length; i++) {
			g.connect(p[i][0], p[i][1]);
		}
		return !g.isCyclic();
	}

	private static class Graph {
		private int n = 0;
		public ArrayList<Integer>[] vertex;

		@SuppressWarnings("unchecked")
		Graph(int n) {
			this.n = n;
			ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n];
			for (int i = 0; i < n; i++)
				a[i] = new ArrayList<>();
		}

		public void connect(int v, int w) {
			vertex[v].add(w);
		}

		public List<Integer> edges(int v) {
			return vertex[v];
		}

		public boolean isCyclic() {
			boolean visited[] = new boolean[n];
			boolean onStack[] = new boolean[n];
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					boolean cycleFound = dfs(i, visited, onStack);
					if (cycleFound)
						return true;
				}
			}
			return false;
		}

		private boolean dfs(int v, boolean[] visited, boolean[] onStack) {
			visited[v] = true;
			onStack[v] = true;
			for (int e : edges(v)) {
				if (onStack[e])
					return true;
				if (!visited[e]) {
					boolean cycleFound = dfs(e, visited, onStack);
					if (cycleFound)
						return true;
				}
			}
			onStack[v] = false;
			return false;
		}
	}

}
