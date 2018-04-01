import java.util.Comparator;
import java.util.PriorityQueue;

public class EfficientCabScheduling {

	public static int getMinimumTime(int n, int k, int[] tripTime) {
	   int count[] = new int[k];
	   Comparator<CabInfo> byTime = (o1,o2)->o1.waitingTime-o2.waitingTime;
	   PriorityQueue<CabInfo> pq = new PriorityQueue<>(byTime);
	   for(int i=0;i<k;i++) {
		   pq.add(new CabInfo(i, tripTime[i]));
	   }
	   CabInfo cabInfo = null;
	   while(n-->0) {
		  // System.out.println("k="+k);
		   cabInfo = pq.remove();
		   count[cabInfo.cab]++;
		   pq.add(new CabInfo(cabInfo.cab, count[cabInfo.cab]*tripTime[cabInfo.cab]+tripTime[cabInfo.cab]));
	   }
	   return cabInfo.waitingTime;
	   
	}
	
	public static int getMinimumTimeZ(int n, int k, int[] tripTime) {
		PriorityQueue<CabTripTime> p = new PriorityQueue<>();
		for (int i = 0; i < tripTime.length; i++) {
			p.add(new CabTripTime(tripTime[i], tripTime[i]));
		}
		int trips = 0, time = 0;
		while (trips < n) {
			CabTripTime c = p.remove();
			time = c.time;
			c.time = c.cabTripTime + c.time;
			trips++;
			//time++;
			p.add(c);
		}
		return time;
	}
	
	static class CabInfo{
		int cab;
		int waitingTime;
		CabInfo(int cabId, int time) {
			cab =cabId;
			waitingTime = time;
		}
	}

	static class CabTripTime implements Comparable<CabTripTime> {
		int time;
		int cabTripTime;

		public CabTripTime(int time, int cabTripTime) {
			this.time = time;
			this.cabTripTime = cabTripTime;
		}

		@Override
		public int compareTo(CabTripTime o) {
			if (this.time > o.time) {
				return 1;
			} else if (this.time < o.time) {
				return -1;
			}
			return 0;
		}
	}

	
	public static void main(String[] args) {
		/*int n = 8;
		int k = 3;
		int tripTime[] = { 2, 5, 2 }; // trip time
*/		int n = 3;
		int k = 2;
		int tripTime[] = { 1,2 }; // trip time
		//Arrays.sort(tripTime);
		System.out.println(getMinimumTime(n, k, tripTime));
		System.out.println(getMinimumTimeZ(n, k, tripTime));
	}
}
