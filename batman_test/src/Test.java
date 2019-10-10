import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		List<String> s = null;
		for(String ss : s) {
			
		}
		
	}

	private static List<String> get(Set<A> a) {
		return a.stream().map(x->x.s).collect(Collectors.toList());
	}	
}
 class A {
	 String s;
	 A(String x) {
		 s=x;
	 }
}
