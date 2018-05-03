
public class LongestPallindrome {
	
	public static String longestPalindrome(String s) {
		if(s==null || s.isEmpty())return "";
		if(s.length()==1)return s;
		int i = 0;
		int n = s.length();
		int ans = 1;
		int a = 0;
		int b = 0;
		while(i<n-1) {
			int ii = i+1;
			while(ii< n && s.charAt(ii)==s.charAt(i))ii++;
			ii--;
			if(ii-i+1>ans) {
				a=i;
				b=ii;
				ans=ii-i+1;
			}
			int j = i-1;
			int k = ii+1;
			while(j>=0 && k<n && s.charAt(j)==s.charAt(k)) {
				j--;
				k++;
			}
			int len = k-j-1;
			if(len>ans) {
				a=j+1;
				b=k-1;
				ans=len;
			}
			i++;
		}
        return s.substring(a, b+1);
    }

	public static void main(String[] args) {
		System.out.println(longestPalindrome("aaabaaa"));

	}

}
