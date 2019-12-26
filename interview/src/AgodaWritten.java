import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AgodaWritten {
	
	static Map<String, Integer> monthToId;

    static class DateComparator implements Comparator<String> {
        public int compare(String u, String v) {
            String[] split1 = u.split(" ");
            String[] split2 = v.split(" ");
            int c = split1[2].compareTo(split2[2]);
            if (c != 0) return c;
            c = monthToId.get(split1[1]).compareTo(monthToId.get(split2[1]));
            if (c != 0) return c;
            return split1[0].compareTo(split2[0]);
        }
    }


    public static List<String> sortDates(List<String> dates) {
        monthToId = new HashMap<>();
        List<String> month = new ArrayList<>(Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));
        for (int i = 0; i < month.size(); i++) {
            monthToId.put(month.get(i), i);
        }
        Collections.sort(dates, new DateComparator());
        return dates;
    }

	
	
	public static String reverseWords(String inputWords) {

		if(inputWords == null || inputWords.isEmpty()) return inputWords;
		
		String w[] = inputWords.split(" ");
		if(w.length == 1) return w[0];
		StringBuilder sb = new StringBuilder("");
		for(int i = w.length-1; i>=0;i--) {
			sb.append(w[i]);
			sb.append(" ");
		}
		return sb.toString().trim();
    }
	
	
	public static List<Integer> getFirstTwoItemsWithoutPair(List<Integer> list) {
		List<Integer> ans = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for(int x:list) {
			if(map.containsKey(x)) {
				map.put(x, map.get(x)+1); 
			}else {
				map.put(x, 1);
			}
		}
		int count = 0 ;
		for(int x:list) {
			if(map.get(x)==1) {
				count++;
				ans.add(x);
				if(count==2)break;
			}
		}
		return ans;

    }


}
