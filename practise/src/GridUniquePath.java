
public class GridUniquePath {

	public static void main(String[] args) {
		System.out.println(uniquePaths(53, 4));
		System.out.println(uniquePaths(53, 4));
		

	}
	
	/*
	 * ans = (u+r)!/(u!r!)
	 */
	public static int uniquePaths(int m, int n) {
		int u = m-1;
		int r = n-1;
		dp = new int[u+r+1][r+1];
		int ans = ncR(u+r,r);
		return ans;
    }
	
	static int dp[][];
	public static int ncR(int n , int r) {
		if(n<r) return 0;
		if(r==0)return 1;
		if(r==1)return n;
		if(dp[n][r]!=0)return dp[n][r];
		dp[n][r] = ncR(n-1,r)+ncR(n-1,r-1);
		return dp[n][r];
	}


}
