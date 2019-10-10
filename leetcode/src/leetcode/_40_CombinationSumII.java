package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import algo.util.Util;


public class _40_CombinationSumII {

	public static void main(String[] args) {
		System.out.println(combinationSum2(new int[] {1,2,7,6,1}, 8));
	}

	static public List<List<Integer>> combinationSum2(int[] a, int sum) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(a);
		findSum(a, a.length - 1, sum, new ArrayList<>(), ans, -1);
		return ans;
	}

	static void findSum(int[] a, int n, int sum, List<Integer> current, List<List<Integer>> ans, int skipIndex) {
		if (sum == 0) {
			if (current.size() > 0) {
				ans.add(new ArrayList<>(current));
			}
		} 
		else if (n < 0) return;
		else if (sum > 0) {
			
			findSum(a, n - 1, sum, current, ans, n); //skipping
			if ((skipIndex == -1 || a[skipIndex] != a[n]) && a[n] <= sum) {
				current.add(a[n]);
				findSum(a, n - 1, sum - a[n], current, ans, -1); //selecting
				current.remove(current.size() - 1);
			}
		}
	}

}
