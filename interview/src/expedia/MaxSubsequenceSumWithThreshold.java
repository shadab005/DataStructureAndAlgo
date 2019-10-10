package expedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MaxSubsequenceSumWithThreshold {

	public static void main(String[] args) {
		
		List<Long> arr = new ArrayList<>(Arrays.asList(1l, 3l, 5l));//,4l,5l,6l,7l,8l));
		 System.out.println(maxSum(arr, 2)); //result 1

	}

	public static long maxSum(List<Long> arr, long threshold) {
		Long[] a = arr.stream().toArray(Long[]::new);
		return isSubSetSum(a, threshold);
	}

	private static long isSubSetSum(Long a[], long k) {
		int n = a.length;
		HashMap<Long, HashSet<Integer>> sumPossibleMap = new HashMap<>();
		for (int i = 0; i <= n; i++) {
			HashSet<Integer> indexes =  sumPossibleMap.getOrDefault(0l, new HashSet<>());
			indexes.add(i);
			sumPossibleMap.put(0l, indexes);
		}

		//System.out.println(sumPossibleMap);
		for (long i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				
				if (a[j - 1] > i) {
					HashSet<Integer> indexes = sumPossibleMap.getOrDefault(i, new HashSet<>());
					if(indexes.contains(j-1)) {
					     indexes.add(j);
					}
					sumPossibleMap.put(i, indexes);
				}
				else {
					HashSet<Integer> indexes = sumPossibleMap.getOrDefault(i, new HashSet<>());
					HashSet<Integer> indexesOther = sumPossibleMap.getOrDefault(i-a[j-1], new HashSet<>());

					if(indexes.contains(j-1) || indexesOther.contains(j-1)) {
						indexes.add(j);
					}
					sumPossibleMap.put(i, indexes);
				}
			}
		}
		long answer = 0;
		for(long sum = k ; sum >=0 ;sum--) {
			if(sumPossibleMap.getOrDefault(sum, new HashSet<>()).size() > 0) return sum;
		}
		return answer;
	}
}
