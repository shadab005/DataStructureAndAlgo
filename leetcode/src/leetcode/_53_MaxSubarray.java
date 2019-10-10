package leetcode;

public class _53_MaxSubarray {

	public static void main(String[] args) {

	}

	static public int maxSubArray(int[] a) {
		if(a.length == 0) return 0;	
		
		int current = a[0];
		int max = a[0];
		for(int i = 1 ; i <a.length ; i++) {
			current = Math.max(current+a[i], a[i]);
			max = Math.max(current, max);
		}
		return max;
	}
	
	static public int maxSubArray(int a[], int s, int e) {
		
		if(s==e) return a[s];
		
		int mid = s + (e-s)/2;
		
		int leftMax = maxSubArray(a, s, mid);
		int rightMax = maxSubArray(a, mid+1, e);
		
		return 0;
	}

}
