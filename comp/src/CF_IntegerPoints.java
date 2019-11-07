import java.util.Scanner;

public class CF_IntegerPoints {

	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		int t = in.nextInt();
		int x = 0;
		while(t-->0) {
			int n = in.nextInt();
			long nEvenCount = 0;
			long nOddCount = 0;
			for(int i=0; i< n ; i++) {
				x = in.nextInt();
				if(x%2==0)nEvenCount++;
				else nOddCount++;
			}
			
			int m = in.nextInt();
			long mEvenCount = 0;
			long mOddCount = 0;
			for(int i =0 ;i < m ;i++) {
				x = in.nextInt();
				if(x%2==0)mEvenCount++;
				else mOddCount++;
			}
			System.out.println(nEvenCount*mEvenCount+nOddCount*mOddCount);
		}
		in.close();
	}

}
