package leetcode;

public class _516_LongestPalindromicSubsequence {

	public static void main(String[] args) {
		System.out.println(longestPalindromeSubseq("BBCBABCAB"));

	}
	
	static public int longestPalindromeSubseq(String s) {
        if(s==null || s.isEmpty()) return 0;
        int dp[][] = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++) {
        	for(int j = 0 ; j <s.length();j++) {
        		dp[i][j] = -1;
        	}
        }
 		return solve(s, 0, s.length()-1, dp);
    }
	
	static int solve(String s, int i, int j, int dp[][]) {
		if(i>j) return 0;
		if(i==j)return dp[i][j] = 1;
		if(dp[i][j] != -1) return dp[i][j];
		if(s.charAt(i) == s.charAt(j)) {
			return dp[i][j] = solve(s, i+1, j-1,dp)+2;
		} else {
			return dp[i][j] = Math.max(solve(s, i+1, j, dp), solve(s, i, j-1,dp));
		}
	}

}
