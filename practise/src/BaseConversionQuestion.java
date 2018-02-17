
public class BaseConversionQuestion {

	// A-Z = 65-90
	public static void main(String[] args) {
		//System.out.println(titleToNumber("A"));
		System.out.println(decimaltoBinary(2));
		System.out.println(convertToTitle(28));
	}

	//Excel colum number : A B .. Z AA AB .. AZ BA BB ..
	public static int titleToNumber(String s) {
		int n = s.length();
		int ans = 0;
		int inc = 1;
		for(int i = 1;i<n;i++) {
			ans+=inc*26;
			inc = inc*26;
		}
		char[] ch = s.toCharArray();
		int x = 0;
		int next = 0;
		for(int i=1;i<=n;i++) {
			x = ch[i-1]-65;
			next+=x*Math.pow(26, n-i);
		}
		ans+=next;
		return ans+1;
	}
	
	//Excel colum number : A B .. Z AA AB .. AZ BA BB ..
	public int titleToNumberBase26Approach(String s) {
	       int result = 0;
	       for (int i = 0; i < s.length(); i++) {
	               result = result * 26 + (s.charAt(i) - 'A' + 1);
	       }
	       return result;
   }
	
	public static String convertToTitle(int n) {
		int b = 26;
		String ans = "";
		int  r = 0;
		char c = 4;
		while(n!=0) {
			//System.out.println("n="+n);
			r = (n-1)%b+65;
			c = (char)r;
			ans = c+ans;
			n = (n-1)/b;
		}
		return ans;
    }
   
	public static int decimaltoBinary(int n) {
		int b = 2;
		int ans = 0;
		int r=0;
		int multiplier = 1;
		while(n!=0) {
			r=n%b;
			ans=multiplier*r+ans;
			multiplier=10*multiplier;
			n = n/b;
		}
		return ans;
	}
}
