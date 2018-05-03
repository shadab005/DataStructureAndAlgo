import java.util.Comparator;
import java.util.PriorityQueue;

public class EfficientCabScheduling {

	private static final Comparator<CabScheduleData> LAST_SCHEDULE_TIME = (o1,o2)->o1.lastScheduleTime-o2.lastScheduleTime;
	public static int getMinimumTime(int n, int k, int[] tripTime) {
	   int tripCount[] = new int[k];
	   PriorityQueue<CabScheduleData> priorityScheduleQueue = new PriorityQueue<>(LAST_SCHEDULE_TIME);
	   for(int i=0;i<k;i++) {
		   priorityScheduleQueue.add(new CabScheduleData(i, tripTime[i]));
	   }
	   CabScheduleData cabScheduleData = null;
	   while(n>0) {
		   cabScheduleData = priorityScheduleQueue.remove();
		   tripCount[cabScheduleData.cabIdentifier]+=1;
		   priorityScheduleQueue.add(new CabScheduleData(cabScheduleData.cabIdentifier, tripCount[cabScheduleData.cabIdentifier]*tripTime[cabScheduleData.cabIdentifier]+tripTime[cabScheduleData.cabIdentifier]));
		   n--;
	   }
	   return cabScheduleData.lastScheduleTime;
	   
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
			p.add(c);
		}
		return time;
	}
	
	static class CabScheduleData{
		int cabIdentifier;
		int lastScheduleTime;
		CabScheduleData(int cabId, int time) {
			cabIdentifier =cabId;
			lastScheduleTime = time;
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
