import java.util.Stack;

public class StackSort {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(2);
		s.push(1);
		s.push(15);
		s.push(3);
		//s.push(-1);
		//s.push(324);
		//sortStack(s);
		System.out.println(sort(s));

	}

	public static void sortStack(Stack<Integer> s) {
		System.out.println("Orginial stack :" + s);
		int n = s.size();
		for (int i = 0; i < n; i++) {
			int x = s.pop();
			sortRecurively(s, x, n - i - 1);
			System.out.println("After " + i + " iteration stack = " + s);
		}

	}

	private static void sortRecurively(Stack<Integer> s, int x, int lastIndex) {
		int y = 0, temp = 0;
		if (lastIndex > 0) {
			y = s.pop();
			// putting larger element in x
			if (y > x) {
				temp = x;
				x = y;
				y = temp;
			}
			sortRecurively(s, x, lastIndex - 1);
			s.push(y);
		} else {
			s.push(x);
		}

	}

	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while (!s.isEmpty()) {
			int tmp = s.pop();
			while (!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}

}
