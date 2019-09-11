package leetcode;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));

	}

	static public String longestCommonPrefix(String[] strs) {
    	if(strs == null || strs.length == 0) return "";
    	if(strs.length == 1)  return strs[0];
    	
    	String commonPrefixNow = strs[0];
    	for(int i=1;i<strs.length;i++) {
    		commonPrefixNow = commonPrefixLongest(commonPrefixNow, strs[i]);
    		if(commonPrefixNow.isEmpty())return "";
    	}
		return commonPrefixNow;
    }

	private static String commonPrefixLongest(String prefix, String s) {
		StringBuilder sb = new StringBuilder("");
		int i = 0, j=0;
		while(i<prefix.length() && j<s.length()) {
			if(prefix.charAt(i) == s.charAt(j)) {
				sb.append(prefix.charAt(i));
			} else {
				return sb.toString();
			}
			i++;
			j++;
			
		}
		return sb.toString();
	}
}
