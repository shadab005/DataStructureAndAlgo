import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Factorization {
	
	static Set<Integer> set;
	static int count[];
	static int minPrime[];
	
	public static void main(String args[]){
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		minPrime = new int[1000001];
		calculateMinPrime(1000000);
		int a[] = new int[10];
		while(t-->0){
			set = new HashSet<>();
			count = new int[1000001];
			int n = in.nextInt();
			for(int i=0;i<n;i++){
				a[i] = in.nextInt();
				factorize(a[i]);
			}
			long answer = 1;
			for(Integer x : set){
				answer=answer*(count[x]+1);
			}
			System.out.println(answer);
		}
		in.close();

	}
	
	private static void calculateMinPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
		    if (minPrime[i] == 0) {         //If i is prime
		        for (int j = i * i; j <= n; j += i) {
		            if (minPrime[j] == 0) {
		                minPrime[j] = i;
		            }
		        }
		    }
		}
		for (int i = 2; i <= n; i++) {
		    if (minPrime[i] == 0) {
		        minPrime[i] = i;
		    }
		}
	}

	private static void factorize(int n) {
		while(n!=1){
			set.add(minPrime[n]);
			count[minPrime[n]]++;
			n=n/minPrime[n];
		}
	}
	
	
	
	

}
