package leetcode;

public class _5_LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("a"));
		String s = "babad";
		System.out.println(lp(s, 0, s.length()-1));

	}
	
	/*
	 *  p(i,j) = true if substring from i to j  is palindrome
	 *         = false otherwise
	 *  
	 *  P(i,j)=(P(i+1,j−1) and s[i] = s[j]
	 *  base case 
	 *  p(i,i) = true and 
	 *  p(i,i+1) = true if s[i] == s[i+1]
	 */
	
	public static boolean lp(String s, int i, int j) {
		
		if(i == j) return true;
		else if(i == j-1) return s.charAt(i) == s.charAt(j);
		
		
		return true;
	}
	
	static public String longestPalindrome(String s) {
		if(s==null || s.isEmpty()) return s;
		int n = s.length();
		
		boolean dp[][] = new boolean[n+1][n];
		for(int i = 0; i<n ;i++) {
			dp[0][i] = true;
			dp[1][i] = true;
		}
		
		int maxLength = 1;
		int maxIndex = 0;
		
		for(int k = 2; k <= n ; k++) { //k depicts the length of string on which we are operating
			
			for(int i = 0; i < n-k+1; i++) {
				int j = i+k-1;
				if(s.charAt(i) == s.charAt(j) && dp[k-2][i+1] == true) {
					dp[k][i] = true;
					if(k>maxLength) {
						maxLength = k;
						maxIndex = i;
					}
				}
			}
			
		}
		
		//Util.printArray(dp);
		//System.out.println();
		//System.out.println("Max Index = " + maxIndex + " Max Length = " + maxLength + " String = " + s.substring(maxIndex, maxIndex+maxLength));

		return s.substring(maxIndex, maxIndex+maxLength);
	}

}
