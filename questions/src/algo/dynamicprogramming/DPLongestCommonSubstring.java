package algo.dynamicprogramming;

public class DPLongestCommonSubstring {

	public static void main(String[] args) {
		System.out.println(longestCommonSubstringLength("abcdxyz", "xyzabcd"));

	}
	
	/*
	 * The idea is to find the longest common suffix for all pairs of prefixes
	 */
	public static int longestCommonSubstringLength(String s1, String s2) {
		
		int m = s1.length();
		int n = s2.length();
		
		int dp[][] = new int[m+1][n+1];
		int ans = 0;
		
		for(int i = 1 ; i <= m ; i++) {
			for(int j = 1; j <= n ; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
					ans =Math.max(dp[i][j], ans);
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return ans;
	}

}
