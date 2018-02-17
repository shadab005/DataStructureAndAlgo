import java.util.Stack;

public class MinStack {

	Stack<Integer> stack = new Stack<>();
	Stack<Integer> minStack = new Stack<>();

	public void push(int x) {
		stack.push(x);
		System.out.println("Inserting element = " + x);
		if (!minStack.isEmpty()) {
			System.out.println("a");
			if (x <= minStack.peek()) {
				System.out.println("b");
				minStack.push(x);
			}
		} else {
			System.out.println("c");
			minStack.push(x);
		}
	}

	public void pop() {
		if (!stack.isEmpty()) {
			int y = stack.pop();
			if (minStack.peek() == y)
				minStack.pop();
		}
	}

	public int top() {
		if (stack.isEmpty())
			return -1;
		return stack.peek();
	}

	public int getMin() {
		if (minStack.isEmpty())
			return -1;
		return minStack.peek();
	}

	public static void main(String args[]) {
		MinStack m = new MinStack();
		m.push(644643544);
		/*m.push(644643544);
		m.push(644643544);
		m.push(644643544);*/
		m.push(909204);
		m.push(909204);
		m.push(909204);
		m.push(909204);
		m.push(465865082);
		m.push(465865082);
		System.out.println(m.getMin());
/*
		Stack<Integer> z = new Stack<>();
		z.push(4);
		z.push(3);
		z.push(5);
		System.out.println(z.peek());*/
	}

}
