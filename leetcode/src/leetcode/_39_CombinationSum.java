package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _39_CombinationSum {

	public static void main(String[] args) {
		System.out.println(combinationSum(new int[] {2,3,5}, 8));

	}
	
	static public List<List<Integer>> combinationSum(int[] a, int sum) {
     List<List<Integer>> ans = new ArrayList<>();
     findSum(a, a.length-1, sum, new ArrayList<>(), ans);
     return ans;
    }
	
	static void findSum(int[] a, int n, int sum, List<Integer> current, List<List<Integer>> ans) {
		if(n < 0) return;
		if(sum == 0) {
			if(current.size() > 0) {
				ans.add(new ArrayList<>(current));
			}
		}
		else if(sum > 0) {
			findSum(a, n-1, sum, current, ans);
			if(a[n] <= sum) {
				current.add(a[n]);
				findSum(a, n, sum-a[n], current, ans);
				current.remove(current.size()-1);
			}
		}
	}

}
