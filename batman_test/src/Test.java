import java.util.Queue;
import java.util.LinkedList;;

public class Test {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		System.out.println(q.size());
		q.add(null);
		System.out.println(q.size());
		q.remove();
		System.out.println("ENd");
	}


}

