package amazon;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumCompressionCost {

	public static void main(String[] args) {
		System.out.println(minimumTime(4, Arrays.asList(4,8,6,12)));
		

	}

	static int minimumTime(int numOfSubFiles, List<Integer> files)
    {
        int cost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x: files)pq.add(x);
        while(pq.size() != 1) {
        	int x = pq.remove();
        	int y = pq.remove();
        	cost += (x+y);
        	pq.add(x+y);
        }
        return cost;
    }
}
