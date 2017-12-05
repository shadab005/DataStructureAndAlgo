import java.util.Scanner;

public class Greed {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long remaing = 0;
		for(int i = 0; i<n;i++) {
			remaing+=in.nextInt();
		}
		//System.out.println("\nremaining="+remaing);
		int fMax = 0, sMax = 0;
		int temp = 0;
		fMax = in.nextInt();
		sMax = in.nextInt();
		if(sMax>fMax) {
			temp = sMax;
			sMax = fMax;
			fMax= temp;
		}
		for(int i=2;i<n;i++) {
			temp = in.nextInt();
			if(fMax<=temp) {
				sMax = fMax;
				fMax = temp;
			}else if(sMax<temp) {
				sMax=temp;
			}
		}
		//System.out.println(fMax+1L+sMax);
		if(fMax+0L+sMax>=remaing) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		in.close();

	}

}
