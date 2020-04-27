package algo.strings;

public class LongestRepeatingSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestRepeatingSubstringUsingSuffixArray("abcabc"));

	}

	//O(n2)
	public int longestRepeatingSubstring(String s) {
		int n = s.length();
		int[][] dp = new int[n + 1][n + 1];
		int res = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (s.charAt(i - 1) == s.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					res = Math.max(dp[i][j], res);
				}
			}
		}
		return res;
	}
	
	/*
	 * abcabc
	 * bcabc
	 * cabc
	 * abc
	 * bc
	 * c
	 */
	public static int longestRepeatingSubstringUsingSuffixArray(String s) {
		int n = s.length();
		SuffixArray sa = new SuffixArray(s);
		int ans = 0;
		for(int i = 1 ; i < n ; i++) {
			int len = sa.lcp(i);
			ans = Math.max(ans, len);
		}
		return ans;
	}

}
