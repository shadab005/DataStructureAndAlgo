package leetcode;

public class _122_BestTimeToBuySellStocksII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	static  public int maxProfit(int[] prices) {
      int profit = 0;
      if(prices == null || prices.length ==0) return profit;
      for(int i=1;i<prices.length;i++) {
    	  profit += Math.max(0, prices[i]-prices[i-1]);
      }
      return profit;
    }

}
