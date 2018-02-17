package euler;

/*
 * A palindromic number reads the same both ways. 
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

public class LargestPallindromeProduct {

	public static void main(String[] args) {
		/*
		 * Brute force
		 * 
		 */
		int pi = -1, pj = -1;
		int mult = 1, ans = -1;
		for(int i=100;i<=999;i++) {
			for(int j=100;j<=999;j++) {
				mult = i*j;
				if(isPallindrome(mult) && ans < mult) {
					ans = mult;
					pi = i;
					pj = j;
				}
			}
		}
		System.out.println(pi +" * " + pj +" = " + ans);

	}

	private static boolean isPallindrome(int x) {
		String s = x+"";
		String s2 = new StringBuffer(s).reverse().toString();
		int y = Integer.parseInt(s2);
		if(x==y)return true;
		return false;
	}

}
