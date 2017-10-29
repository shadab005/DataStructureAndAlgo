import java.util.Arrays;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		   int t = in.nextInt();
		   String[] start = new String[t];
		   String[] end = new String[t];
		   for(int i=0; i<t;i++) {
		       start[i] = in.next();//inp.substring(0, inp.indexOf(" ")-1);
		       end[i] = in.next();//inp.substring(inp.indexOf(" ")+1);
		   }
		   
		   
		   System.out.println("^^^^Start array");
		   for(int i=0;i<start.length;i++)
		       System.out.print(start[i]+ " ");
		   System.out.println("^^^^End array");
		   for(int i=0;i<end.length;i++)
		       System.out.print(end[i]+ " ");
		   
		   
		   
		
	}
	
	public static void sort1(String[] arr) {
	       Arrays.sort(arr);
	       for(int i=0;i<arr.length;i++)
	           System.out.println(arr[i]);
	   }

}
