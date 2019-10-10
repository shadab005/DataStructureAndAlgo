package javaconcepts.streams.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectExample {

	public static void main(String[] args) {
		test1();
		testAveraging();

	}

	static void test1() {
		List<String> names = Arrays.asList("Jon", "Ajeet", "Steve", "Ajeet", "Jon", "Ajeet", "abcdefghi");
		Map<String, Long> map = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
	}
	
	static void testConversionToAnotherCollection() {
		List<String> names = Arrays.asList("Jon", "Ajeet", "Steve", "Ajeet", "Jon", "Ajeet");
		 Set<String> nameSet = names.stream().filter(s -> s.length()<7).collect(Collectors.toSet());
		 System.out.println(nameSet);
	}
	
	static void testAveraging() {
		//Calculate average lenght of names
		List<String> names = Arrays.asList("Jon", "Ajeet", "Steve", "Ajeet", "Jon", "Ajeet", "abcdefghi");
		Double avgLen = names.stream().collect(Collectors.averagingInt(s->s.length()));
		System.out.println(avgLen);
	}
	
	static void testSupplierAccumulatorCollector() {
		
	}

}