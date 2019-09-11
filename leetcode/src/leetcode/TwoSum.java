package leetcode;

import java.util.Arrays;
import java.util.Comparator;

import algo.util.Util;

public class TwoSum {

	public static void main(String[] args) {
		int nums[] = { 2, 7, 11, 15};
		int target = 13;
		Util.printArray(twoSum(nums, target));

	}
	
   static public int[] twoSum(int[] nums, int target) {
     Integer a[] = getIndexArrayAfterSorting(nums);
     int i = 0;
     int j = nums.length-1;
     while(i<j) {
    	 int sum = nums[a[i]] + nums[a[j]];
    	 if(sum > target) j--;
    	 else if(sum < target) i++;
    	 else return new int[] {a[i],a[j]};
     }
	  return null;
    }
   
   /*
    * Donot modify original array
    * xxx
    */
   static Integer[] getIndexArrayAfterSorting(int a[]) {
	   Integer b[] = new Integer[a.length];
	   for(int i=0;i<a.length;i++) b[i] = i;
	   
	   Comparator<Integer> byArrayValue = (i,j)->a[i]-a[j];
	   Arrays.sort(b, byArrayValue);
	   return b;
   }

}
