package leetcode;

import java.util.HashMap;

public class LongestSubstringWithDistinctCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("aab"));
	}

	static public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) return 0;
		int currentLength = 0;
		int max = 0;
		int minIndexInMap = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0; i < s.length(); i++) {
			if(!map.containsKey(s.charAt(i))) {
				minIndexInMap = Math.min(minIndexInMap, i);
				map.put(s.charAt(i), i);
				currentLength++;
			}else {
				int lastIndex = map.get(s.charAt(i));
				for(int j = minIndexInMap; j <= lastIndex; j++) map.remove(s.charAt(j));
				minIndexInMap = lastIndex+1;
				currentLength = i-lastIndex;
				map.put(s.charAt(i), i);
			}
			max = Math.max(max, currentLength);
		}
		return max;
	}

}
