import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MinIslands {

	public static void main(String[] args) {
		int a[][] = new int[50][50];
			/*
			{  {1, 1, 0, 0, 0},
				       {0, 1, 0, 0, 1},
				       {1, 0, 0, 1, 1},
				       {0, 0, 0, 0, 0},
				       {1, 0, 1, 0, 1}
				    };*/
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		while(t-->0){
			int m = in.nextInt();
			int n = in.nextInt();
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					a[i][j]=in.nextInt();
				}
			}
			System.out.println(minimumNumber(a,5,5));
		}
		in.close();
	}

	public static int minimumNumber(int[][] a, int m, int n) {
		boolean visited[][] = new boolean[m][n];
		int count=0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(!visited[i][j] && a[i][j]==1){
					count++;
					markConnectedNeighbour(a, visited,i,j, m, n);
				}
			}
		}
		return count;
	}

	private static void markConnectedNeighbour(int a[][], boolean[][] visited, int i, int j, int m, int n) {
		if(i<0 || j<0 || i>=m || j>=n)return;
		if(a[i][j]==0)return;
		if(visited[i][j])return;
		visited[i][j]=true;
		markConnectedNeighbour(a,visited,i-1,j-1,m,n);
		markConnectedNeighbour(a,visited,i-1,j,m,n);
		markConnectedNeighbour(a,visited,i-1,j+1,m,n);
		
		markConnectedNeighbour(a,visited,i,j-1,m,n);
		markConnectedNeighbour(a,visited,i,j+1,m,n);
		
		markConnectedNeighbour(a,visited,i+1,j-1,m,n);
		markConnectedNeighbour(a,visited,i+1,j,m,n);
		markConnectedNeighbour(a,visited,i+1,j+1,m,n);
	}

}
