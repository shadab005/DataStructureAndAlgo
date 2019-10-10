package contest;

import java.util.ArrayDeque;
import java.util.Deque;

public class EqualSubstringWithinBudget {

	public static void main(String[] args) {
		System.out.println(equalSubstring("abcd", "acde", 0));

	}
	
	static public int equalSubstring(String s, String t, int maxCost) {
		int ans = 0;
        int cost[] = new int[s.length()];
        for(int i=0;i<s.length();i++) {
        	cost[i] = Math.abs(s.charAt(i)-t.charAt(i));
        }
        if(s.length()==1) {
        	if(cost[0]<=maxCost) return 1;
        	else return 0;
        }
        
        //Indexes in dq
        Deque<Integer> dq = new ArrayDeque<>();
        int sum = 0;
        for(int i=0;i<s.length();i++) {
        	dq.addLast(i);
        	sum+=cost[i];
        	if(sum<=maxCost) {
        		ans = Math.max(ans, dq.peekLast()-dq.peekFirst()+1);
        	} else {
        		int j = dq.removeFirst();
        		sum=sum-cost[j];
        	}
        }
        
        return ans;
    }

}
