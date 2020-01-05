package leetcode;

public class _123_BestTimeToBuySellStocksIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * First Idea:
	 * profit(i, j, 2 transaction) = max of { profit(i, k, 1 transaction) + profit(k, j, 1 transaction) }, k varies from i to j
	 * 
	 * Second idea:
	 * for each index i, calculate the max profit from i to end and max profit from begining to index i
	 * 
	 */
	static public int maxProfit(int[] prices) {
		int n = prices.length;
		if(n == 0) return 0;
        
		
		int profit[] = new int[n];
		int max = prices[n-1];
		int maxProfit = 0;
		for(int i = n-1; i>=0;i--) {
			maxProfit = Math.max(maxProfit, max-prices[i]);
			profit[i] = maxProfit;
			max = Math.max(max, prices[i]);
		}
		
		int ans = 0;
		int min = prices[0];
		maxProfit = 0;
		for(int i =0; i<n;i++) {
			maxProfit = Math.max(maxProfit, prices[i]-min);
			min = Math.min(min, prices[i]);
			profit[i]+=maxProfit;
			ans = Math.max(ans, profit[i]);
		}
		return ans;
    }

}
