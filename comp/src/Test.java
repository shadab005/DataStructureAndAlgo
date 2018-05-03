import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
public class Test {

	private static final Logger logger = Logger.getLogger(Test.class.getName());
    private static final AtomicLong globalSequenceNumber     = new AtomicLong(0);
	public static void main(String args[]) {
		System.out.println(Test.class.getName());
		 logger.info("Logging begins...");  
		 System.out.println(globalSequenceNumber.getAndIncrement());
		 System.out.println(globalSequenceNumber.getAndIncrement());
		 System.out.println(globalSequenceNumber.getAndIncrement());
	}

	static int[] sort_hotels(String keywords, int[] hotel_ids, String[] reviews) {
		keywords = keywords.toLowerCase();
		for(int j=0;j<reviews.length;j++) {
			reviews[j]=reviews[j].toLowerCase().replaceAll("\\.", "").replaceAll(",", "");
		}
		
		int ans[] = new int[hotel_ids.length];
		Set<String> keys = new HashSet<>(Arrays.asList(keywords.split("\\s+")));

		for (int i = 0; i < hotel_ids.length; i++) {
			for (String k : keys) {
				ans[hotel_ids[i]] += countOccurences(reviews[i], k);
			}
		}
		int n = hotel_ids.length;
		Integer b[] = new Integer[hotel_ids.length];
		for (int i = 0; i < n; i++)
			b[i] = i;
		Comparator<Integer> byAnotherArray = (Integer o1, Integer o2) ->{
			if(ans[o2] - ans[o1] == 0) {
				return o1-o2;
			}
			return ans[o2] - ans[o1];
		};
		Arrays.sort(b, byAnotherArray);

		int m = getHotelSize(hotel_ids);
		int count[] = new int[m];
		for (int i = 0; i < m; i++) {
			count[i] = b[i];
		}
		return count;

	}

	private static int getHotelSize(int[] hotel_ids) {
		Set<Integer> hotelIds = new HashSet<>();
		for (int i = 0; i < hotel_ids.length; i++) {
			hotelIds.add(hotel_ids[i]);
		}
		return hotelIds.size();
	}

	static int countOccurences(String str, String word) {
		// split the string by spaces in a
		String a[] = str.split(" ");

		// search for pattern in a
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			// if match found increase count
			if (word.equals(a[i]))
				count++;
		}

		return count;
	}

	static int[] delta_encode(int[] array) {
		int n = array.length;
		if (n == 0)
			return new int[n];
		ArrayList<Integer> l = new ArrayList<>();
		l.add(array[0]);
		int diff = 0;
		for (int i = 1; i < n; i++) {
			diff = array[i] - array[i - 1];
			if (diff < -127 || diff > 127)
				l.add(-128);
			l.add(diff);
		}
		int ans[] = new int[l.size()];
		for (int i = 0; i < l.size(); i++) {
			ans[i] = l.get(i);
		}
		return ans;

	}

	static int howManyAgentsToAdd(int noOfCurrentAgents, int[][] callsTimes) {
		int m = callsTimes.length;

		int start[] = new int[m];
		int end[] = new int[m];

		for (int i = 0; i < m; i++) {
			start[i] = callsTimes[i][0];
			end[i] = callsTimes[i][1];
		}

		Arrays.sort(start);
		Arrays.sort(end);
		int p = 1;
		int r = 1;
		int i = 1, j = 0;
		while (i < m && j < m) {
			if (start[i] < end[j]) {
				p++;
				i++;
				r = Math.max(r, p);
			} else {
				p--;
				j++;
			}
		}
		int ans = r - noOfCurrentAgents;
		if (ans <= 0)
			return 0;
		return ans;

	}
}
