package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _740_DeleteAndEarn {

	public static void main(String[] args) {
		int a[] = { 2, 2, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 7, 7, 8, 9, 9, 9, 10, 10 };
		// int a[] = {1,2,3,4};
		System.out.println(deleteAndEarn(a));

	}

	static public int deleteAndEarn(int[] a) {
		if(a.length ==0) return 0;
		int ans = 0;
		Arrays.sort(a);
		Map<Integer, Long> countKeyMap = Arrays.stream(a).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		int n = countKeyMap.size();
		int b[] = new int[n];
		int f[] = new int[n];
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			if (countKeyMap.containsKey(a[i])) {
				b[k] = a[i];
				f[k] = (int)(long)countKeyMap.getOrDefault(a[i], 0l);
				countKeyMap.remove(a[i]);
				k++;
			}
		}
		int inc = b[0]*f[0];
		int exc = 0;
		ans = Math.max(inc, exc);
		for (int i = 1; i < n; i++) {
			int prevInc = inc;
			if (b[i]-1 != b[i-1]) {
				inc = b[i]*f[i]+ Math.max(inc, exc);
			} else {
				inc = b[i]*f[i]+ exc;
			}
			exc = Math.max(prevInc, exc);
			ans = Math.max(inc, exc);
		}
		return ans;
	}

}
