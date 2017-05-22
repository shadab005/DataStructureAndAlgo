
public class DPSubsetSumProblem {

	public static boolean isSubSetSum(int a[], int n, int k){
		if(k==0) return true;
		if(n<0) return false;
		if(a[n] > k) return isSubSetSum(a, n-1, k);
		return isSubSetSum(a, n-1, k-a[n]) || isSubSetSum(a, n-1, k);
	}
	
	public static boolean isSubSetIterative(int a[], int k){
		int m=k;
		int n=a.length;
		
		boolean dp[][] = new boolean[m+1][n+1];
		// If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
          dp[0][i] = true;
        
		for(int i = 1; i <= k ; i++){
			for(int j = 1; j <= n ; j++){
				if(a[j-1] > i) dp[i][j]=dp[i][j-1];
				else{
					dp[i][j]=dp[i-a[j-1]][j-1] || dp[i][j-1];
				}
			}
		}
		return dp[k][n];
	}
	
	public static void main(String args[]){
		int set[] = {3, 34, 4, 12, 5, 2};
		int k = 9;
		System.out.println(isSubSetSum(set,set.length-1,k));
		System.out.println(isSubSetIterative(set,k));
	}
}
