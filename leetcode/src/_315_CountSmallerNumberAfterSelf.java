import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class _315_CountSmallerNumberAfterSelf {
	
	//[5,2,6,2]

	public static void main(String[] args) {
		System.out.println(countSmaller(new int[] {5,2,6,2}));
	}

	static public List<Integer> countSmaller(int[] a) {
		int n = a.length;
		if(n==1)return Arrays.asList(0);
		int b[] = new int[n];
		
		TreeSet<Integer> set = new TreeSet<>();
		for(int i = n-1; i>=0;i--) {
			Integer x = set.headSet(a[i]).size();
			b[i] = x;
			set.add(a[i]);
		}
		return Arrays.stream(b).boxed().collect(Collectors.toList());
	}
}
