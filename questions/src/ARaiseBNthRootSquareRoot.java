
public class ARaiseBNthRootSquareRoot {

	static int power(int a, int b){
		int ans=1;
		while(b!=0){
			if(b%2==1){
				ans=ans*a;
			}
			a=a*a;
			b=b/2;
		}
		return ans;
	}
	static int powerRecursive(int a, int b){
		if(b==0)return 1;
		int x = powerRecursive(a, b/2);
		if(b%2==1){
			return a*x*x;
		}
		else{
			return x*x;
		}
	}
	
	static double squareRoot(int n){
		double low=0;
		double high=n;
		double mid=low+(high-low)/2;
		double diff = high;
		int count=0;
		while(Math.abs(diff)>0.000001){
			count++;
			mid=low+(high-low)/2;
			diff = mid*mid-n;
			if(diff>0){
				high=mid;
			}else{
				low=mid;
			}
		}
		System.out.println("Loop iteration count = " + count);
		return mid;
	}
	
	//newton method
	static float sqrt(int n) {
		float g1 = n / 2, g2 = 0, e = n / 2;
		int count=0;
		while (e > 0.00000001) {
			count++;
			g2 = (g1 + n / g1) / 2;
			e = Math.abs(g1 - g2); 
			g1 = g2;
		}
		System.out.println("Loop iteration count = " + count);
		return g1;

	}
	
	static double nthRoot(int a, int n){
		System.out.println("nth root divide n conquer");
		double low=1;
		double high=a;
		double mid=low+(high-low)/2;
		double diff = high;
		int count=0;
		while(Math.abs(diff)>0.00001){
			count++;
			mid=low+(high-low)/2;
			diff = Math.pow(mid, n)-a;
			if(diff>0){
				high=mid;
			}else{
				low=mid;
			}
		}
		System.out.println("Loop iteration count = " + count);
		return mid;
	}
	
	
	/*
	 * Newton Raphson:
	 *  X(n+1) = X(n)- f(X(n))/f'(X(n))
	 */
	static double nthRootNewtonRaphson(int a, int n){
		System.out.println("nth root newton raphson");
		double e = a/n;
		double g1=a/n;
		double g2=g1;
		int count=0;
		while(e>0.00001){
			count++;
			g2=((n-1)*g1+a/Math.pow(g1, n-1))/n;
			e=Math.abs(g2-g1);
			g1=g2;
		}
		System.out.println("Loop iteration count = " + count);
		return g1;
	}
	public static void main(String[] args) {
	/*	System.out.println(power(2,4));
		System.out.println(powerRecursive(2,10));
		System.out.println(squareRoot(10));
		System.out.println(squareRoot(100));
		System.out.println(squareRoot(90));*/
		/*System.out.println(squareRoot(1000));
		System.out.println(sqrt(1000));
		System.out.println(nthRoot(8, 3));*/
		System.out.println(nthRoot(Integer.MAX_VALUE, 7));
		System.out.println(nthRootNewtonRaphson(Integer.MAX_VALUE, 7));
		System.out.println("End of Program");

	}

}
