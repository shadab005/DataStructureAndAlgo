package leetcode;

import java.util.HashMap;

public class _523_ContinuousSubarraySum {

	public static void main(String[] args) {
		System.out.println(checkSubarraySum(new int[] {3,3}, 6));

	}
	
	static public boolean checkSubarraySum(int[] a, int k) {
		
		if(k==0) {
			return handleZeroCase(a);
		}
     
		HashMap<Integer, Integer> remainderToFirstOccurrenceMap = new HashMap<>();
		int total = 0;
		int r = 0;
		remainderToFirstOccurrenceMap.put(0, -1);
		for(int i = 0; i< a.length ; i++) {
			total+=a[i];
			r = total%k;
			if(remainderToFirstOccurrenceMap.containsKey(r)) {
				int firstIndex = remainderToFirstOccurrenceMap.get(r);
				int diff = i - firstIndex;
				if(diff > 1) {
					return true;
				}
			} else {
				remainderToFirstOccurrenceMap.put(r, i);
			}
		}
		return false;
    }

	private static boolean handleZeroCase(int[] a) {
		for(int i = 0 ; i < a.length-1; i++) {
			if(a[i] ==0 && a[i+1] == 0) return true;
		}
		return false;
	}

}
