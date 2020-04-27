package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class _139_WordBreak {

	public static void main(String[] args) {
		System.out.println(wordBreak("catsanddog", Arrays.asList("cat", "cats", "sand", "and", "dog")));

	}
	
	static public boolean wordBreak(String s, List<String> wordDict) {
       Set<String> set = new HashSet<>(wordDict);
       //HashMap<String, Boolean> map = new HashMap<>();
       //return canBreak(s, set, map);
       return canBreakUsingBfs(s, set);
    }

	private boolean canBreak(String s, Set<String> set, HashMap<String, Boolean> map) {
		if(map.containsKey(s)) return map.get(s);
		if(s.isEmpty()) return true;
		boolean ans = false;
		for(int i=0;i<s.length();i++) {
			String sub = s.substring(0, i+1);
			if(set.contains(sub)) {
				ans = canBreak(s.substring(i+1), set, map);
				if(ans) {
					map.put(s, ans);
					return true;
				}
			}
		}
		map.put(s, ans);
		return ans;
	}
	
	
	static class Node {
		int index;
		Node(int ix){
			index = ix;
		}
	}
	
	private static boolean canBreakUsingBfs(String s, Set<String> set) {
		boolean visited[] = new boolean[s.length()+1];
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(0));
		visited[0] = true;
		while(!q.isEmpty()) {
			Node node = q.remove();
			int index = node.index;
			for(int i = index; i< s.length();i++) {
				if(set.contains(s.substring(index, i+1))) {
					if(i==s.length()-1) return true;
					if(visited[i+1]) continue;
					q.add(new Node(i+1));
				}
			}
		}
		return false;
	}
}
