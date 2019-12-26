package leetcode;

import java.util.HashMap;

public class _128_LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));

	}
	
	static  public int longestConsecutive(int[] nums) {
     
		HashMap<Integer, Boolean> map = new HashMap<>();
		for(int x:nums)map.put(x, false);
		int ans = 0;
		for(int x:nums) {
			if(map.get(x)==false) {
				ans = Math.max(ans, countUpAndDown(map,x));
			}
		}
		
		return ans;
    }

	private static int countUpAndDown(HashMap<Integer, Boolean> map, int x) {
		
		int z = x;
		int ans = 1;
		while(map.containsKey(z+1)) {
			ans++;
			map.put(z+1, true);
			z=z+1;
		}
		
		z = x;
		while(map.containsKey(z-1)) {
			ans++;
			map.put(z-1, true);
			z=z-1;
		}
		return ans;
		
	}

}
