package algo.dynamicprogramming;

public class DPCoinChangeProblem {

	/*
	 * M(j)=Min(M(j-coins[i]))+1 , for all i and j-coin[i]>=0
	 */
	public static int minCoinChange(int c, int coins[]){
		int dp[] = new int[c+1]; //Gives number of coins to make this denomination
		int min = 0;
		for(int i=1;i<=c;i++){
			min=Integer.MAX_VALUE-1;
			dp[i]=Integer.MAX_VALUE;
			for(int j = 0; j < coins.length; j++){
				if(i >= coins[j]){
					min=Math.min(min, dp[i-coins[j]]); 
				}
			}
			if(min!=Integer.MAX_VALUE){
				dp[i]=min+1;
			}
		}
		/*for(int k = 0; k<=c;k++){
			System.out.println("dp["+k+"]="+dp[k]);
		}*/
		return dp[c];
	}
	
	public static void main(String args[]){
/*		//int coins[] = {25, 10, 5};
		int c=30; //coin
*/
		int coins[] =  {9, 6, 5, 1};
		int c=11;
		System.out.println(minCoinChange(c, coins));
		
	}
}
