package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


public class _819_MostCommonWord {

	public static void main(String[] args) {
		String paragraph = "a, a, a, a, b,b,b,c, c";
		String banned[] = {"a"};
		System.out.println(mostCommonWord(paragraph, banned));

	}
	
	static  public String mostCommonWord(String paragraph, String[] banned) {
		Set<String> bannedSet = Arrays.stream(banned).collect(Collectors.toSet());
		return Arrays.stream(paragraph.split("\\.|\\,|;|!|\\?|'|\\s")).map(s->s.toLowerCase())
		.filter(s->(!bannedSet.contains(s) && !s.equals("")))
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream()
		.max(Map.Entry.comparingByValue())
		.get().getKey();
    }

}
