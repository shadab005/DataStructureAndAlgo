package datastructure.array;

/*
 * By definition : fibo(n) = fib(n-1)+fib(n-2)
 * 
 * Let the series be: 1 2 3 5 8 13 21 34 55 89... 
 * Formula: 
 * k=n/2
 * F(n)=F(k)*F(k)+F(k-1)f(k-1), if n is even
 *      F(k+1)*F(k+1)-F(k-1)F(k-1), if n is odd //Can be simplified to
 *      										 F(k)*F(k)+2*F(k)F(k-1) 
 *      									or   2*F(k+1)*F(k)-F(k)*F(k)
 *      
 * Note we have assumed the fibo series to start from 1,2..
 * If it starts from 0,1 or 1,1 you have to adjust the index accordingly
 * 
 */
public class Fibonacci {

	static long f[];

	public static void main(String[] args) {
		long fib[] =  new long[2];
		fib[0]=1;
		fib[1]=1;
		fastFibo(1, fib);
		System.out.println(fib[0]);
		//System.out.println(getFibo(9));

	}

	private static void fastFibo(int n, long[] fib) {
		if(n==0 || n==1){
			fib[0]=1;
			fib[1]=1;
		}else{
			fastFibo(n/2, fib);
			long a = fib[0];
			long b = fib[1];
			if(n%2==0){
				fib[0]=a*a+b*b;    //f(n)=f(k)*f(k)-f(k-1)*f(k-1),    k = n/2
				fib[1]=2*a*b-b*b;  //f(n-1)=2*f(k+1)*f(k)-f(k)*f(k) , k = (n-1)/2
			}else{
				fib[0]=a*a+2*a*b; //f(n)=f(k)*f(k)+2*f(k)*f(k-1),     k = n/2
				fib[1]=a*a+b*b;   //f(n) = f(k)*f(k)+f(k-1)*f(k-1)
			}
		}
		
	}

	static long getFibo(int n){
		f = new long[100];
		f[0]=1;
		f[1]=1;
		f[2]=2;
		return fibo(n);
	}
	private static long fibo(int n) {
		//System.out.println("Calling fibo for n = " + n);
		if(n<=2)return f[n];
		if(f[n]!=0){
			return f[n];
		}
		int k = n/2;
		if((n&1)==1){ //odd
			/*long a = fibo(k+1);
			long b = fibo(k-1);
			f[n]=a*a-b*b;*/
			long a = fibo(k);
			long b = fibo(k-1);
			f[n]=a*a+2*a*b;
		}else{
			long a = fibo(k);
			long b = fibo(k-1);
			f[n]=a*a+b*b;
		}
		return f[n];
	}

}
