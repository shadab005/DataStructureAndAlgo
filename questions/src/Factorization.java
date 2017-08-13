import java.util.HashSet;
import java.util.Set;

public class Factorization {

	public static void main(String[] args) {
		int a[] = new int[1000000];
		System.out.println(a.length);
		factorize(96);
		System.out.println();
		doFacorize(96);

	}
	
	/*
	 * O(sqrt(N))
	 */
	static void factorize(int n){
		Set<Integer> s = new HashSet<>();
		int count[] = new int[n+1];
		for(int i=2;i*i<n;i++){
			while(n%i==0){
				s.add(i);
				count[i]++;
				n=n/i;
			}
		}
		if(n!=1){
			s.add(n);
			count[n]++;
		}
		for(Integer x : s){
			System.out.println(x + "^" + count[x]);
		}
	}
	
	static void doFacorize(int n){
		//Preprocessing to calculate minimum prime by constructing 
		// minPrime array where minPrime[x] will contain minimum prime that divides x
		int minPrime[] = new int[n+1];
		for (int i = 2; i * i <= n; ++i) {
		    if (minPrime[i] == 0) {         //If i is prime
		        for (int j = i * i; j <= n; j += i) {
		            if (minPrime[j] == 0) {
		                minPrime[j] = i;
		            }
		        }
		    }
		}
		for (int i = 2; i <= n; ++i) {
		    if (minPrime[i] == 0) {
		        minPrime[i] = i;
		    }
		}
		
		factorize(n, minPrime);
	}

	private static void factorize(int n, int[] minPrime) {
		
		Set<Integer> s = new HashSet<>();
		int count[] = new int[n+1];
		while(n!=1){
			s.add(minPrime[n]);
			count[minPrime[n]]++;
			n=n/minPrime[n];
		}
		for(Integer x : s){
			System.out.println(x + "^" + count[x]);
		}
	}
	
	

}
