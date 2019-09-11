package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationPhoneNumber_17 {

	public static void main(String[] args) {

		System.out.println(letterCombinations("22"));
	}

	static public List<String> letterCombinations(String digits) {
		List<String> ans = new ArrayList<>();
		if(digits == null || digits.isEmpty()) return ans;
		
		Map<Character, List<Character>> map  = new HashMap<Character, List<Character>>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{
		    put('2', Arrays.asList('a','b', 'c'));
		    put('3', Arrays.asList('d','e', 'f'));
		    put('4', Arrays.asList('g','h', 'i'));
		    put('5', Arrays.asList('j','k', 'l'));
		    put('6', Arrays.asList('m','n', 'o'));
		    put('7', Arrays.asList('p','q', 'r', 's'));
		    put('8', Arrays.asList('t','u', 'v'));
		    put('9', Arrays.asList('w','x', 'y', 'z'));
		}};
		
		
		process(0, new StringBuilder(), ans, digits, map);
		
		
		return ans;
	}

	private static void process(int i, StringBuilder sb, List<String> ans, String digits, Map<Character, List<Character>> map) {
		
		if(i==digits.length()) {
			ans.add(sb.toString());
			return;
		}
		for(char c : map.get(digits.charAt(i))) {
			sb.append(c);
			process(i+1, sb, ans, digits, map);
			sb.deleteCharAt(sb.length()-1);
		}
		
	}

}
