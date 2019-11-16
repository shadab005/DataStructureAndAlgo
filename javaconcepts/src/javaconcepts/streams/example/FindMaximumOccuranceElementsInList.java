package javaconcepts.streams.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindMaximumOccuranceElementsInList {

	public static void main(String[] args) {
		List<String> s = Arrays.asList("adam", "tom", "jeine", "tom", "adam");
		Map<String, Long> countKeyCountMap = 
				s.stream()
				.collect(Collectors
						.groupingBy(Function.identity(),
						            TreeMap::new, 
								    Collectors.counting()));
		
		

	}

}
