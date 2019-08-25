package javaconcepts.vmarg;

import java.util.ArrayList;
import java.util.List;

/*
 * This will print the default vm agr value set
 * java -XX:+PrintCommandLineFlags
 * 
 * To set the max heap memory and take the heap dump file on out of memory error
 * java -XX:+HeapDumpOnOutOfMemoryError -Xmx10m HeapDumpTest
 */
public class HeapDumpTest {

	public static void main(String[] args) {
		System.out.println("Hello from Test");
		List<String> l = new ArrayList<String>();
		for(int i=0;true;i++) {
		  l.add(new String("Test-"+i));	
		}

	}

}
