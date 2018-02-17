import java.util.Scanner;

public class VisitingFriend {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int x,y=0;
		boolean ans = true;
		x = in.nextInt();
		y = in.nextInt();
		if(x!=0) ans = false;
		int maxReachable = y;
			
		for(int i = 1; i < n;i++) {
			x = in.nextInt();
			y = in.nextInt();
			if(maxReachable>=x) {
				maxReachable = Math.max(y, maxReachable);
			}
		}
		if(ans == false) {
			System.out.println("NO");
		}else if(maxReachable>=m) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		in.close();

	}

}
