package algo.array;
import java.util.Arrays;
import java.util.Comparator;

import algo.util.Util;

public class MaxDistance {

	/*
	 * ex :  i/p : [3 5 4 2] o/p: 2 i.e by pair (3,4) indexes
	 * https://www.interviewbit.com/problems/max-distance/
	 */
	//O(nlogn) complexity
	public static int nextGreaterFarthest(final int[] a) {
		int n = a.length;
		if(n<=1)return -1;
		Integer b[] = new Integer[n];
		for(int i=0;i<n;i++)b[i]=i;
		
		Comparator<Integer> byAnotherArray = (Integer o1, Integer o2)->a[o1]-a[o2];
		Arrays.sort(b, byAnotherArray);
		Util.printArray(b);
		int ans = 0;
		int min = b[0];
		for(int i=1;i<n;i++) {
			ans=Math.max(ans, b[i]-min);
			min=Math.min(min, b[i]);
		}
		return ans;
	}
	
	//o(n) solution
	public static int maximumGap(final int[] a) {
		int  ans = 0;
		int n =a.length;
		int lmin[]=new int[n];
		int rmax[]=new int[n];
		lmin[0]=a[0];
		rmax[n-1]=a[n-1];
		int j = 0;
		for(int i=1;i<n;i++) {
			lmin[i]=Math.min(lmin[i-1], a[i]);
			j = n-i-1;
			rmax[j]=Math.max(rmax[j+1], a[j]);
		}
		int i=0;
		j=0;
		while(i<n && j<n) {
			if(lmin[i]<=rmax[j]) {
				ans=Math.max(ans, j-i);
				j++;
			}else {
				i++;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(maximumGap(new int[] { 3, 5, 4, 2}));

	}

}
 