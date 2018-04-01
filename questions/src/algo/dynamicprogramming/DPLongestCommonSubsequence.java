package algo.dynamicprogramming;

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
		for(int i = 1 ; i <= m ; i++){
			for(int j = 1 ; j <= n; j++)
				System.out.print(maxLength[i][j] + " ");
			System.out.println();
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
