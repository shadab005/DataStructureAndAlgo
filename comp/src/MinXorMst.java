import java.util.Scanner;

public class MinXorMst {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long cost = 0;

		//algo 1 O(n)
		for(long i=1;i<n;i++) {
			cost+=(i^(i&(i-1)));
		}
		System.out.println(cost);
		
		//algo 2 O(logn)
		cost=0;
		long x = 0;
		for(long i=1;i<n;i=i*2) {
			x = Math.floorDiv(n-i-1, 2*i)+1;
			cost+=x*i;
		}
		System.out.println(cost);
		in.close();
	}

}
