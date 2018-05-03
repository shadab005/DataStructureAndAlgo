package algo.strings;

public class SubstringBruteForce {

	//@returns first index in s1 that matches with s2 string 
	// ex : ababcd abc returns 2
	public static int strStr(final String s1, final String s2) {
        if(s1.isEmpty() || s2.isEmpty())return -1;
        if(s1.length()<s2.length())return -1;
        
        for(int i=0;i<s1.length();i++) {
        	int k = i;
        	for(int j = 0; j< s2.length() && k < s1.length(); j++) {
        		if(s1.charAt(k)!=s2.charAt(j))break;
        		k++;
        	}
        	if(k-i == s2.length())return i;
        }
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(strStr("bbbbbbbbab", "baba"));

	}

}
