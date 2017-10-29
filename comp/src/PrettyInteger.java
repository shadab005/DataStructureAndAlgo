import java.util.Scanner;

public class PrettyInteger {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int min1 = 100;
		for(int i=0;i<n;i++) {
			int x = in.nextInt();
			if(x<min1)min1=x;
		}
				
		int min2 = 100;
		for(int i=0;i<m;i++) {
			int x = in.nextInt();
			if(x<min2)min2=x;
		}
		
		
		if(min1==min2) {
			System.out.println(min1);
		}
		else {
			System.out.println(Math.min(10*min1+min2, 10*min2+min1));
		}
		in.close();

	}

}
