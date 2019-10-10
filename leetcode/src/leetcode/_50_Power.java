package leetcode;

public class _50_Power {

	public static void main(String[] args) {
		System.out.println(myPow(2.00000, -2));
	}

	static public double myPow(double x, int n) {
		int sign = (x < 0 && n % 2 != 0) ? -1 : 1;
		double ans = Double.POSITIVE_INFINITY;
		x = Math.abs(x);
		if(n<0) {
			if(n == Integer.MIN_VALUE) return 0;
			ans = 1.0/power(x, -n);
		}else {
			ans = power(x, n);
		}
		return sign * ans;
	}

	private static double power(double x, int n) {
		if (n == 0)
			return 1;
		double ans = power(x, n / 2);
		ans *= ans;
		if (n % 2 == 1)
			ans *= x;
		return ans;
	}
}
