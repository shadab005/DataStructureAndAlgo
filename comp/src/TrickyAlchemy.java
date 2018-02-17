import java.util.Scanner;

public class TrickyAlchemy {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		
		int x = in.nextInt();
		int y = in.nextInt();
		int z = in.nextInt();
		
		long requiredYellow = 2*1L*x + 1L*y;
		long requiredBlue = 3 * 1L * z + 1L*y;
		
		long ans = 0 ; 
		if(A <  requiredYellow) {
			ans=(requiredYellow - A);
		}
		if(B < requiredBlue) {
			ans+=(requiredBlue - B);
		}
		System.out.println(ans);
		in.close();

	}

}
