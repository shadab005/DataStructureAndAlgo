package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1192_CriticalConnectionsInNetwork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

		MyGraph g = new MyGraph(n);
		connections.forEach(l -> g.connect(l.get(0), l.get(1)));
		BridgeCriticalNetwork cn = new BridgeCriticalNetwork(g);
		return cn.getBridges();
	}
	
	static class BridgeCriticalNetwork {
		
		private int[] low; //low[i] is the lowest discovery time encountered due to edges in subtree of i.
	    private int[] discoveryTime;
	    private int cnt;
	    private int bridgeCount;
	    List<List<Integer>> bridges; 
		public BridgeCriticalNetwork(MyGraph g) {
			bridges = new ArrayList<>();
			 low = new int[g.size()];
		     discoveryTime = new int[g.size()];
		     
		     for (int v = 0; v < g.size(); v++)
		            low[v] = -1;
		        for (int v = 0; v < g.size(); v++)
		            discoveryTime[v] = -1;
		        
		        for (int v = 0; v < g.size(); v++)
		            if (discoveryTime[v] == -1)
		                dfs(g, v, v);
		}
		
		//p is the parent from which we have come to u
		private void dfs(MyGraph g, int p, int u) {
			discoveryTime[u] = cnt++;
			low[u] = discoveryTime[u];
			
			for(int c : g.adj(u)) {
				if(discoveryTime[c] == -1) {
					dfs(g, u, c);
					low[u] = Math.min(low[u], low[c]);
					if(low[c] == discoveryTime[c]) {
						System.out.println(u + " -- " + c + " is the bridge");
						bridgeCount++;
						bridges.add(Arrays.asList(u,c));
					}
				} else if(c != p){
					low[u] = Math.min(low[u], discoveryTime[c]);
				}
			}
			
		}
		
		public int getBridgeCount() {
			return bridgeCount;
		}
		
		public List<List<Integer>> getBridges() {
			return bridges;
		}

	}

	static class MyGraph {

		private int n = 0;
		// Graph using array of ArrayList
		public ArrayList<Integer>[] vertex;

		@SuppressWarnings("unchecked")
		public MyGraph(int n) {
			this.n = n;
			ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n];
			for (int i = 0; i < n; i++)
				a[i] = new ArrayList<>();
			this.vertex = a;
		}

		public void connect(int v, int w) {
			vertex[v].add(w);
			vertex[w].add(v);
		}

		public Iterable<Integer> adj(int v) {
			return vertex[v];
		}

		public int size() {
			return n;
		}

		public int degree(int v) {
			return vertex[v].size();
		}

	}

}
