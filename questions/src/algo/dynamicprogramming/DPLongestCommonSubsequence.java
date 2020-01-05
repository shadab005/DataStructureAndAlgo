package algo.dynamicprogramming;

/*
 * ex:
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 */
public class DPLongestCommonSubsequence {

	
	
	public static int longestCommonSubsequence(char[] x, char[] y, int i, int j, int maxLenght[][]){
		if(i < x.length && j < y.length){
			if(maxLenght[i][j]!=0) return maxLenght[i][j];
			if(x[i] == y[j]) {
				return maxLenght[i][j] = 1+longestCommonSubsequence(x, y, i+1, j+1, maxLenght);
			}
			else{
				return maxLenght[i][j] = Math.max(longestCommonSubsequence(x, y, i+1, j, maxLenght),
						longestCommonSubsequence(x, y, i, j+1, maxLenght));
			}
		}
		return 0;
	}
	
	//m is index of s1 starting from last index. And similary n is for s2
	public static int lcs(String s1, String s2, int m, int n, Integer dp[][]) {
		if(m < 0 || n < 0) return 0;
		if(dp[m][n]!=null) return dp[m][n];
		if(s1.charAt(m) == s2.charAt(n)) dp[m][n]=1+lcs(s1, s2, m-1, n-1, dp);
		else {
			dp[m][n] = Math.max(lcs(s1, s2, m-1, n, dp), lcs(s1, s2, m, n-1, dp));
		}
		return dp[m][n];
	}
	
	/*
	 * m[i][j]= { 0 , if i or j = 0
	 *            m[i-1][j-1]+1 ,if i and j > 0 and x[i]=y[j]
	 *            max(m[i][j-1], m[i-1][j]) , if x[i]!=y[j]
	 *          } 
	 */
	public static int lcsIterative(char x[], char y[]){
		int m = x.length;
		int n = y.length;
		int maxLength[][] = new int[m+1][n+1];
		for(int i = 1 ; i <= m ; i++){
			for(int j = 1 ; j <= n; j++){
				maxLength[i][j] = maxLength[i-1][j-1];
				if(x[i-1] == y[j-1])maxLength[i][j]++;
				if(maxLength[i-1][j] > maxLength[i][j]){
					maxLength[i][j] = maxLength[i-1][j];
				}
				if(maxLength[i][j-1] > maxLength[i][j]){
					maxLength[i][j] = maxLength[i][j-1];
				}
			}
		}
		return maxLength[m][n];
	}
	
	public static void main(String args[]){
		char x[] = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
		char y[] = {'B', 'D', 'C', 'A', 'B', 'A'};
		int maxLength[][] = new int[x.length][y.length];
		System.out.println(longestCommonSubsequence(x, y, 0, 0, maxLength));
		System.out.println(lcsIterative(x, y));
		
	}
}
