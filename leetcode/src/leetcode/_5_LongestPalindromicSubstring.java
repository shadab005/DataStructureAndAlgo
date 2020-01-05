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
	
	
	/*
	 * Expand Around Center
	 * We observe that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center, 
	 * and there are only 2n - 1 such centers.
	 */
	public String longestPalindromeII(String s) {
	    if (s == null || s.length() < 1) return "";
	    int start = 0, end = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i);
	        int len2 = expandAroundCenter(s, i, i + 1);
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
	        }
	    }
	    return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}

}
