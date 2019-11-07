package leetcode;

import java.util.ArrayDeque;
import java.util.TreeSet;

public class _456_132Pattern {

	//case 1: 7, 10, 3, 8, 1 -> true
	//case 2: -1, 3, 2, 0 -> true
	//case 3: 1, 2, 3, 4 - > false
	//case 4: 3, 10, 1, 2 -> false
	//case 5: 20, 30, 10, 12, 4, 25, 35 -> true
	public static void main(String[] args) {
		System.out.println(find132pattern(new int[] {20, 30, 10, 12, 4, 25, 35}));

	}

	static public boolean find132pattern(int[] a) {

		int leftMin[] = new int[a.length];
		for(int i=0;i<a.length;i++) {
			if(i==0)leftMin[i]=Integer.MAX_VALUE;
			else {
				leftMin[i] = Math.min(leftMin[i-1], a[i-1]);
			}
		}
		
		int rightCeil[] = new int[a.length];
		TreeSet<Integer> set = new TreeSet<>();
		set.add(Integer.MIN_VALUE);
		for(int i = a.length-1; i>=0 ; i--) {
			rightCeil[i] = set.lower(a[i]);
			set.add(a[i]);
		}
		
		for(int i = 0 ; i < a.length ; i++) {
			if(leftMin[i] < a[i] && leftMin[i] < rightCeil[i] && rightCeil[i] < a[i]) {
				return true;
			}
		}
		return false;
	}
	
	static public boolean find132patternUsingStack(int[] a) {
		int leftMin[] = new int[a.length];
		for(int i=0;i<a.length;i++) {
			if(i==0)leftMin[i]=Integer.MAX_VALUE;
			else {
				leftMin[i] = Math.min(leftMin[i-1], a[i-1]);
			}
		}
		
		ArrayDeque<Integer> candidatesInStack = new ArrayDeque<>();
		for(int j = a.length-1; j>=0 ; j--) {
			
			if(a[j] > leftMin[j]) {
			   while(!candidatesInStack.isEmpty() && leftMin[j] >= candidatesInStack.peek()) candidatesInStack.pop();
			   
			   if(!candidatesInStack.isEmpty() && a[j] > candidatesInStack.peek()) return true;
			   
			   candidatesInStack.push(a[j]);
			}
		}
		
		return false;
	}
}
