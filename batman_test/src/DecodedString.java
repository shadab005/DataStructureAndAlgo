import java.util.Scanner;

public class DecodedString {

	
	//A-Z : 65-90
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0) {
			System.out.println(decode(in.nextInt()));
		}
		in.close();
	}
	
	public static String decode(int n) {
		int base = 26;
		String ans = "";
		int  r = 0;
		char c = 'A';
		while(n!=0) {
			r = (n-1)%base+65;
			c = (char)r;
			ans = c+ans;
			n = (n-1)/base;
		}
		return ans;
	}

}
