package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

import algo.util.Util;


public class _834_SumofDistances {

	public static void main(String[] args) {
		
		int n = 6;
		int e[][] = new int[][]{
			{0,1},{0,2},{2,3},{2,4},{2,5}
		};
		int ans[] = sumOfDistancesInTree(n, e);
		Util.printArray(ans);
		//[6,6,4,4]

	}
	
	static public int[] sumOfDistancesInTree(int n, int[][] edges) {
        Graph g = new Graph(n);
        for(int i=0;i<edges.length;i++) {
        	g.connect(edges[i][0], edges[i][1]);
        }
        return getSumOfDistancesInTree(g);
    }
	
	
	
	private static int[] getSumOfDistancesInTree(Graph g) {
		//should start from node 0 and each node should be populated by number of children and sum of distances from children
		HashMap<Integer, NodeInfo> info = new HashMap<>();
		gatherInfo(g,0, -1, info);
		scatterInfo(g,0, -1, info);
	    int ans[] = new int[g.size()];
	    for(int i = 0; i < ans.length; i++) {
	    	ans[i] = info.get(i).sumOfDistance;
	    }
		return ans;
	}



	private static void scatterInfo(Graph g, int v, int p, HashMap<Integer, NodeInfo> gatherInfo) {
		
		//update the node sumOfDistance, childCount if parent is not -1;
		if(p!=-1) {
			NodeInfo thisNodeInfo = gatherInfo.get(v);
			NodeInfo parentNodeInfo = gatherInfo.get(p);
			thisNodeInfo.sumOfDistance = parentNodeInfo.sumOfDistance - thisNodeInfo.childCount - 1 + (g.size() - thisNodeInfo.childCount-1); 
			gatherInfo.put(v, thisNodeInfo);
		}
		
		for(int u : g.adj(v)) {
			if(u!=p) {
				scatterInfo(g, u, v, gatherInfo);
			}
		}
		
	}

	private static NodeInfo gatherInfo(Graph g, int v, int p, HashMap<Integer, NodeInfo> info) {
		
		int childCount = 0;
		int sumOfDistances = 0;
		for(int u : g.adj(v)) {
			if(u!=p) {
				NodeInfo nodeInfo = gatherInfo(g, u, v, info);
				childCount += nodeInfo.childCount+1;
				sumOfDistances += nodeInfo.sumOfDistance+nodeInfo.childCount+1;
			}
		}
		NodeInfo thisNodeInfo = new NodeInfo(sumOfDistances, childCount);
		info.put(v, thisNodeInfo);
		return thisNodeInfo;
	}


	private static class NodeInfo {
		private int sumOfDistance;
		private int childCount;
		
		public NodeInfo(int sum, int count) {
			sumOfDistance = sum;
			childCount = count;
		}
		
		@Override
		public String toString() {
			return "{"+ sumOfDistance + ", " + childCount +  "}";
		}
	}

	private static class Graph {

		private int n = 0;
		//Graph using array of ArrayList
		public ArrayList<Integer>[] vertex;
		
		@SuppressWarnings("unchecked")
		public Graph(int n){
			this.n = n;
			ArrayList<Integer>[] a = (ArrayList<Integer>[])new ArrayList[n];
			for(int i=0;i<n;i++)a[i]=new ArrayList<>();
			this.vertex = a;
		}
		
		public void connect(int v, int w) {
			vertex[v].add(w);
			vertex[w].add(v);
		}
		
		public Iterable<Integer> adj(int v){
			return vertex[v];
		}
		
		public int size() {
			return n;
		}

	}

}
