package expedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class UserNameSystem {

	public static void main(String[] args) {
		System.out.println(usernamesSystem(Arrays.asList("bob", "alice", "bob", "alice", "bob", "alice")));

	}
	
	public static List<String> usernamesSystem(List<String> u) {
	
		if(u.size()==1) return Collections.singletonList(u.get(0));
		HashMap<String, Integer> map = new HashMap<>();
		HashMap<String, Integer> countMap = new HashMap<>();
		
		for(String s: u) {
			map.put(s, map.getOrDefault(s, 0)+1);
			countMap.put(s, countMap.getOrDefault(s, 0)+1);
		}
		List<String> answer = new ArrayList<>();
		for(String s: u) {
			int count = countMap.get(s)-map.get(s);
			if(count == 0) {
				answer.add(s);
			} else {
				answer.add(s+count);
			}
			map.put(s, map.get(s)-1);
		}
		return answer;
    }

}
