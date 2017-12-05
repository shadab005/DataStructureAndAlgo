import java.util.Stack;

public final class Pride {

	public static void main(String[] args) {
		System.out.println("Hi Pride");
		for(int x : fun()) {
			System.out.println(x);
		}

	}
	
	
	public static Iterable<Integer> fun(){
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		return s;
	}

}
