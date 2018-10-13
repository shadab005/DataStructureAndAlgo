package algo.math;

import java.util.ArrayList;

class PrimeNumberProblem {

	//Seive of Eratosthenes
	/*
	 * Order  : n*log(logn)
	 */
	static void generateAllPrimeUptoN(int n){
		Boolean isPrime[]=new Boolean[n+1];
		for(int i=2;i<=n;i++)isPrime[i]=true;
		for(int i=2;i<=n;i++){
			if(isPrime[i]==true){
				for(int j=i*i;j<=n;j=j+i){
					isPrime[j]=false;
				}
			}
		}
		for(int i=2;i<=n;i++){
			if(isPrime[i]){
				System.out.println(i);
			}
		}
	}
	
	//Sieve on segment
	static void generateAllPrimeInRange(long l,long r){
		int range = (int) (r-l)+1;
		boolean isPrime[] = new boolean[range];
		for(int i = 0 ; i < r-l+1 ; i++)isPrime[i]=true;
		for(long i = 2 ; i*i <= r ; i++){
			//System.out.println("i="+i);
			for(long j = Math.max(i*i, (l+i-1)/i * i) ; j <= r ; j=j+i){
				//System.out.println("j="+j);
				if(isPrime[(int) (j-l)]){
					isPrime[(int) (j-l)] = false;
				}
			}
		}
		if(l==1)isPrime[0]=false;
		for(int i = 0 ; i<range;i++){
			//System.out.println("range="+range);
			if(isPrime[i]){
				System.out.println(i+l);
			}
		}
	}
	
	/*
	 * O(sqrt(n))
	 */
	static void generatePrimeFactors(int n){
		ArrayList<Integer> a = new ArrayList<>();
	    for(int i= 2;i*i<=n;i++){
	    	while(n%i==0){
	    		n=n/i;
	    		a.add(i);
	    	}
	    }
	    if (n != 1) {
	    	a.add(n);
	    }
	    a.forEach((i)->System.out.println(i + " "));
	}
	public static void main(String[] args) {
		//generateAllPrimeUptoN(10);
		generatePrimeFactors(20);
		//generateAllPrimeInRange(11, 13);
		/*Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i = 1 ; i<= t; i++){
			long l = in.nextLong();
			long r = in.nextLong();
			generateAllPrimeInRange(l, r);
			System.out.println();
		}
		in.close();*/
	}
}
