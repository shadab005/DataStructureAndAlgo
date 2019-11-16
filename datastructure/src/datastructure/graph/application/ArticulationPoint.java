package datastructure.graph.application;

import datastructure.graph.MyGraph;

/*
 * An articulation point is a vertex whose removal and it's edges will leave the graph in two disconnected component
 * 
 * A O(V+E) algorithm to find all Articulation Points (APs)
 * In DFS tree, a vertex u is articulation point if one of the following two conditions is true.
 * 1) u is root of DFS tree and it has at least two child subtree and these two child subtree should be disjoint.
 * 2) u is not root of DFS tree and it has a child v such that no vertex in subtree rooted with v has a back edge to one of the ancestors (in DFS tree) of u.
 * 
 * To check if there is a backEdge we maintain discovery time, and for each vertex we also maintain the lowest discovery time it has encountered in its subtree
 * 
 * No backedge to ancestor of u in subtree of u if:
 * lowest discovery time subtree has encountered >= discovery time of u
 * 
 * Update the lowest discovery time of u 
 * 
 * Biconnectivity: An articulation vertex (or cut vertex) is a vertex whose removal increases the number of connected components.
 * A graph is biconnected if it has no articulation vertices. It uses depth-first search to find the bridges and articulation vertices. 
 * It takes time proportional to V + E in the worst case.
 * 
 */

public class ArticulationPoint {
	
	private int[] low; //low[i] is the lowest discovery time encountered due to edges in subtree of i.
    private int[] discoveryTime;
    private int cnt;
    private boolean[] articulation;
	
	public ArticulationPoint(MyGraph g) {
		 low = new int[g.size()];
	     discoveryTime = new int[g.size()];
	     articulation = new boolean[g.size()];
	     
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
		int childComponent = 0;
		
		
		for(int c : g.adj(u)) {
			if(discoveryTime[c] == -1) {
				childComponent++;
				dfs(g, u, c);
				low[u] = Math.min(low[u], low[c]);
				if (low[c] >= discoveryTime[u] && u != p) {
					articulation[u] = true;
				}
			} else if(c != p){
				low[u] = Math.min(low[u], discoveryTime[c]);
			}
		}
		// root of DFS is an articulation point if it has more than 1 child
        if (u == p && childComponent > 1)
            articulation[u] = true;
	}
	

	public static void main(String[] args) {
		MyGraph g = new MyGraph(6);
		g.connect(0, 1);
		g.connect(0, 3);
		g.connect(1, 2);
		g.connect(3, 2);
		g.connect(2, 4);
		g.connect(2, 5);
		g.connect(4, 5);
		
		ArticulationPoint ap = new ArticulationPoint(g);
		for(int i = 0 ; i < g.size() ; i++) {
			if(ap.articulation[i]) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
		

	}

}
