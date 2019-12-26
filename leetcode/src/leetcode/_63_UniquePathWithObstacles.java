package leetcode;

public class _63_UniquePathWithObstacles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static public int uniquePathsWithObstacles(int[][] obstacleGrid) {
     
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		Integer dp[][] = new Integer[m][n];
		return solve(0, 0, m, n, dp, obstacleGrid);
    }

	private static int solve(int i, int j, int m, int n, Integer[][] dp, int[][] obstacleGrid) {
		if(i>=m || j >=n) return 0;
		if(obstacleGrid[i][j] == 1) return 0;
		if(dp[i][j] != null) return dp[i][j];
		if(i==m-1 && j==n-1) return dp[i][j]=1;
		return dp[i][j] = solve(i+1, j, m, n, dp, obstacleGrid) + solve(i, j+1, m, n, dp, obstacleGrid) ;
	}

}
