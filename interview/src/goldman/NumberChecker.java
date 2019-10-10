package goldman;

import java.util.Arrays;
import java.util.List;

public class NumberChecker {

	public static void main(String[] args) {
		int a[] = new int[] {123,123,-123};
		System.out.println(findQualifiedNumbers(a));

	}
	
	static String findQualifiedNumbers(int[] a) {
		List<Integer> ans = Arrays.stream(a).filter(NumberChecker::containsAll).boxed().collect(java.util.stream.Collectors.toList());
		String z = ans.stream().sorted().map(String::valueOf).collect(java.util.stream.Collectors.joining(","));
		if(z.isEmpty()) return "-1";
		return z;
	}

	private static boolean containsAll(int x) {
		String s = String.valueOf(x);
		return s.contains("1") && s.contains("2") && s.contains("3");
	}

}
