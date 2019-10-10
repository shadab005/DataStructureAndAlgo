package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _200_NumberOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return countComponent(grid, m, n);
    }
	
	public static int countComponent(char[][] a, int m, int n) {//m rows and n columns
		boolean visited[] = new boolean[m*PRIME+n];
		int component=0;
	    int max=0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[i*PRIME+j] && a[i][j]=='1') {
					component++;
					max=Math.max(max, bfs(a, m, n, i, j, visited));
				}
			}
		}
		return component;
		
	}

	//Prime number : 1009
	private static final int PRIME = 1009;
	public static int bfs(char[][] a, int m, int n, int x, int y, boolean visited[]) {
		int count = 1;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x*PRIME+y);
		int i,j=0;
		visited[x*PRIME+y]=true;
		while(!queue.isEmpty()) {
			int z=queue.remove();
			i = z/PRIME;
			j = z%PRIME;
			for(int p=-1;p<=1;p++) {
				for(int q=-1;q<=1;q++) {
					if(Math.abs(p) == 1 && Math.abs(q) == 1) continue;
					if(isValidPosition(i+p,j+q,m,n) && !visited[(i+p)*PRIME+(j+q)] && a[i+p][j+q]=='1') {
						count++;
						visited[(i+p)*PRIME+(j+q)]=true;
						queue.add((i+p)*PRIME+(j+q));
					}
				}
			}
			
		}
		return count;
	}

	private static boolean isValidPosition(int i, int j, int m, int n) {
		if(i<0 || i>=m || j<0 || j>=n)return false;
		return true;
	}
}
