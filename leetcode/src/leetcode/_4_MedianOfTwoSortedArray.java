package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _4_MedianOfTwoSortedArray {
//2, 7 , 5,  6
	//1 2 3 4 5 6
	public static void main(String[] args) {
		//int a[]= {1,2,7,8};
		//int b[] = {3,4,5,6,9,10,11,12,13};
		//int a[] = {2,3,4,6};
		//int b[] = {1,5};
		//int a[] = {1,2,2};
		//int b[] = {1,2,3};
		//int a[] = {3};
		//int b[] = {1,2,4,5};
		//int a[] = {2,5};
		//int b[] = {1,3,4};
		//int a[] = {2,6};
		//int b[] = {1,3,4,5};
		
		int a[] = {1};
		int b[] = {2,3,4,5,6,7,8};

		System.out.println(findMedianSortedArrays(a, b));
		//1 1 2 2 2 3
		//System.out.println(median(a, 0, 1));
	}
	
	static  public double findMedianSortedArrays(int[] a, int[] b) {
		
		//Note both the array can't be empty as specified in the question
		if(a.length == 0 || b.length == 0) {
			return medianInSinleArrayCase(a, b);
		}
		return median(a,b,0,a.length-1, 0, b.length-1);
    }
	static int z = 0;
	
	private static double median(int[] a, int[] b, int ai, int aj, int bi, int bj) {
		System.out.println("ai = " + ai +", aj = " + aj + ", bi = " + bi + ", bj = " + bj);
		if(aj-ai+1+bj-bi+1 <=4) {
			int done = ai+bi;
			int toGetIndex = (a.length+b.length)/2;
			int effective = toGetIndex-done;
			List<Integer> ll = new ArrayList<>();
			for(int k = ai; k<=aj;k++) {
				ll.add(a[k]);
			}
			for(int k = bi; k<=bj;k++) {
				ll.add(b[k]);
			}
			
			if((a.length+b.length)%2 == 0)  {
				return getMedian(ll, effective, true);	
			} else {
				return getMedian(ll, effective, false);	
			}
		}
		
		double aMedian = median(a, ai,aj);
		double bMedian = median(b, bi,bj);
		//System.out.println("comparing median [" + aMedian  + "] ai = " + ai +" , aj = " + aj+ " bi = " + bi +" , bj = " + bj + " [" + bMedian +"]");
		//if(aMedian == bMedian) return aMedian;
		z++;
		//if(z>=20) return z;
		System.out.println("aMedian = " + aMedian +", bMedian = " + bMedian);
		if(aMedian<bMedian) {
			int lastB =  (bi+bj-1)/2;
			if((bj-bi+1)%2!=0 || bi == bj)lastB++;
			
			return median(a, b, (ai+aj)/2, aj, bi, lastB);
		}
		else if(aMedian>bMedian) {
			int lastA =  (ai+aj-1)/2;
			if((aj-ai+1)%2!=0 || ai==aj)lastA++;
		//	System.out.println("lastA="+lastA);
			return median(a, b, ai, lastA, (bi+bj)/2, bj);
		} else {
			if(aj-ai==bj-bi) return aMedian;
			if(ai!=aj && bi!=bj) {
				if(a[aj] > b[bj])aj--;
				else bj--;
			} else if(ai==aj)bj--;
			else aj--;
			return median(a, b, (ai+aj-1)/2, aj, (bi+bj-1)/2, bj);
		}
		
	}
	
	private static double getMedian(List<Integer> c, int effective, boolean isEven) {
		//System.out.println("c= " + c);
		Collections.sort(c);
		//int mid = c.size()/2;
		if(isEven) {
			return (double)(c.get(effective-1)+c.get(effective))/2.0;
		} else {
			return c.get(effective);
		}
	}
	
	private static double median(int[] a, int i, int j) {
		int size = j-i+1;
		int mid = (i+j)/2;
		//System.out.println("mid="+mid +" size = " + size);
		if(size%2==0) {
			return (double)(a[mid]+a[mid+1])/2.0;
		}
		return (a[mid]);
	}

	static double medianInSinleArrayCase(int a[], int b[]) {
		int c[]= (a.length==0)?b:a;
		int mid = c.length/2;
		if(c.length%2 == 0) {
			return (double)(c[mid-1]+c[mid])/2.0;
		} else {
			return c[mid];
		}
	}

}
