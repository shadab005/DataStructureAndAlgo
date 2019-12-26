package leetcode;

import java.util.HashMap;

/*
 * #interview
 */
public class _560_SubarraySumEqualsK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static public int subarraySum(int[] a, int k) {
		
		HashMap<Integer, Integer> sumToCountMap = new HashMap<>();
		sumToCountMap.put(0, 1);
		int sum = 0, count = 0;
		for(int i = 0 ; i < a.length; i++) {
			sum+=a[i];
			if(sumToCountMap.containsKey(sum-k)) {
				count += sumToCountMap.get(sum-k);
			}
			sumToCountMap.put(sum, sumToCountMap.getOrDefault(sum, 0)+1);
		}
        return count;
    }

}
