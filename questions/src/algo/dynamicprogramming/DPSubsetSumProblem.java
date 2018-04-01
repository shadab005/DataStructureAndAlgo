package algo.dynamicprogramming;

public class DPSubsetSumProblem {

	static Boolean dp[][];

	public static boolean isSubSetSum(int a[], int n, int sum) {
		if (sum == 0)return true;
		if (n < 0)return false;
		if (dp[n][sum] != null)	return dp[n][sum];
		
		if (a[n] > sum) {
			dp[n][sum] = isSubSetSum(a, n - 1, sum);
			return dp[n][sum];
		}
		dp[n][sum] = isSubSetSum(a, n - 1, sum - a[n]) || isSubSetSum(a, n - 1, sum);
		return dp[n][sum];
	}

	public static boolean isSubSetIterative(int a[], int sum) {
		int n = a.length;
		boolean dp[][] = new boolean[sum + 1][n + 1];
		// If sum is 0, then answer is true
		for (int i = 0; i <= n; i++)
			dp[0][i] = true;

		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				if (a[j - 1] > i)
					dp[i][j] = dp[i][j - 1];
				else {
					dp[i][j] = dp[i - a[j - 1]][j - 1] || dp[i][j - 1];
				}
			}
		}
		return dp[sum][n];
	}

	public static void main(String args[]) {
		int set[] = { 3, 34, 4, 12, 5, 2 };
		int k = 10;
		dp = new Boolean[set.length][k+1];
		System.out.println(isSubSetSum(set, set.length - 1, k));
		// System.out.println(isSubSetIterative(set,k));
	}
}
