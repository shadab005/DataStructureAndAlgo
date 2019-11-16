package leetcode;

import java.util.ArrayDeque;

public class _772_BasicCalculator {

	public static void main(String[] args) {
		System.out.println(calculate("0-2147483648"));

	}

	public static int calculate(String s) {
		s = s.replaceAll(" " , "");
		char ch[] = s.toCharArray();
		int i = 0;
		ArrayDeque<Long> operandStack = new ArrayDeque<>();
		ArrayDeque<Character> operatorStack = new ArrayDeque<>();
		while(i<ch.length) {
			if(isNumber(i, ch)) {
				int j = getLastIndexOfThisNumber(i, ch);
				long num = getNum(i,j,ch);
				operandStack.push(num);
				i = j;
			} else if(ch[i] == ')') {
				//calculate till you find '('
				while(operatorStack.peek()!='(') {
					process(operandStack, operatorStack);
				}
				operatorStack.pop(); //popping up '('
			} else if(!operandStack.isEmpty() && !operatorStack.isEmpty() && priority(ch[i]) <= priority(operatorStack.peek()) && operatorStack.peek()!='(') {
				while(!operandStack.isEmpty() && !operatorStack.isEmpty() && priority(ch[i]) <= priority(operatorStack.peek()) && operatorStack.peek()!='(') {
					//pop operator from stack, pop two numbers, calculate result and push it to operand stack
					process(operandStack, operatorStack);
				}
				operatorStack.push(ch[i]);
			} else {
				operatorStack.push(ch[i]);
			}
			i++;
		}
		
		while(!operatorStack.isEmpty()) {
			process(operandStack, operatorStack);
		}
		if(operandStack.size()!=1) {
			System.out.println("Something wrong " + operandStack);
		}
		return (int)(long)operandStack.pop();
	}

	private static void process(ArrayDeque<Long> operandStack, ArrayDeque<Character> operatorStack) {
		long n1 = operandStack.pop();
		long n2 = operandStack.pop();
		char op = operatorStack.pop();
		operandStack.push(calc(n1,n2,op));
		
	}

	private static long calc(long n1, long n2, char op) {
		switch (op) {
		case '+':
			return n2 + n1;
		case '-':
			return n2 - n1;
		case '*':
			return n2 * n1;
		case '/':
			return n2 / n1;
		default:
			throw new IllegalArgumentException("Invalid operator " + op);
		}
	}

	private static long getNum(int i, int j, char[] ch) {
		String num = String.valueOf(ch, i, j - i + 1);
		return Long.parseLong(num);
	}

	private static int getLastIndexOfThisNumber(int i, char[] ch) {
		if (!Character.isDigit(ch[i])) i++;
		while (i < ch.length && Character.isDigit(ch[i]))i++;
		return i - 1;
	}

	private static boolean isNumber(int i, char[] ch) {
		if (Character.isDigit(ch[i])) return true;
		if (ch[i] == '(' || ch[i] == ')') return false;
		if (i == 0) return true;
		if (Character.isDigit(ch[i - 1]) || ch[i - 1] == ')')return false;
		return true;
	}

	private static int priority(char c) {
		switch (c) {
		case '+':
			return 0;
		case '-':
			return 0;
		case '*':
			return 1;
		case '/':
			return 1;
		case '(':
			return 2;
		default:
			throw new IllegalArgumentException("Invalid character " + c);
		}
	}

}
