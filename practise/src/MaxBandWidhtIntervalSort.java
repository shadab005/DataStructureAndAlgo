import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MaxBandWidhtIntervalSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		MaxBandWidhtIntervalSort solver = new MaxBandWidhtIntervalSort();
		int t = in.nextInt();
		while(t-->0) {
			int n = in.nextInt();
			Interval intervals[] = new Interval[n];
			for(int i=0;i<n;i++) {
				intervals[i]=new Interval(in.nextInt(), in.nextInt(), in.nextInt());
			}
			System.out.println(solver.solve(intervals, n));
		}
		in.close();
	}
	
	public long solve(Interval intervals[], int n) {
		Comparator<Interval> byStartTime = (o1,o2)->o1.s-o2.s;
		Arrays.sort(intervals, byStartTime);
		System.out.println(intervals);
		long[] bandwidthRequired = new long[n];
		bandwidthRequired[0]=intervals[0].b;
		for(int i=1;i<n;i++) {
			if(isOverLapping(intervals[i-1], intervals[i])) {
				bandwidthRequired[i]=intervals[i].b+bandwidthRequired[i-1];
			}else {
				bandwidthRequired[i] = bandwidthRequired[i]=intervals[i].b;
			}
		}
		return max(bandwidthRequired, n);
	}
	
	
	private long max(long[] bandwidthRequired, int n) {
		long m = bandwidthRequired[0];
		for(int i=1;i<n;i++) {
			m = Math.max(m, bandwidthRequired[i]);
		}
		return m;
	}

	private boolean isOverLapping(Interval i1, Interval i2) {
		if(i2.s < i1.e)return true;
		return false;
	}


	private static class Interval{
		int s; //start
		int e; //end
		int b = 0; //bandwidth
		Interval(int s, int e, int b){
			this.s = s;
			this.e = e;
			this.b = b;
		}
		
		public String toString() {
			return "["+s+","+e+","+b+"]";
		}
	}

}
