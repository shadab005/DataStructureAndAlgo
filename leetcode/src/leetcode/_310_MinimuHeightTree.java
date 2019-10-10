package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _310_MinimuHeightTree {

	public static void main(String[] args) {

		int n = 4;
		int edges[][] = {
			{1,0},
			{1,2},
			{1,3}
		};
		System.out.println(findMinHeightTrees(n, edges));
	}

	// First diamter end point
	static Set<Integer> endPoints = new HashSet<>();
	static int max = -1;
	static int diameter = 0;

	static public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 0)
			return Collections.emptyList();
		if (n <= 2) {
			List<Integer> ans2 = new ArrayList<>();
			for (int i = 0; i < n; i++)
				ans2.add(i);
			return ans2;
		}
		endPoints.clear();
		max = -1;
		// Graph using adjaceny matrix
		boolean adj[][] = new boolean[n][n];
		boolean visited[] = new boolean[n];
		for (int i = 0; i < edges.length; i++) {
			adj[edges[i][0]][edges[i][1]] = true;
			adj[edges[i][1]][edges[i][0]] = true;
		}
		// Getting one end point of diameter
		dfs(0, adj, 0, visited);
		int firstEndPoint = endPoints.iterator().next();
		// Get diameter length
		// Note : not intializing diamter because diameter has to be greater than >= max
		Arrays.fill(visited, false);
		endPoints.clear();
		dfs(firstEndPoint, adj, 0, visited);
		// Note : Now after the above dfs, max has the diamter length and endPoints has
		// all the end diamter
		diameter = max;
		List<Integer> ans = new ArrayList<>();
		Arrays.fill(visited, false);
		dfsToFind(firstEndPoint, adj, visited, 0, ans);
		return ans;
	}

	private static boolean dfsToFind(int i, boolean[][] adj, boolean[] visited, int cost, List<Integer> ans) {
		visited[i] = true;
		boolean isOnDiameter = false;

		for (int e = 0; e < adj[i].length; e++) {
			if (!visited[e] && adj[i][e]) {
				isOnDiameter |= dfsToFind(e, adj, visited, cost + 1, ans);
			}
		}
		// if i is the endpoint
		if (endPoints.contains(i)) return true;
		if (isOnDiameter) {
			if (diameter % 2 == 0 && diameter / 2 == cost)
				ans.add(i);
			else if (diameter % 2 != 0 && (diameter / 2 == cost || diameter / 2 == cost - 1))
				ans.add(i);
		}
		return isOnDiameter;
	}

	private static void dfs(int i, boolean[][] adj, int cost, boolean visited[]) {
		visited[i] = true;
		if (cost >= max) {
			if (cost > max) {
				max = cost;
				endPoints.clear();
				endPoints.add(i);
			}
			endPoints.add(i);
		}
		for (int e = 0; e < adj[i].length; e++) {
			if (!visited[e] && adj[i][e]) {
				dfs(e, adj, cost + 1, visited);
			}
		}
	}

}
