package datastructure.graph.application;

import datastructure.graph.MyGraph;

/*
 *  First see Articulation point.
 *  
 *  Identifies bridge edges and prints them out. This decomposes
 *  a directed graph into two-edge connected components.
 *  Runs in O(E + V) time.
 *  
 */
public class BridgeCriticalNetwork {
	
	private int[] low; //low[i] is the lowest discovery time encountered due to edges in subtree of i.
    private int[] discoveryTime;
    private int cnt;
    private int bridgeCount;
	
	public BridgeCriticalNetwork(MyGraph g) {
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
				}
			} else if(c != p){
				low[u] = Math.min(low[u], discoveryTime[c]);
			}
		}
		
	}
	
	public int getBridgeCount() {
		return bridgeCount;
	}

	public static void main(String[] args) {
		MyGraph g = new MyGraph(4);
		g.connect(0, 1); 
        g.connect(2, 1); 
        g.connect(3, 2); 
        
		BridgeCriticalNetwork b = new BridgeCriticalNetwork(g);

	}

}
