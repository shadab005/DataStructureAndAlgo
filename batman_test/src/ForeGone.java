import java.util.Scanner;

public class ForeGone {

	static long answer = 0;
	public static void main(String[] args) {
		
		/*for(int i =0; i<1000000;i++) {
			if(i%2==0)System.out.print("S");
			else System.out.print("E");
		}
		System.out.println();*/
		int x = 65;
		char ch = (char) x;
		
	}
	
	
	private static String solve(int caseNumber, Scanner in) {
		long start = System.nanoTime();
		in.nextInt();
		String y = in.next();
		String z = y.replaceAll("S", "Z");
		z = z.replaceAll("E", "S");
		z = z.replaceAll("Z", "E");
		long end = System.nanoTime();
		answer = (end-start)/1000000;
		System.out.println("zzzzzTime = " + answer);
		return z;
	}

	/*private static void solve1(int caseNumber, String n) {
		
		String a = new String(n);
		String b = new String(n);
		b = b.replaceAll(".", "0");
		
		char[] a1 = a.toCharArray();
		char[] b1 = b.toCharArray();
		for (int i = 0; i < a1.length; i++) {
			if(a1[i]=='4') {
				a1[i]='2';
				b1[i]='2';
			}
		}
		String A = String.copyValueOf(a1);
		String B = String.copyValueOf(b1);
		System.out.println("Case #"+caseNumber+": "+A+" "+B);
	}*/

}
