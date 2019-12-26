package leetcode;

public class _62_UniquePath {

	public static void main(String[] args) {
		System.out.println(uniquePaths(53, 4));
		System.out.println(solveII(53, 4));
		System.out.println(solveIII(53, 4));

	}
	
	
	// m rows, n  cols
	static public int uniquePaths(int m, int n) {
		Integer dp[][] = new Integer[m][n];
		return solve(0, 0, m, n, dp);
    }


	private static int solve(int i, int j, int m, int n, Integer dp[][]) {
		if(i>=m || j >=n) return 0;
		if(dp[i][j] != null) return dp[i][j];
		if(i==m-1 && j == n-1) return dp[i][j]=1;
		return dp[i][j] = solve(i+1, j, m, n, dp) + solve(i, j+1, m, n, dp);
	}
	
	/*
	 * Solution 2
	 * To reach from start to end, one has to walk m-1 steps down and n-1 steps right
	 * 
	 * ex: Some combination like this for m = 3 n = 3-> DRRD
	 * So, if we count all pattern permutation we get the answer
	 * so ans  = (m-1 + n - 1)!/((m-1)! * (n-1)!)
	 * which is nothing but C(m+n-2, m-1) , which is nothing but nCr represented as C(n,r)
	 * So let's write the ncr function first 
	 */
	
	static int solveII(int m, int n) {
		return ncr(m+n-2, m-1);
	}
	
	static int ncr(int n, int r) {
		double ans = 1D;
		for(long j=r; j>0 ;j--) {
			ans = ((n-r+j)*ans)/(r+1-j);
		}
		return (int)(ans+0.5d);
	}
	
	
	/*
	 * Here we are using iterative dp approach
	 * We calculate for each (i,j) how many ways to reach from (0,0)
	 * 
	 */
	static int solveIII(int m, int n) {
		Integer dp[][] = new Integer[m][n];
		
		//first row
		for(int j = 0; j< n ; j++) {
			dp[0][j]=1;
		}
		//first col
		for(int i = 0 ; i < m ; i++) {
			dp[i][0] = 1;
		}
		
		for(int i=1; i<m;i++) {
			for(int j = 1; j<n;j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[m-1][n-1];
	}

}
