package leetcode;

import java.util.Arrays;

public class _96_UniqueBinaryTree {

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
	//The solution to sequence F(n) is the catalan number, Cn = 1/(n+1) *  C(2n,n) //C(2n,n) is the combination of 2n and c like nCr
	

}
