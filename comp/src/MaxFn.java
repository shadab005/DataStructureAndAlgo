public class MaxFn {

	static long getMax(int a[], int n){
	    int e[] = new int[n-1];
	    int sign=-1;
	    for(int i=0;i<n-1;i++){
	    	e[i]=Math.abs(a[i]-a[i+1])*sign;
	    	sign=sign*-1;
	    }
	    long sum=maxSubArraySum(e);
	    for(int i = 0; i< n-1; i++){
	    	e[i]=e[i]*-1;
	    }
		long sum2=maxSubArraySum(e);
		return (sum>sum2)?sum:sum2;
	}
	
	static long maxSubArraySum(int a[]) {
		long max_so_far = a[0];
		long curr_max = a[0];

		for (int i = 1; i < a.length; i++) {
			curr_max = Math.max(a[i], curr_max + a[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;
	}
	
	public static void main(String[] args) {
		//int b[]={1,4,2,3,1};
		int a[] = {1, 5, 4, 7};/*
		System.out.println(getMax(a, a.length));
		System.out.println(getMax(b, b.length));*/
		/*Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		sc.close();*/
		long lmax=Math.abs(a[0]-a[1]);
		int sign=-1;
		long rmax=sign*lmax;
		long lmaxsofar=lmax;
		long rmaxsofar=sign*rmax;
		for(int i = 1 ; i < a.length-1; i++){
			lmax=Math.max(Math.abs(a[i]-a[i+1])*sign, lmax+Math.abs(a[i]-a[i+1])*sign);
			lmaxsofar=Math.max(lmaxsofar, lmax);
			rmax=Math.max(Math.abs(a[i]-a[i+1])*sign*-1, rmax+Math.abs(a[i]-a[i+1])*sign*-1);
			rmaxsofar=Math.max(rmaxsofar, rmax);
			sign=sign*-1;
		}
		System.out.println(Math.max(lmaxsofar, rmaxsofar));
	}

}
