package salesforce;

import java.util.Comparator;
import java.util.PriorityQueue;

//import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		// float ip[]= {80.02f,81.02f,79.56f,78.67f,80.12f,79.23f,77.45f};
		// float ip[]= {2,2,3,3,3,1,2};
		// float ip[]= {3};
		// int ans[]=doit(ip);
		// for(int i=0;i<ans.length;i++)System.out.println(ans[i]+ " ");

		int a[] = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
	//	int a[] = { 5,10};
		medians(a);

	}

	static void medians(int[] a) {
		PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> right = new PriorityQueue<>();
		for (int i = 0; i < a.length; i++) {
			if (left.size() <= right.size())left.add(a[i]);
			else right.add(a[i]);
			if (!left.isEmpty() && !right.isEmpty()) {
				if (left.peek() > right.peek()) {
					left.add(right.remove());
					right.add(left.remove());
				}
			}
			if (left.size() == right.size()) {
				  System.out.println((left.peek() + right.peek()) / 2);
			} else if (left.size() > right.size()) {
				System.out.println(left.peek());
			} else {
				System.out.println(right.peek());
			}
		}
	}

	static int[] doit(float[] a) {
		int n = a.length;
		if (n == 0)
			return new int[n];
		int span[] = new int[n];
		// for(int i=0;i<n;i++)span[i]=1;
		Stack s = new Stack();
		s.push(0);
		span[0] = 1;
		int top = 0;
		for (int i = 1; i < n; i++) {
			top = i;
			while (!s.isEmpty() && a[s.peek()] <= a[i]) {
				top = s.pop();
			}
			span[i] = i - top + 1;
			s.push(i);
			if (a[top] == a[i]) {
				span[i] += span[top] - 1;
				s.pop();
				s.push(top);
			}
		}
		return span;

	}

	public static class Stack {

		private Node first = null;

		private class Node {
			int item;
			Node next;
		}

		public boolean isEmpty() {
			return first == null;
		}

		public void push(int item) {
			Node temp = new Node();
			temp.item = item;
			temp.next = first;
			first = temp;
		}

		public int pop() {
			if (first == null)
				return -1;
			Node temp = first;
			first = temp.next;
			return temp.item;
		}

		public int peek() {
			if (first == null)
				return -1;
			return first.item;
		}

	}

}
