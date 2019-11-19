package leetcode;

public class _1060_MissingElementInSortedArray {

	public static void main(String[] args) {
		System.out.println(missingElement(new int[] {1,2,4}, 3));
		//System.out.println(missingElement(new int[] {1,3}, 3));

	}
	
	/*
	 * Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.
	 * ex:  A = [4,7,9,10], K = 3 o/p : 8
	 *      A = [1,2,4], K = 3 o/p: 6
	 */
	static public int missingElement(int[] nums, int k) {
		return find(nums, 0, nums.length-1, k);
    }
	
	static int find(int a[], int low, int hi, int missingCount) {
		
		if(low == hi || hi-low==1) return a[low]+missingCount;
		
		int missingCountInRange = getMissingCountInRange(a, low, hi);
		
		if(missingCountInRange < missingCount) return a[hi]+missingCount-missingCountInRange;
		
		int mid = (low+hi)/2;
		int missCountTillMid = getMissingCountInRange(a, low, mid);
		if(missCountTillMid >= missingCount) return find(a, low, mid, missingCount);
		else return find(a, mid, hi, missingCount - missCountTillMid);
	}
	
	private static int getMissingCountInRange(int a[], int low, int hi) {
		return a[hi]-a[low]-(hi-low);
	}

}
