import java.util.Arrays;
import java.util.List;

/*
 * Design an algorithm to find the maximum profit. You may complete as many transactions
 *  as you like (ie, buy one and sell one share of the stock multiple times). 
 *  However, you may not engage in multiple transactions at the same time (ie, you must sell the stock 
 *  before you buy again).
 */
public class BestTimeToBuyStockII {

	enum State {
		BUYING, SELLING
	}
	/*
	 * Shares can be bought on local minima and can be sold at local maxima
	 */
	public int maxProfit(final List<Integer> a) {
		if(a==null || a.size()==0)return 0;
		int n = a.size();
		int i = 0;
		while(i<n-1 && a.get(i)>a.get(i+1))i++;
		if(i==n-1)return 0;
		
		int total = 0;
		int buyingPrice = a.get(i);//Buying on ith day
		//System.out.println("i="+i +" and buyingPrice="+buyingPrice);
		i++;
		State state = State.SELLING;
		while(i<n) {
			if(state==State.BUYING) {
			     	if(canBeBoughtOnThisDay(a,i)) {
			     		buyingPrice = a.get(i);
			     		state = State.SELLING;
			     	}
			}else {
				if(canBeSoldOnThisDay(a, i)) {
					//System.out.println("i="+i +" and Selling Price="+a.get(i));
					total += a.get(i)-buyingPrice;
					state = State.BUYING;
				}
			}
			i++;
		}
		return total;
	}
	private boolean canBeBoughtOnThisDay(List<Integer> a, int i) {
		if(i<a.size()-1) {
			if(i==0) {
				if(a.get(i+1)>a.get(i))return true;
			}else {
				if(a.get(i+1)>a.get(i) && a.get(i)<=a.get(i-1))return true;
			}
		}
		return false;
	}
	private boolean canBeSoldOnThisDay(List<Integer> a, int i) {
		if(i==a.size()-1) {
			if(a.get(i)>a.get(i-1))return true;
		}else {
			//System.out.println("Here " + i);
			if(a.get(i)>a.get(i-1) && a.get(i)>=a.get(i+1))return true;
		}
		return false;
	}
	public static void main(String[] args) {
		BestTimeToBuyStockII b = new BestTimeToBuyStockII();
		System.out.println(b.maxProfit(Arrays.asList(1,2,3)));

	}

}
