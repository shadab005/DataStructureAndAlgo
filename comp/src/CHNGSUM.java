import java.util.Scanner;
import java.util.Stack;

/*
 * Summationi=1 to N−1 : maxSum[i]∗(cumMinSum[i+1])
 * maxSum[i]  denote the sum of maximum 
 * element of all subarrays ending at index i
 * 
 * 
 * minSum[i]minSum[i] denote the sum of 
 * minimum element of all subarrays starting from index i.
 * 
 */
class CHNGSUM {

	static int mod = 1000000007;
	static long[] maxSum(int a[], int n){
		long[] maxSum = new long[n];
		Stack<Integer> s = new Stack<>();
		for(int i = 0 ; i<n ;i++){
			int idx = -1;
			while(!s.isEmpty()){
				if(a[s.peek()]<=a[i])s.pop();
				else{
					idx = s.peek();
					break;
				}
			}
			s.push(i);
			maxSum[i] = (((idx>=0)?maxSum[idx]:0)+(i-idx)*1L*a[i])%mod;
		}
		return maxSum;
	}
	
	static long[] minSum(int a[], int n){
		long[] minSum = new long[n];
		Stack<Integer> s = new Stack<>();
		for(int i = n-1; i>=0 ;i--){
			int idx = n;
			while(!s.isEmpty()){
				if(a[s.peek()] >= a[i])s.pop();
				else{
					idx = s.peek();
					break;
				}
			}
			s.push(i);
			minSum[i] = (((idx<n)?minSum[idx]:0)+(idx-i)*1L*a[i])%mod;
		}
		return minSum;
	}
	
	static long[] cumulativeSum(long minSum[], int n){
		long[] cumulativeSum = new long[n];
		cumulativeSum[n-1]=minSum[n-1];
		for(int i=n-2;i>=0;i--){
			cumulativeSum[i]=(cumulativeSum[i+1]+minSum[i])%mod;
		}
		return cumulativeSum;
	}
	private static void solve(int[] a, int n) {
		long[] maxSum = maxSum(a, n);
		long[] minSum = minSum(a, n);
		long[] cumulativeSum = cumulativeSum(minSum, n); 
		long ans=0;
		for(int i=0;i<n-1;i++){
			ans+=(maxSum[i]*cumulativeSum[i+1])%mod;
		}
		System.out.println(ans%mod);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++){
			a[i]=in.nextInt();
		}
		solve(a,n);
		in.close();

	}

	
	

}

