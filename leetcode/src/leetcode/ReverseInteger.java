package leetcode;

public class ReverseInteger {

	public static void main(String[] args) {

		System.out.println(reverse(-2147483648));

	}

	static public int reverse(int x) {

		boolean isNegative = (x < 0);
		String s = new StringBuffer(String.valueOf(x)).reverse().toString();
		if (!isNegative) {
			if (Long.parseLong(s) > Integer.MAX_VALUE) {
				return 0;
			} else {
				return Integer.parseInt(s);
			}
		} else {
			s = s.substring(0, s.length() - 1);
			if (Long.parseLong(s) - 1 > Integer.MAX_VALUE) {
				return 0;
			} else {
				return -1 * Integer.parseInt(s);
			}
		}
	}

	static public boolean isPalindrome(int x) {
		return String.valueOf(x).equals(new StringBuffer(String.valueOf(x)).reverse().toString());
	}

}
