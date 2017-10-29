import java.util.Scanner;

public class MaxSplit {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q=in.nextInt();
		while(q-->0) {
			solve(in.nextInt());
		}
		in.close();

	}

	public static void solve(int x) {
		if(x<4)System.out.println(-1);
		else if((x&1)==0) {//even number
		 	System.out.println(x/4);
		}else {
			int z = x-9;
			if(z==0)System.out.println(1);
			else if(z<4)System.out.println(-1);
			else {
				System.out.println(1+z/4);
			}
		}
	}

}
