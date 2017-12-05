import java.util.Scanner;

public class PrisonBreakTotalPathToBreakOut {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int a[][] = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					a[i][j] = in.nextInt();

			solve(a, n);
		}
		in.close();
	}

	private static void solve(int[][] a, int n) {
		ans = 0;
		if (a[n - 1][n - 1] == 1) {
			System.out.println(0);
			return;
		}
		boolean mark[][] = new boolean[n][n];
		mark[0][0]=true;
		dfs(a,0,0, n, mark);
		System.out.println(ans);
		
	}

	private static void dfs(int[][] a, int x, int y, int n, boolean mark[][]) {
		if(x==n-1 && y==n-1) {
			ans++;
			return;
		}
		int xNeighbour = 0, yNeigbhour = 0;
		for (int p = -1; p <= 1; p++) {
			for (int q = -1; q <= 1; q++) {
				xNeighbour = x + p;
				yNeigbhour = y + q;
				if (isValid(p,q) && isValidPosition(xNeighbour, yNeigbhour, n, n) && a[xNeighbour][yNeigbhour] == 0
						&& !mark[xNeighbour][yNeigbhour]
						) {
				   mark[xNeighbour][yNeigbhour]=true;
				   dfs(a,xNeighbour,yNeigbhour,n, mark);
				   mark[xNeighbour][yNeigbhour]=false;
				}
			}
		}
		
	}

	static int ans = 0;
	/*
	 1
		4
		0 1 1 0 
		0 0 1 0 
		0 0 0 0 
		0 1 1 0 
	 */

	

	public static boolean isValid(int p, int q) {
		if ((p == -1 || p == 1) && (q == -1 || q == 1))
			return false;
		return true;
	}

	public static boolean isValidPosition(int i, int j, int N, int M) {
		if (i < 0 || i >= N || j < 0 || j >= M)
			return false;
		return true;
	}

}
