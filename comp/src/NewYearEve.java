import java.util.Scanner;

public class NewYearEve {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		if(n==1) {
			System.out.println(1);
			return;
		}
		long k = in.nextLong();
		if(k==1) {
			System.out.println(n);
			return;
		}
		long y = (long) (Math.floor(Math.log(n) / Math.log(2)));
		long z = 2 * (long) Math.pow(2, y) - 1;
		System.out.println(z);
		in.close();
	}

}
