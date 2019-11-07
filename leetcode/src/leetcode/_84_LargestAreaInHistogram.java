package leetcode;

import java.util.ArrayDeque;

public class _84_LargestAreaInHistogram {

	public static void main(String[] args) {
		int h[] = {2,1,2}; //3
		System.out.println(maxArea(h));

	}
	
	static public int largestRectangleArea(int[] h) {
		if(h.length==0)return 0;
		int n = h.length;
		int ans = h[0];
		ArrayDeque<Integer> stack = new ArrayDeque<>();		
		for(int i = 0 ; i < n ; i++) {
			int j = -1;
			while(!stack.isEmpty() && h[i] <= h[stack.peek()]) {
				j = stack.pop();
				ans = max(ans, (i-j)*h[j], (i-j+1)*h[i]);
			}
			if(j!=-1) {
				h[j] = h[i];
				stack.push(j);
			} else {
				stack.push(i);
			}
		}
		while(!stack.isEmpty()) {
		   int j = stack.pop();
		   ans = Math.max(ans, h[j]*(n-j));	
		}
		return ans;
    }
	
	static int max(int a, int b, int c) {
		return (a>b)?(a>c?a:c):(b>c?b:c);
	}

	
	/*
	 * Idea is how much we can expand at any bar. We can expand the rectangle at the current bar if the adjcanet is greater than
	 * or equal to current bar. And so on. 
	 * 
	 */
	static public int maxArea(int[] h) {
		if(h.length==0)return 0;
		int n = h.length;
		int ans = h[0];
		ArrayDeque<Integer> stack = new ArrayDeque<>();		
		stack.push(-1);
		for(int i = 0 ; i < n ; i++) {
			int j = -1;
			while(stack.peek()!=-1 && h[i] < h[stack.peek()]) {
				j = stack.pop();
				//we do stack.peek to see how much the current can expand on its left
				//we do it from i, because current bar can expand upto i at its right
				ans = Math.max(ans, (i-stack.peek()-1)*h[j]);
			}
			stack.push(i);
		}
		
		while(stack.peek()!=-1) {
			int j = stack.pop();
			ans = Math.max(ans, (n-stack.peek()-1)*h[j]);
		}
		return ans;
	}
}
