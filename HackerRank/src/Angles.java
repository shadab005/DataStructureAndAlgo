import java.util.HashSet;
import java.util.Scanner;

public class Angles {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int know[]=new int[n];
		for(int i=0;i<n;i++)know[i]=in.nextInt();
		int q[]=new int[k];
		for(int i=0;i<k;i++)q[i]=in.nextInt();
		HashSet<Integer> remainders = new HashSet<>();
		for(int i=0;i<n;i++) {
			remainders.addAll(getPossibleRemainders(know[i]));
		}
		boolean ans = false;
		for(int x: q) {
			ans = false;
			for(int rr:remainders) {
				if(rr!=0 && x%rr==0) {
					ans = true;
					break;
				}else if(rr==0) {
					if(x%360==0) {
						ans = true;
						break;
					}
				}
			}
			if(ans) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
		//System.out.println(remainders.size());
		in.close();

	}

	private static HashSet<Integer> getPossibleRemainders(int x) {
		HashSet<Integer> r = new HashSet<>();
		int y = x;
		while(!r.contains(y)) {
			r.add(y);
			y = (y + x)%360;
		}
		return r;
	}

}
