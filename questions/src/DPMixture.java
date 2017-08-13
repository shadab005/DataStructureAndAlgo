import java.util.Scanner;

/*
 * https://www.codechef.com/problems/MIXTURES
 */
class DPMixture {

	private static int cumulativeSum[];
	private static int dp[][];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = in.nextInt();
			}
			System.out.println(solve(a,n));
		}
		in.close();
	}
	
	public static int solve(int[] a, int n) {
		cumulativeSum = new int [n];
		cumulativeSum[0]=a[0];
		for(int i = 1; i< n ; i++){
			cumulativeSum[i]=a[i]+cumulativeSum[i-1];
		}
		dp = new int[n][n];
		smoke(0,n-1);
		return dp[0][n-1];
		
	}

	private static void smoke(int start, int end) {
		int n = end-start+1;
		int total = 0;
		for(int l = 2; l <= n; l++){
			for(int i = 0; i<= n-l ; i++){
				int j = i+l-1;
				dp[i][j] = Integer.MAX_VALUE;
				for(int k = i; k<=j-1 ; k++){
					total = dp[i][k]+dp[k+1][j]+cost(i,k,j);
					if(total < dp[i][j])dp[i][j]= total;
				}
			}
		}
	}

	static int cost(int i, int k, int j){
		return (getSum(i, k)%100)*(getSum(k+1, j)%100);
	}
	
	static int getSum(int i , int j){
		if(i==0)return cumulativeSum[j];
		return cumulativeSum[j]-cumulativeSum[i-1];
	}

}
