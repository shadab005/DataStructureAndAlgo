package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

import algo.util.Util;

public class _239_SlidingWindowMaximum {

	public static void main(String[] args) {
		Util.printArray(maxSlidingWindow(new int[] {}, 0));

	}

	// 1 ≤ k ≤ input array's size
	static public int[] maxSlidingWindow(int[] a, int k) {

		
		int n = a.length;
		if(k>n || n == 0 || k ==0) return new int[] {};
		int windowCount = n - k + 1;
		int ans[] = new int[windowCount];
		Deque<Integer> dq = new ArrayDeque<>(k);
		int i = 0;
		while (i < k) {
			while (!dq.isEmpty() && a[i] >= a[dq.peekLast()]) {
				dq.removeLast();
			}
			dq.add(i);
			i++;
		}
		
		int j = 0;
		ans[j] = a[dq.peekFirst()];
		j++;
		while (i < n) {
			while (!dq.isEmpty() && a[i] >= a[dq.peekLast()]) {
				dq.removeLast();
			}
			dq.add(i);
			while(!dq.isEmpty() && i-k+1>dq.peekFirst()) dq.removeFirst();
			ans[j] = a[dq.peekFirst()];
			j++;
			i++;
		}

		return ans;
	}

}
