package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _127_WorldLadder {

	public static void main(String[] args) {
		System.out.println(ladderLength("a", "c", Arrays.asList("a","b","c")));

	}

	static public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int step = 0;
		Set<String> set = new HashSet<>(wordList);
		if (beginWord.isEmpty()  || !set.contains(endWord)) return 0;
		Map<String, Boolean> visited = new HashMap<>();

		//System.out.println("Here");
		Queue<String> q = new ArrayDeque<>();
		q.add(beginWord);
		visited.put(beginWord, true);
		int qSize = 1;
		while(!q.isEmpty()){
			//System.out.println("Loop count = " + (step+1));
			qSize = q.size();
			for(int i=0;i<qSize;i++) {
				String processingWord = q.remove();
				//System.out.println("Processing Word = " + processingWord);
				if(processingWord.equals(endWord)) return step+1;
				List<String> nextLevelConnections = getAllValidNeigbhours(processingWord, set, visited);
				//System.out.println("Next level connections = " + nextLevelConnections);
				q.addAll(nextLevelConnections);
			}
			step++;
		}
		//System.out.println("Done");
		return 0;
	}

	private static List<String> getAllValidNeigbhours(String processingWord, Set<String> set, Map<String, Boolean> visited) {
		List<String> answer = new ArrayList<>();
		
		for(int i=0; i<processingWord.length();i++) {
		    for(int j=0;j<26;j++) {
		    	char ch = (char) ('a'+j);
		    	//System.out.println("ch="+ch);
		    	if(processingWord.charAt(i)!=ch) {
		    		String word = processingWord.substring(0,i)+String.valueOf(ch)+processingWord.substring(i+1); 
		    		if(set.contains(word) && !visited.getOrDefault(word, false)) {
		    			visited.put(word, true);
		    			answer.add(word);
		    		}
		    	}
		    }
		}
		return answer;
	}
}
