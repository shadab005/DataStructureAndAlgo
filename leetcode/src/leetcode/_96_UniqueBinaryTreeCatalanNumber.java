package leetcode;

import java.util.Arrays;

public class _96_UniqueBinaryTreeCatalanNumber {

	public static void main(String[] args) {
		System.out.println(numTrees(15));

	}
	
	
	// F(n) = Summation of all F(left subtree) * F(SubTree)
	//      = Summation over all l [varies from 0 to n-1] F(l) * F(n-1-l) //l nodes on left, 1 node is the root itself and n-l-1 nodes on the right
	//      Base case when n = 0, F(n) = 1, n = 1 F(n) = 1
	
	static public int numTrees(int n) {
		int dp[] = new int[n+1];
		Arrays.fill(dp, -1);
		return numTrees(n, dp);
    }
	
	static public int numTrees(int n, int dp[]) {
		if(dp[n] != -1) return dp[n];
		if(n == 0 || n == 1) return 1;
		int total = 0;
		for(int l = 0 ; l <= n-1; l++) {
			total+= numTrees(l,dp)*numTrees(n-l-1,dp);
		}
		dp[n] = total;
		return total;
	}
	
	
	//solution 2 
	//The solution to sequence F(n) is the catalan number[1, 1, 2, 5, 14, 42, 132, ..], Cn = 1/(n+1) *  C(2n,n) //C(2n,n) is the combination of 2n and c like nCr
	/*
	 *  Further simplification :
	 *  c(n+2,r) = c(n,r-1) * (n+2) * (n+1) / ((r) * (n+2-r))
	 *  The above can easily be derived using simple nCr formula
	 *  
	 *   Now using this, we can see
	 *   Catalan(n+1) = 2*(2n+1)/(n+2)*Catalan(n)
	 *   With this we can easily derive Catalan(n+1) from Catalan(n) in one step
	 *   So, using this we solve for Cn in n step just like fibonacci
	 */
	
	public int numTreesLinear(int n) {
	    // Note: we should use long here instead of int, otherwise overflow
	    long C = 1;
	    for (int i = 0; i < n; ++i) {
	      C = C * 2 * (2 * i + 1) / (i + 2);
	    }
	    return (int) C;
	  }
	
	

}
