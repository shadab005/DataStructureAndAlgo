package leetcode;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("a"));

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
