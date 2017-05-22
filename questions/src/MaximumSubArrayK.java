public class MaximumSubArrayK {

	static Deque<Integer> dq = new Deque<>();

	static void printMax(int a[], int k) {
		for (int i = 0; i < k; i++) {
			while (!dq.isEmpty() && a[i] > dq.peekLast())dq.removeLast();
			dq.addLast(a[i]);
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
	}

	public static void main(String args[]) {
		int a[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		int k = 3;
		printMax(a, k);
		// Integer x = dq.peekFirst();
		// System.out.println(x);

	}
}
