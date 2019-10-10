package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class _140_WordBreak_II {

	public static void main(String[] args) {
		System.out.println(wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
		System.out.println(wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));

	}

	static public List<String> wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>(wordDict);
		Map<Integer, List<String>> map = new HashMap<>();
		return canBreak(0, s, set, map);
	}

	private static List<String> canBreak(int i, String s, Set<String> set, Map<Integer, List<String>> map) {
		if (s.isEmpty())
			return Collections.emptyList();
		if (map.containsKey(i))
			return map.get(i);
		List<String> current = new ArrayList<>();
		for (int j = i; j < s.length(); j++) {
			String sub = s.substring(i, j + 1);
			String subPrefix = sub + " ";
			if (set.contains(sub)) {
				List<String> subList = canBreak(j + 1, s, set, map);
				if (subList.isEmpty() && j==s.length()-1) {
					current.add(sub);
				}
				for (String str : subList) {
					current.add(subPrefix + str);
				}
			}
		}
		map.put(i, current);
		return map.get(i);
	}

}
