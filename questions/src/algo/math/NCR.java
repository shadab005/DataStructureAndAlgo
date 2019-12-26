package algo.math;

public class NCR {

	public static void main(String[] args) {
		System.out.println(ncr(53, 4));
		System.out.println(ncr2(53, 4));

	}
	
	static int ncr(int n, int r) {
		double ans = 1D;
		for(long j=r; j>0 ;j--) {
			ans = ((n-r+j)*ans)/(r+1-j);
		}
		return (int)(ans+0.5d);
	}
	
	//Using formula : C(n,r) = C(n-1,r)+C(n-1, r-1)
	static int ncr2(int n, int r) {
		int dp[][] = new int[n+1][r+1];
		return ncr(n, r, dp);
	}

	private static int ncr(int n, int r, int[][] dp) {
		if(n<r)return 0;
		if(r==0 || n==r)return 1;
		if(r==1) return n;
		if(dp[n][r]!=0)return dp[n][r];
		dp[n][r] = ncr(n-1,r, dp)+ncr(n-1,r-1,dp);
		return dp[n][r];
	}

}
