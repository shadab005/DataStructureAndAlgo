package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _46_47_Permutation {

	public static void main(String[] args) {
		System.out.println(permute(new int[] {}));

	}

	static public List<List<Integer>> permute(int[] nums) {
		Integer[] a = Arrays.stream(nums).mapToObj(Integer::valueOf).toArray(Integer[]::new);
		List<List<Integer>> ans = new ArrayList<>();
		permute(a, a.length-1, ans);
		return ans;

	}

	static void permute(Integer a[], int n, List<List<Integer>> ans) {
		if (n < 0) {
			ans.add(new ArrayList<>(Arrays.asList(a)));
		}

		for (int i = n; i >= 0; i--) {
			// swap char at n and i
			swap(a, i, n);
			// call permutation
			permute(a, n - 1, ans);
			// unswap char at n and i
			swap(a, i, n);
		}
	}

	static void swap(Integer a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
