import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class WackyWorkout {

	static int mod = 1000000007;
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		while (t-- > 0) {
			long n = in.nextLong();
			System.out.println(getFibo(n+1));
		}
		in.close();
	}
	
	static int getFibo(long n){
		int fib[] =  new int[2];
		fib[0]=1;
		fib[1]=1;
		fastFibo(n, fib);
		return fib[0];
	}
	
	private static void fastFibo(long n, int[] fib) {
		if(n==0 || n==1){
			fib[0]=1;
			fib[1]=1;
		}else{
			fastFibo(n/2, fib);
			int a = fib[0];
			int b = fib[1];
			if(n%2==0){
				fib[0]=(int) (((a*1L*a)%mod+(b*1L*b)%mod)%mod);    //f(n)=f(k)*f(k)-f(k-1)*f(k-1),    k = n/2
				fib[1]=(int) (((2*1L*a*b)%mod-(b*1L*b)%mod+mod)%mod);  //f(n-1)=2*f(k+1)*f(k)-f(k)*f(k) , k = (n-1)/2
			}else{
				fib[0]=(int) (((a*1L*a)%mod+(2*1L*a*b)%mod)%mod); //f(n)=f(k)*f(k)+2*f(k)*f(k-1),     k = n/2
				fib[1]=(int) ((a*1L*a)%mod+(b*1L*b)%mod)%mod;   //f(n) = f(k)*f(k)+f(k-1)*f(k-1)
			}
		}
		
	}
	
	
}

