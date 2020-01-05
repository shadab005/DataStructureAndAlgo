package leetcode;

public class _567_PermutationInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkInclusion("adc", "dcda"));

	}
	
	//s1 = "ab" s2 = "eidbaooo",  one of the first string's permutations is the substring of the second string.
	//returns true
	static public boolean checkInclusion(String s1, String s2) {
     
		if(s1.isEmpty()) return true;
		if(s1.length() > s2.length()) return false;
		
		int countChar[] = new int[26];
		for(int i = 0; i < s1.length(); i++) {
			countChar[s1.charAt(i)-'a']++;
			countChar[s2.charAt(i)-'a']--;
		}
		
		//abcde ab
		for(int i = 0 ; i<s2.length()-s1.length(); i++) {
			if(checkIfAllZero(countChar))return true;
			int j = i+s1.length()-1;
			if(j<s2.length()-1) countChar[s2.charAt(j+1)-'a']--;
			countChar[s2.charAt(i)-'a']++;
		}
		if(checkIfAllZero(countChar))return true;
		return false;
    }

	private static boolean checkIfAllZero(int[] countChar) {
		for(int x:countChar) {
			if(x!=0)return false;
		}
		return true;
	}

}
