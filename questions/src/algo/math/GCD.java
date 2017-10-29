package algo.math;

/*
 * https://brilliant.org/wiki/extended-euclidean-algorithm/
 * https://brilliant.org/wiki/bezouts-identity/
 */
public class GCD {

	static int gcd(int a, int b) {
		if(b==0)return a;
		return gcd(b,a%b);
	}
	
	static int gcdIterative(int a, int b) {
		int r=0;
		while(b!=0) {
			r = a % b;
			a=b;
			b=r;
		}
		return a;
	}
	
	/*
	 * gcd(a,b)=ax+by
	 * extended algo helps in finding x and y for which above equation holds true
	 * 
	 * a=r0;
	 * b=r1;
	 * 
	 * Any remainder in finding gcd can be expressed in s*a+t*b form
	 * 
	 * r0=1*a+0*b ; s0=1,t0=0;
	 * s0=0*a+1*b ; s1=0,t1=1;
	 * 
	 * ri-2 = ri-1 * qi + ri
	 * 
	 * ri=si*a+ti*b
	 * from above
	 * ri=(si-2 - si-1*qi)a+(ti-2 - ti-1*qi)b
	 * Therefore, si= si-2 - si-1*qi and ti = ti-2 - ti-1*qi and qi = ri-2/ri-1
	 */
	static void extendedEuclideanAlgo(int a, int b) {
		int old_s=1, old_t=0;
		int s=0,t=1;
		int old_r = a, r=b;
		int q=0;
		int temp =0 ;
		while(r!=0) {
			q = old_r/r;
			
			temp = s;
			s=old_s-s*q;
			old_s = temp;
			
			temp = t;
			t = old_t-t*q;
			old_t = temp;
			
			temp = r;
			r = old_r-r*q;
			old_r = temp;
		}
		
		System.out.println("GCD of two numbers : " + old_r);
		System.out.println("x and y = " + old_s +" and " + old_t);
		System.out.println("Equation");
		System.out.println(a+"*"+old_s+"+"+b+"*"+old_t+"="+old_r);
	}
	
	public static void main(String[] args) {
		/*System.out.println(gcdIterative(455, 1547));
		System.out.println(gcdIterative(1547, 455));
		System.out.println(gcd(455, 1547));*/

		System.out.println(gcd(1914, 899));
		extendedEuclideanAlgo(15,26);
		System.out.println();

	}

}
