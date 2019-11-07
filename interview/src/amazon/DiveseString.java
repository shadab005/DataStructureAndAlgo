package amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DiveseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String solution(int A,int B,int C) {
        Map<Character,Integer> map = new HashMap<>();
        if(A>0)
        map.put('a',A);

        if(B>0)
            map.put('b',B);
        if(C>0)
        map.put('c',C);

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        //int cnt = 0;
        for (Map.Entry<Character, Integer> e: map.entrySet()) {
          //  cnt += e.getValue();
            pq.add(e);
        }

        Map.Entry<Character, Integer> onHold = null;

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> cur = pq.poll();
            sb.append(cur.getKey());

            if (onHold != null) {
                pq.add(onHold);
                onHold = null;
            }
            int curValue = cur.getValue();
            if (curValue > 1) {
                cur.setValue(curValue-1);
                if (sb.length() >= 2 && cur.getKey() == sb.charAt(sb.length()-2)) { // on hold
                    onHold = cur;
                } else {
                    pq.add(cur);
                }
            }

        }
        return sb.toString();
    }

}
