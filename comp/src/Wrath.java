import java.util.Scanner;

public class Wrath {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int l[] = new int[n];
		//System.out.println("\nn="+n);
		int total = 0;
		int killedTill=0;
		int x = 0;
		for(int i = 0 ;i<n;i++) {
			l[i]=in.nextInt();
		}
		int kill = 0;
		for(int i=0;i<n;i++) {
			x = l[n-i-1];
			if(x+i>=n) {
				x=n-i-1;
			}
			if(i+x > killedTill) {
				kill = x;
				if(killedTill>i) {
					kill=(i+x)-killedTill;
				}
				total+=kill;
				killedTill=i+x;
			}
			//System.out.println("i= "+i+ " x =  " + x + " total =" + total +" killedTill = " + killedTill);
		}
		System.out.println(n-total);
		in.close();
	}

}
