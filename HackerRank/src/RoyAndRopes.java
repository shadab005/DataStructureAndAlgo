import java.util.Scanner;

public class RoyAndRopes {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int finalAns = 0;
		while(t-->0) {
		   int L = in.nextInt();
		   int ans = solve(L, in);
		   finalAns = Math.max(finalAns, ans);
		   ans = solve(L, in);
		   finalAns = Math.max(finalAns, ans);
		   System.out.println(finalAns);
		   finalAns = 0;
		}
		in.close();
	}

	private static int solve(int L, Scanner in) {
		int ans  = L;
		int d = 0;
		int remaining = 0;
		for(int i=1;i<=L-1;i++) {
			remaining = L - i;
			d = in.nextInt();
			if(d>remaining)
				ans = Math.max(ans, i+d);
		}
		return ans;
	}

}
