package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _253_MeetingRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static  public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals,(a,b)->(a.start-b.start));
        PriorityQueue<Interval> pq=new PriorityQueue<>((a,b)->(a.end-b.end));
        for(Interval i:intervals){
            if(!pq.isEmpty()&&pq.peek().end<=i.start){
                pq.poll();
            }
            pq.add(i);
        }
        return pq.size();
    }
	
	static class Interval {
		int start;
		int end;
	}

}
