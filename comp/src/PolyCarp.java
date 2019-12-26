import java.util.Scanner;

public class PolyCarp {

	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0) {
			System.out.println(solve(in.nextInt()));
		}
		in.close();
	}
	
	
	static public int solve(int n) {
		if(n==0) return 0;
		//find number of digirs
		
		int x = n;
		int numOfDigit = 0;
		int lastDigit = 0;
		while(x!=0) {
			lastDigit = x;
			x = x/10;
			numOfDigit++;
		}
		int ans = 0;
		//integer construct of numOfDigits with digit lastDigit
		int y = 0;
		for(int i = 0 ; i < numOfDigit;i++) {
			y=y*10+lastDigit;
		}
		if(y<=n) ans++;
		ans += (numOfDigit-1)*9+ lastDigit-1;
		return ans;
	}

}
