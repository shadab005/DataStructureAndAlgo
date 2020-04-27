package leetcode;

public class _91_DecodePossibleString {
	
	public static void main(String[] args) {
		System.out.println(numDecodings("2112"));
	}

	
	static public int numDecodings(String s) {
		Integer dp[] = new Integer[s.length()];
		return solve(s, 0, dp);
    }
	
	
	public static int solve(String s, int index, Integer dp[]) {
		
		if(index >= s.length()) return 1;
		if(dp[index]!=null) return dp[index];
		if(s.charAt(index) == '0') return dp[index] = 0;
		
		int countWithoutJoining = 0, countWithJoining = 0;
		countWithoutJoining = solve(s, index+1, dp);
		//index i and index i+1 are joined to form single character
		//should check here if character at i and i+1 can be joined together
		if(index < s.length()-1 
				&& (    s.charAt(index) == '1' 
				        || 
				        (s.charAt(index) == '2' && s.charAt(index+1) < '7'))
		  )
		countWithJoining = solve(s, index+2, dp);
		return dp[index] = countWithJoining+countWithoutJoining;
	}
	
}
