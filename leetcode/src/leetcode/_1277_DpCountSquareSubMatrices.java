package leetcode;

public class _1277_DpCountSquareSubMatrices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static public int countSquares(int[][] a) {
		int m = a.length;
		int n = a[0].length;
		int dp[][] = new int[m+1][n+1];
		int ans = 0;
		
		for(int i = 1; i<= m ; i++) {
			for(int j = 1 ; j<=n ; j++) {
				if(a[i-1][j-1] == 1) {
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
					ans+=dp[i][j];
				}
			}
		}
		return ans;
    }

}
