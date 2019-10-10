package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _49_GroupAnagrams {

	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));

	}
	
	static public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>>  ans = new ArrayList<>();
		Map<String, List<String>> groupBySortedString = Arrays.stream(strs).collect(Collectors.groupingBy(s->sortedString(s)));
		for(List<String> val : groupBySortedString.values()) {
			ans.add(val);
		}
		return ans;
    }
	
	private static String sortedString(String s) {
		char a[] = s.toCharArray();
		countSort(a);
		return new String(a);
	}
	
	static void countSort(char a[]){
    	int n = a.length;
    	char count[] = new char[26]; //256 characters
    	for(int i=0;i<n;i++)count[a[i]-'a']++;
    	for(int i=1;i<26;i++)count[i]+=count[i-1];
    	
    	char[] output = new char[n];
    	for(int i=0;i<n;i++){
    		output[count[a[i]-'a']-1] = a[i];
    		count[a[i]-'a']--;
    	}
    	for(int i=0;i<n;i++)a[i]=output[i];
    }

}
