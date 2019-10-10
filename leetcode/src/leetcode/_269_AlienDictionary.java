package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class _269_AlienDictionary {

	public static void main(String[] args) {
		String words[] = new String[] {"z", "x", "z"};
		System.out.println(alienOrder(words));

	}
	
	static public String alienOrder(String[] w) {
		if(w.length == 0) return "";
		if(w.length == 1) return w[0];
		DiGraph g = new DiGraph(26);//26 aplhabets
		for(int i=1;i<w.length;i++) {
			process(w[i-1],w[i], g);
		}
		if(g.isCyclic) return "";
		int topological[] = g.getTopologicalOrdering();
		return Arrays.stream(topological).filter(g::exists).mapToObj(i->""+Character.valueOf((char) (i+'a'))).collect(Collectors.joining());
	}
	
	private static void process(String first, String second, DiGraph g) {
		int i = 0, j =0;
		while( i < first.length() && j < second.length() && first.charAt(i)==second.charAt(j)) {
			g.addVertex(first.charAt(i)-'a');
			g.addVertex(second.charAt(j)-'a');
			i++;
			j++;
		}
		if( i < first.length() && j < second.length()) {
			g.connect(first.charAt(i)-'a', second.charAt(j)-'a');
			i++;
			j++;
		}
		while( i < first.length()) {
			g.addVertex(first.charAt(i)-'a');
			i++;
		}
		while(j<second.length()) {
			g.addVertex(second.charAt(j)-'a');
			j++;
		}
	}
	

	private static class DiGraph {
		ArrayList<ArrayList<Integer>> vertex;
		int n;
		Stack<Integer> reverseDfs;
		boolean visited[];
		boolean isCyclic;
		boolean exists[];
		DiGraph(int n) {
			this.n = n;
			exists = new boolean[26];
			vertex = new ArrayList<>();
			for (int i = 0; i < n; i++)vertex.add(new ArrayList<>());
		}
		
		boolean exists(int x) {
			return exists[x];
		}
		
		public void addVertex(int v) {
			exists[v] = true;
		}
		
		public void connect(int first, int second) {
			exists[first] = true;
			exists[second] = true;
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
