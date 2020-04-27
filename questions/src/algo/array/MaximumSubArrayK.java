package algo.array;
import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumSubArrayK {

	

	static void printMax(int a[], int k) {
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < Math.min(k,a.length); i++) {
			while (!dq.isEmpty() && a[i] > dq.peekLast())dq.removeLast();
			dq.addLast(a[i]);
		}
		if(k>a.length) {
			System.out.println(dq.peekFirst());
			return;
		}
		for (int i = 0; i <= a.length - k; i++) {
			if (i > 0) {
				while (!dq.isEmpty() && a[i + k - 1] > dq.peekLast())dq.removeLast();
				dq.addLast(a[i + k - 1]);
			}
			System.out.print(dq.peekFirst() + " ");
			if (dq.peekFirst().equals(a[i])) {
				dq.removeFirst();
			}
		}
		System.out.println();
	}
	
	static void printMaxII(int a[], int k) {
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i=0;i<a.length;i++) {
			while(!dq.isEmpty() && dq.peek() < a[i]) dq.remove();
			dq.addLast(a[i]);
			if(i>=k-1) {
				System.out.print(dq.peekFirst() + " ");
				if(a[i-k+1] == dq.peekFirst()) {
					dq.removeFirst();
				}
			}
		}
		if(k>a.length) {
			System.out.print(dq.peekFirst());
		}
		System.out.println();
	}

	public static void main(String args[]) {
		test(new int[] {1, 2, 3, 1, 4, 5, 2, 3, 6}, 3);
		test(new int[] {1, 2}, 2);
		System.out.println("Done test");

	}
	
	static void test(int a[], int k) {
		printMax(a, k);
		printMaxII(a, k);
	}
}
