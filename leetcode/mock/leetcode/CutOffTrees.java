package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CutOffTrees {

	//[[2,3,4],[0,0,5],[8,7,6]] =>6
	public static void main(String[] args) {
		List<List<Integer>> f = new ArrayList<>();
		f.add(Arrays.asList(2,3,4));
		f.add(Arrays.asList(0,0,5));
		f.add(Arrays.asList(8,7,6));
		System.out.println(cutOffTree(f));

	}
	
	static public int cutOffTree(List<List<Integer>> forest) {
     
		int m = forest.size();
		int n = forest.get(0).size();
		
		Comparator<Grid> byHeight = (a,b)->a.value-b.value;
		PriorityQueue<Grid> pq = new PriorityQueue<>(byHeight);
		for(int i = 0; i< m ;i++) {
			for(int j = 0; j < n ; j++) {
				if(forest.get(i).get(j)>1) {
					//System.out.printf("Adding %d %d %d", forest.get(i).get(j), i, j);
					//System.out.println();
					pq.add(new Grid(forest.get(i).get(j), i, j));
				}
			}
		}
		int fromPosition = 0;
		//System.out.println("pq.peek().x " +  pq.peek().x);
		//System.out.println("pq.peek().y " +  pq.peek().y);
		//System.out.println("pq.remove() " +  pq.remove());
		//if(pq.peek().x == 0 && pq.peek().y == 0) ans = -1;
		while(!pq.isEmpty()) {
			Grid target = pq.remove();
			int target_i = target.x;
			int target_j = target.y;
			//System.out.println("From x = " + fromPosition/n + " y = " + fromPosition%n +" Target x= " + target_i + " y = " +  target_j + " ans = " + ans);
			fromPosition = bfs(forest, fromPosition, target_i, target_j);
			if(fromPosition == -1) return -1;
		}
		return ans; 
    }
	
	static int ans = 0;
	
	private static int bfs(List<List<Integer>> forest, int fromPosition, int x, int y) {
		Queue<Integer> q = new ArrayDeque<>();
		int M = forest.size();
		int N = forest.get(0).size();
		boolean visited[] = new boolean[M*N+1];
		q.add(fromPosition);
		visited[fromPosition] = true;
		int size = 0;
		ans--;
		while(!q.isEmpty()) {
			
			size = q.size();
			ans++;
			while(size-->0) {
				int p = q.remove();
				int p_i = p/N;
				int p_j = p%N;
				//System.out.println("BFS x = " + p_i + " y = " + p_j);
				if(p_i == x && p_j == y) return p;
				for(int pos[] : adj) {
					int _i = p_i+pos[0];
					int _j = p_j+pos[1];
					int _oneD = xyTo1D(_i, _j, N);
					//System.out.println("Next position = " + _i +", " + _j);
					if(isValid(_i,_j, M, N) && !visited[_oneD] && forest.get(_i).get(_j)!=0) {
					//	System.out.println("Next valid position = " + _oneD/N + ", " + _oneD%N);
						visited[_oneD]  = true;
						q.add(_oneD);
					}
				}
			}
		}
		return -1;
	}

	private static boolean isValid(int i, int j, int m, int n) {
		return i>=0 && i <m && j>=0 && j<n;
	}

	static int adj[][] = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	static int xyTo1D(int x, int y, int n) {
		return (x) * n + y;
	}
	
	static class Grid {
		Grid(int v, int a, int b) {
			value = v;
			x = a;
			y = b;
		}
		int value;
		int x;
		int y;
		public String toString() {
			return "Grid x = " + x + " y = " + y;
		}
	}
	/*
	static class Graph {
		HashSet<Integer>[] vertex;
		int n;
		@SuppressWarnings("unchecked")
		Graph(int n) {
			this.n = n;
			HashSet<Integer>[] a = (HashSet<Integer>[])new HashSet[n];
			for(int i=0;i<n;i++)a[i]=new HashSet<>();
			this.vertex = a;
		}
		public void connect(int v, int w) {
			vertex[v].add(w);
			vertex[w].add(v);
		}
		public Iterable<Integer> adj(int v){
			return vertex[v];
		}
	}*/
	
	
	

}
