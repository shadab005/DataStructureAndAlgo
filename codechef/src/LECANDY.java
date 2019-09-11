import java.util.Scanner;

class LECANDY {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int c = in.nextInt();
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += in.nextInt();
			}
			if (c >= sum) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
		in.close();

	}

}
