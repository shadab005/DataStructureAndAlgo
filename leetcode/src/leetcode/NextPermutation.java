package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import algo.util.Util;

public class NextPermutation {

	public static void main(String[] args) {
		int[] nums = {1,3,2}; //[2,1,3]
		Util.printArray(nums);
		nextPermutation(nums);
		Util.printArray(nums);
		
		//System.out.println("Lex order");
		//System.out.println(lexOrder(new int[] {9108113  , 9108311 , 9101138}));
	}

	static public void nextPermutation(int[] nums) {
		if(nums.length == 0 || nums.length == 1) return;
		int i = nums.length - 1;
		int max = nums[i];
		i--;
		while(i>=0 && nums[i] >= max) {
			max = nums[i];
			i--;
		}
		//System.out.println("max = " + max + " and i = " + i);
		
		if(i<0) {
			//number is in descending order lexico wise. Make it ascenting
			invertElements(nums, 0, nums.length-1);
		} else {
			
			//element i is the first smaller number from right end
			//find the ceil of nums[i] for i  [i, nums.length-1]
			int j = i+1;
			int min = Integer.MAX_VALUE;
			int minIndex = -1;
			while(j < nums.length) {
				if(nums[i] < nums[j]) {
					if(min >= nums[j]) {
						min = nums[j];
						minIndex = j;
					}
				}
				j++;
			}
			j = minIndex;
			//j is the last popped index
			//swap element at i and j
			swap(nums, i, j);
			//invert array elements from i+1 to n-1
			invertElements(nums, i+1, nums.length-1);
		}
		
	}
	
	static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static void invertElements(int a[], int i, int j) {
		while(i<j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
	}
	
	
	static List<Integer> lexOrder(int nums[]) {
        return Arrays.stream(nums)
                        .mapToObj(Integer::toString)
                        .sorted()
                        .map(Integer::valueOf)
                        .collect(Collectors.toList());
    }

}
