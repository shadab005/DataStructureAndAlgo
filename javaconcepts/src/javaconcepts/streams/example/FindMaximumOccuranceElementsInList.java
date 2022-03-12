package javaconcepts.streams.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindMaximumOccuranceElementsInList {

	public static void main(String[] args) {

		  test1();
		  test2();

	}

	static void test1() {
		List<String> s = Arrays.asList("adam", "tom", "jeine", "tom", "adam", "tom");
		String maxFrequencyString =
				s.stream()
		        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		         .entrySet().stream()
		         .max((e1,e2)->Long.compare(e1.getValue(), e2.getValue())).get().getKey();
		System.out.println(maxFrequencyString);
	}

	static void test2() {
		List<String> s = Arrays.asList("adam", "tom", "jeine", "tom", "adam", "tom");
		String maxFrequencyString =
				s.stream()
		        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		         .entrySet().stream()
		         .max(Map.Entry.comparingByValue()).get().getKey();
		System.out.println(maxFrequencyString);
	}

}
