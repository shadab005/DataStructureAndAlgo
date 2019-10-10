package leetcode;

// a a*
//aa *
public class _44_WildcardMatching {

	public static void main(String[] args) {
		System.out.println(isMatch("a", "a*"));

	}
	
	
	static public boolean isMatch(String s1, String s2) {
	  Boolean dp[][] = new Boolean[s1.length()][s2.length()];
       return match(s1,  s1.length()-1, s2, s2.length()-1, dp);
    }


	private static boolean match(String s1, int i, String s2, int j, Boolean dp[][]) {
		if(i>=0 && j>=0 && dp[i][j]!=null)return dp[i][j];
		if(i<0 && j < 0) return true;
		if(j<0 && i>=0) return false;
		if(i<0) {
			while(j>=0 && (s2.charAt(j)=='*')) {
				j--;
			}
			if(j<0)return true;
			else return false;
		}
		if(s2.charAt(j)!='*') {
			if(s2.charAt(j)!='?' && s2.charAt(j) != s1.charAt(i)) return false;
			return dp[i][j] = match(s1, i-1, s2, j-1, dp);
		} else {
			return dp[i][j] = match(s1, i-1, s2, j-1, dp) || match(s1, i, s2, j-1, dp)|| match(s1, i-1, s2, j, dp);
		}
	}

}
