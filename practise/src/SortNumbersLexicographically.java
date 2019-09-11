import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class SortNumbersLexicographically {

	private HashMap<Integer, String> dictionary = new HashMap<>();
	
	private String stringify(Integer n) {
		if(dictionary.get(n)!=null)return dictionary.get(n);
		String s = n+"";
		dictionary.put(n, s);
		return s;
	}
	
	private class LexicoComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			String s1 = stringify(o1);
			String s2 = stringify(o2);
			String s12 = s1+s2;
			String s21 = s2+s1;
			return s21.compareTo(s12);
		}
		
	}
	
	public String largestNumber(final List<Integer> A) {
		LexicoComparator c = new LexicoComparator();
		A.sort(c);
		//System.out.println(A);
		StringBuilder ans = new StringBuilder();
		for(Integer x: A) {
			ans.append(x);
		}
		
		return ans.toString().replaceFirst("^0+(?!$)", "");
    }
	
	public static void main(String[] args) {
		SortNumbersLexicographically s = new SortNumbersLexicographically();
		List<Integer> a = Arrays.asList(0,0,0,0);
		System.out.println(s.largestNumber(a));
		System.out.println("3".compareTo("30"));
		String.valueOf(6);
	}

}
