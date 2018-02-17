import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		int min = Math.min(newInterval.start, newInterval.end);
		int max = Math.max(newInterval.start, newInterval.end);
		newInterval.start = min;
		newInterval.end = max;
		
		ArrayList<Interval> ans = new ArrayList<>();
		if(intervals.size()==0) {
			ans.add(newInterval);
			return ans;
		}
		
		int floorIndex = floorIndex(intervals, newInterval.start);
		//System.out.println("Floor index = " + floorIndex + " key = " + newInterval.start);
		int ceilIndex = ceilIndex(intervals, newInterval.end);
		//System.out.println("Ceil index = " + ceilIndex + " key = " + newInterval.end);
		if(floorIndex==intervals.size()-1 && newInterval.start> intervals.get(floorIndex).end) {
			ans.addAll(intervals);
			ans.add(newInterval);
			return ans;
		}
		else if(ceilIndex==-1)ceilIndex=intervals.size()-1;
		else if (intervals.get(ceilIndex).start != newInterval.end)	ceilIndex--;
		
		//System.out.println("New Ceil index = " + ceilIndex);
		if(ceilIndex < 0) {
			ans.add(newInterval);
			ans.addAll(intervals);
			return ans;
		}else if(floorIndex<0) {
			intervals.get(0).start = newInterval.start;
			floorIndex=0;
		}
		
		List<Interval> first = intervals.subList(0, floorIndex);
		if (first.size() > 0)ans.addAll(intervals.subList(0, floorIndex));
		
		if(intervals.get(floorIndex).end < newInterval.start) {
			if(floorIndex == ceilIndex) {
				ans.add(intervals.get(floorIndex));
				ans.add(newInterval);
				ceilIndex++;
				floorIndex++;
			}else {
				ans.add(intervals.get(floorIndex));
				floorIndex++;
				intervals.get(floorIndex).start = Math.min(intervals.get(floorIndex).start, newInterval.start);
			}
		}

		int maxIndex = Math.max(intervals.get(ceilIndex).end, newInterval.end);
		ans.add(new Interval(intervals.get(floorIndex).start, maxIndex));
		
		int next = ceilIndex + 1;
		if (next < intervals.size()) {
			ans.addAll(intervals.subList(next, intervals.size()));
		}

		return ans;
	}

	private int rank(ArrayList<Interval> intervals, int key) {
		int low = 0;
		int high = intervals.size() - 1;
		int mid = 0;
		int compare = 0;
		while (low <= high) {
			mid = low + (high - low) / 2;
			compare = key - intervals.get(mid).start;
			if (compare < 0) high = mid - 1;
			else if(compare > 0)low = mid+1;
			else return mid;
		}
		return low;
	}

	private int floorIndex(ArrayList<Interval> intervals, int key) {
		int rank = rank(intervals, key);
		if (rank < intervals.size() && intervals.get(rank).start == key)
			return rank;
		return rank - 1;
	}

	private int ceilIndex(ArrayList<Interval> intervals, int key) {
		int rank = rank(intervals, key);
		if (rank == intervals.size())
			return -1;
		return rank;
	}

	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<>();
	/*	intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 16));*/
		// System.out.println(intervals.subList(0, 0));
		intervals.add(new Interval(31935139, 38366404));
		intervals.add(new Interval(54099301, 76986474));
		intervals.add(new Interval(87248431, 94675146));
		//System.out.println(intervals);
		MergeIntervals m = new MergeIntervals();
		System.out.println(m.insert(intervals, new Interval(43262807, 68844111)));
	}

	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public String toString() {
			return "[" + start + "," + end + "]";
		}
	}

}
