package leetcode;

import java.util.Scanner;

public class _188_BestTimeToBuySellStocksIV {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0) {
			int k = in.nextInt();
			int n = in.nextInt();
			int prices[] = new int[n];
			for(int i = 0;i<n;i++)prices[i]=in.nextInt();
			System.out.println(maxProfit(k, prices));
		}
		in.close();

	}
	
	/*
	 *  // f[k, i] represents the max profit up until prices[i] using at most k transactions. 
        // f[k, i] = max(f[k, i-1],  f[k-1, j] + prices[i] - prices[j]) { j in range of [0, i-1] }
        //          = max(f[k, i-1], prices[i] + max(f[k-1, j] - prices[j]))
	 */
	
	static public int maxProfit(int K, int[] prices) {
     
		if(prices.length <=1) return 0;
		
		int f[][]= new int[K+1][prices.length];
		
		// f[0, ii] = 0; 0 times transation makes 0 profit
		for(int i=0;i<prices.length;i++) {
			f[0][i] = 0;
		}
		
		// f[k, 0] = 0; if there is only one price data point you can't make any money no matter how many times you can trade
		for(int i=0;i<K+1;i++) {
			f[i][0] = 0;
		}
		
		int ans = 0;
		
		for(int k = 1; k<=K; k++) {
			int maxTemp = f[k-1][0]-prices[0];
			for(int i = 1; i < prices.length; i++) {
				f[k][i] = Math.max(f[k][i-1], prices[i]+maxTemp);
				maxTemp = Math.max(maxTemp, f[k-1][i]-prices[i]);
				ans = Math.max(ans, f[k][i]);
			}
		}
		return ans;
    }

}
