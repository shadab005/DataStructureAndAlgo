
/*
 * Say you have an array for which the ith element is the price of a given stock on day 
 * i.Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */


// k transactions iithe day
//f[k, ii] = max(f[k, ii-1], prices[ii] - prices[jj] + f[k-1, jj]) { jj in range of [0, ii-1] }
//         = max(f[k, ii-1], prices[ii] + max(f[k-1, jj] - prices[jj]))

public class BestTimeToBuyStockIII {
	
	public int maxProfit(final int[] a) {
		int n = a.length;
		int left[] = new int[n];
		int right[] = new int[n];
		int buyPrice = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			if(a[i]<buyPrice) {
				buyPrice = a[i];
				if(i>1)left[i]=left[i-1];
				
			}else {
				left[i]=Math.max(a[i]-buyPrice, left[i-1]);
			}
		}
	//	Util.printArray(left);
		int sellPrice = Integer.MIN_VALUE;
		for(int i=n-1;i>=0;i--) {
			if(a[i]>sellPrice) {
				sellPrice = a[i];
				if(i<n-1)
				right[i]=right[i+1];
			}else {
				right[i]=Math.max(sellPrice-a[i], right[i+1]);
			}
		}
//		Util.printArray(right);
		int ans = 0;
		for(int i = 0; i<n;i++) {
			ans = Math.max(ans, left[i]+right[i]);
		}
		return ans;
    }

	public static void main(String[] args) {
		BestTimeToBuyStockIII b = new BestTimeToBuyStockIII();
		int a[] = {4,6,1,5,6,2,10,3};//13
		System.out.println(b.maxProfit(a));

	}

}
