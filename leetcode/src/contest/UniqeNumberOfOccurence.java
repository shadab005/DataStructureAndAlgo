package contest;

import java.util.HashMap;

public class UniqeNumberOfOccurence {

	public static void main(String[] args) {
		System.out.println(uniqueOccurrences(new int[] {-3,0,1,-3,1,1,1,-3,10,0}));

	}
    //Check stream solution
	static public boolean uniqueOccurrences(int[] a) {
		if(a.length == 1) return true;
		HashMap<Integer, Integer> intCountMap = new HashMap<>();
		for(int x:a) {
			intCountMap.put(x, intCountMap.getOrDefault(x, 0)+1);
		}
		
		boolean count[] = new boolean[1001];
		for(int key: intCountMap.keySet()) {
			int val = intCountMap.get(key);
			if(count[val]) return false;
			count[val]=true;
		}
		return true;
	}

}
