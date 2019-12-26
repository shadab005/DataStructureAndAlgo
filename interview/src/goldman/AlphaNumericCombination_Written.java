package goldman;

import java.util.Arrays;


//Better solution : _111_DecodePossibleString
public class AlphaNumericCombination_Written {

	public static void main(String[] args) {
		System.out.println(calculatePossibleCombinations("2112"));
	}
	
	private static boolean joinable(int i, String s) {
		if(i+1 >= s.length()) return false;
		if(s.charAt(i) == '0') return false;
		int x = Integer.parseInt(String.valueOf(s.charAt(i)+""+s.charAt(i+1)));
		return (x>=10 && x<=26);
	}

	public static long calculatePossibleCombinations(String inputStr) {
		long memo[] = new long[inputStr.length()];
		Arrays.fill(memo, -1);
		return possibleCombination(0, inputStr, memo);
	}

	private static long possibleCombination(int i, String s, long memo[]) {
		if(i==s.length()-1 && s.charAt(i)!='0') return 1;
		if(i>=s.length()) return 1;
		if(memo[i]!=-1) return memo[i];
		long withoutJoining=0, withJoining=0;
		if(s.charAt(i)=='0') return 0;
		if(i+1 < s.length() && s.charAt(i+1)== '0') {
			if(joinable(i,s)) withJoining = possibleCombination(i+2, s,memo);
		} else {
			withoutJoining = possibleCombination(i+1, s,memo);
			if(joinable(i,s)) withJoining = possibleCombination(i+2, s,memo);
		}
		memo[i]=withoutJoining+withJoining;
		return memo[i];
	}

	

}
