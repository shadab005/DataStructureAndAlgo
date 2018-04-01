import java.util.Arrays;
import java.util.Comparator;

import algo.util.Util;

public class NextGreater {

	/*
	 * ex :  i/p : [3 5 4 2] o/p: 2 i.e by pair (3,4) indexes
	 * https://www.interviewbit.com/problems/max-distance/
	 */
	public static int nextGreaterFarthest(final int[] a) {
		int n = a.length;
		Integer b[] = new Integer[n];
		for(int i=0;i<n;i++)b[i]=i;
		
		Comparator<Integer> byAnotherArray = (Integer o1, Integer o2)->a[o1]-a[o2];
		Arrays.sort(b, byAnotherArray);
		Util.printArray(b);
		return 0;
	}
	public static void main(String[] args) {
		nextGreaterFarthest(new int[] {3,5,4,2,7});

	}

}
 