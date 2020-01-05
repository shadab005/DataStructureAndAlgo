package leetcode;

import java.util.HashMap;

public class _76_MinimumWindowSubstring {

	public static void main(String[] args) {
		System.out.println(minWindow("aaaaba", "aaab")); //"baca"

	}

	static public String minWindow(String s, String t) {

		HashMap<Character, Integer> map = new HashMap<>();
		for(char x:t.toCharArray())map.put(x, map.getOrDefault(x, 0)+1);
		
		int i = 0, j = 0, I = 0, J = Integer.MAX_VALUE, sum = 0;;
		HashMap<Character, Integer> windowCount = new HashMap<>();
		while(i<s.length() && !map.containsKey(s.charAt(i)))i++;
		if(i==s.length())return "";
		j = i;
		
		while(j < s.length()) {
			char c = s.charAt(j);
			if(map.containsKey(c)) {
				windowCount.put(c, windowCount.getOrDefault(c, 0)+1);
			    if(windowCount.get(c) <= map.get(c))sum++;
			    while(i<j && (!map.containsKey(s.charAt(i)) 
			    		|| map.getOrDefault(s.charAt(i), 0) < windowCount.getOrDefault(s.charAt(i), 0))) {
					if(map.containsKey(s.charAt(i))) {
						windowCount.put(s.charAt(i), windowCount.getOrDefault(s.charAt(i), 0)-1);
					}
					i++;
				}
				if(sum == t.length()) {
			    	if(j-i < J-I) {
			    		J=j;
			    		I=i;
			    	}
			    }
			}
			j++;
		}
		if(I==0 && J==Integer.MAX_VALUE) return "";
		return s.substring(I,J+1);
	}

}
