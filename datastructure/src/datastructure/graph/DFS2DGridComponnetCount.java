package datastructure.graph;

public class DFS2DGridComponnetCount {

	public static void main(String[] args) {
		int a[][]= {
				     {0,0,0,1,1,0},
				     {1,1,0,0,0,0},
				     {0,1,0,0,0,0},
				     {0,0,1,0,0,0}
				   };
		countComponent(a, 4, 6);

	}

	public static void countComponent(int[][] a, int m, int n) {//m rows and n columns
		boolean visited[][] = new boolean[m][n];
		int component=0;
	    int max=0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[i][j] && a[i][j]==1) {
					component++;
					count=0;
					bfs(a, m, n, i, j, visited);
					max=Math.max(max, count);
				}
			}
		}
		System.out.println("Number of components in the graph is " + component);
		System.out.println("Maximum number of troops = " + max);
		
	}

	private static int count=0;
	public static void bfs(int[][] a, int m, int n, int i, int j, boolean[][] visited) {
		visited[i][j]=true;
		count++;
		for(int p=-1;p<=1;p++) {
			for(int q=-1;q<=1;q++) {
				if(isValidPosition(i+p,j+q,m,n) && !visited[i+p][j+q] && a[i+p][j+q]==1) {
					bfs(a, m, n, i+p, j+q, visited);
				}
			}
		}
	}

	private static boolean isValidPosition(int i, int j, int m, int n) {
		if(i<0 || i>=m || j<0 || j>=n)return false;
		return true;
	}

	
	/*bfs(a,m,n,i-1,j-1,visited);
	bfs(a,m,n,i-1,j,visited);
	bfs(a,m,n,i-1,j+1,visited);
	
	bfs(a,m,n,i,j-1,visited);
	bfs(a,m,n,i,j+1,visited);
	
	bfs(a,m,n,i+1,j-1,visited);
	bfs(a,m,n,i+1,j,visited);
	bfs(a,m,n,i+1,j+1,visited);*/
}
