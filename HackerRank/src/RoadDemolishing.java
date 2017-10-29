import java.util.Scanner;

public class RoadDemolishing {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0) {
			long n = in.nextInt();
			long q = in.nextInt();
			long maxEdge=(q-2)*n*n;
			maxEdge/=(2*(q-1));
			long total = n*(n-1)/2;
			System.out.println(total-maxEdge);
		}
		in.close();

	}

}
