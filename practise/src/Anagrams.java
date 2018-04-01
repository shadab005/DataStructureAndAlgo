import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

	//indexing from 1
	//https://www.interviewbit.com/problems/anagrams/
	public static ArrayList<ArrayList<Integer>> groupAnagrams(final List<String> a) {
		Map<String, ArrayList<Integer>> map = new LinkedHashMap<>();
		for(int i=0;i<a.size();i++) {
			String sortedString  = sortString(a.get(i));
			if(map.get(sortedString)==null) {
				ArrayList<Integer> l  = new ArrayList<>();
				l.add(i+1);
				map.put(sortedString, l);
			}else {
				map.get(sortedString).add(i+1);
			}
		}
		//printMap(map);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(ArrayList<Integer> z: map.values()) {
			ans.add(z);
		}
		return ans;
    }

	public static String sortString(String inputString)
    {
        // convert input string to char array
        char tempArray[] = inputString.toCharArray();
         
        // sort tempArray
        Arrays.sort(tempArray);
         
        // return new sorted string
        return new String(tempArray);
    }
	
	public static void main(String[] args) {
		//cat dog god tca
		List<String> l = new ArrayList<>();
		l.add("cat");
		l.add("dog");
		l.add("god");
		l.add("tca");
		groupAnagrams(l);

	}

}
