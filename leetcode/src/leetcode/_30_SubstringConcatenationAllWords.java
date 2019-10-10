package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _30_SubstringConcatenationAllWords {

	public static void main(String[] args) {
		String s = "barfoofoobarthefoobarman";
		String[] words = new String[] { "bar", "foo", "the" };
		System.out.println(findSubstring(s, words));

	}

	static public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> ans = new ArrayList<>();
		if (words.length == 0 || s.isEmpty())
			return ans;
		int size = words[0].length();
		int totalWords = words.length;
		String sortedJoinedWords = stringInSortedChars(words);
		for (int i = 0; i < size; i++) {
			// System.out.println("Processing for i = " + i);
			int k = i;
			int j = i + totalWords * size - 1;
			if (j >= s.length())
				return ans;
			// System.out.println("Here");
			while (j < s.length()) {
				// System.out.println("Processing i = " + i + " j = " + j);
				// process all words in interval between i and j
				if (allWordsExistInInterval(i, j, s, sortedJoinedWords, size, totalWords))
					ans.add(i);
				i = i + size;
				j = i + totalWords * size - 1;
			}
			i = k;
		}
		return ans;
	}

	private static String stringInSortedChars(String words[]) {
		return Arrays.stream(words).sorted().collect(Collectors.joining());
	}

	private static String[] splitStringByLength(String s, int length) {
		return s.split("(?<=\\G.{" + length + "})");
	}

	private static boolean allWordsExistInInterval(int i, int j, String s, String sortedJoinedWords, int size,
			int totalWords) {
		// System.out.println("allWordsExistInInterval i = " + i + " j = " + j + " s = "
		// + s.substring(i, j+1) + " sortesJoined = " + sortedJoinedWords);
		/*
		 * String[] words = new String[totalWords]; for(int k = 0; k < totalWords; k++)
		 * { words[k] = s.substring(i, i+size); //System.out.println("Words["+k+"] = " +
		 * words[k]); i = i+size; }
		 */
		String words[] = splitStringByLength(s.substring(i, j + 1), size);
		// System.out.println();
		return stringInSortedChars(words).equals(sortedJoinedWords);
		// return stringInSortedChars(s.substring(i, j+1)).equals(sortedJoinedWords);
	}

}
