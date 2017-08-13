import java.util.Scanner;

public class DPCoinChange {

	static int c[];
	static int m=0;
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        m = in.nextInt();
	        c = new int[m];
	        for(int c_i=0; c_i < m; c_i++){
	            c[c_i] = in.nextInt();
	        }
	        //System.out.println("\nCalculating");
	       /* dp = new long[n+1][m];
	        getWays(n, 0);
	        in.close();
	        long maxCount = 0;
	        for(int i=0;i<m;i++){
	        	if(dp[n][i]>maxCount)maxCount=dp[n][i];
	        }
	        System.out.println(maxCount);
	        System.out.println(funCount);*/
	        dp = new long[n+1][m+1];
	        for(int i=0;i<m;i++){
	        	dp[0][i]=1;
	        }
	        System.out.println(ways(n,m));
	        System.out.println(funCount);
	 }
	 
	 static long funCount=0;//17215
	 static long dp[][];

	private static long getWays(int n, int index) {
		funCount++;
		if(n<0)return 0;
		if(dp[n][index]!=0)return dp[n][index];
		if(n==0)return 1;
		else{
			for(int j=index;j<m;j++){
				long count = getWays(n-c[j], j);
				dp[n][index]+=count;
			}
		}
		return dp[n][index];
	}
	
	static long ways(int amount, int n){
		if(amount==0)return 1;
		if(amount < 0 || n <= 0)return 0;
		if(dp[amount][n]>0) return dp[amount][n];
		long count = ways(amount,n-1)+ways(amount-c[n-1],n);
		dp[amount][n] = count;
		funCount++;
		return count;
	}
}
