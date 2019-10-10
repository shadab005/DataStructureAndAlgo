package leetcode;

import algo.util.Util;

public class _34_FistAndLastPositionInSortedArray {

	public static void main(String[] args) {
		int ans[] = searchRange(new int[]{2,2}, 1);
		Util.printArray(ans);

	}
	
	static public int[] searchRange(int[] a, int target) {
     
		int ans[] = {-1,-1};
		if(a.length == 0) return ans;
		ans[0] = searchLower(a, 0 ,a.length-1, target);
		if(ans[0] == -1) return ans;
		ans[1] = searchHigher(a, 0 ,a.length-1, target);
		return ans;
    }

	private static int searchLower(int[] a, int low, int high, int target) {
		if(low < a.length && low>=0 && a[low] == target) return low;
		if(low < high) {
			int  mid = (low+high)/2;
			if(a[mid] >= target) return searchLower(a, low+1, mid, target);
			else return searchLower(a, mid+1, high, target);
		}
		return -1; 
	}

	private static int searchHigher(int[] a, int low, int high, int target) {
	//	System.out.println("low = " +low + " high = " + high );
		if(high >= 0 && high < a.length && a[high] == target) return high;
		if(low < high) {
			int  mid = (low+high)/2;
			if(a[mid] > target) return searchHigher(a, low, mid-1, target);
			else return searchHigher(a, mid, high-1, target);
		}
		return -1; 
	}

}
