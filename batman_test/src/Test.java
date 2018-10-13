import java.util.stream.IntStream;

public class Test {

	public static void main(String[] args) {


		
	    IntStream i2 = IntStream.range(1, 5);
	    i2.forEach(System.out::println);
	    
	    System.out.println("Next");
	    IntStream i1 = IntStream.rangeClosed(1, 5);
	    i1.forEach(System.out::println);
	    
	    System.out.println(Boolean.valueOf((String) null));

	}

}