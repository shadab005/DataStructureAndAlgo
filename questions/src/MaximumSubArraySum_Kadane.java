
public class MaximumSubArraySum_Kadane {
	
	/*Kadane’s Algorithm*/
	static int getMaxSubArraySum(int a[]) {
		int size = a.length;
		int maxSum = Integer.MIN_VALUE, sum = 0;

		for (int i = 0; i < size; i++) {
			sum = sum + a[i];
			if (maxSum < sum)
				maxSum = sum;
			if (sum < 0)
				sum = 0;
		}
		return maxSum;
	}
	
	static int maxSubArraySum(int a[]) {
		int max_so_far = a[0];
		int curr_max = a[0];

		for (int i = 1; i < a.length; i++) {
			curr_max = Math.max(a[i], curr_max + a[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;
	}
	
	
	static int dpMaxSubArraySum(int a[]){
		int size = a.length;
		int dp[] =  new int[size];
		dp[0] = a[0];
		int sum = 0;
		for(int i = 1; i < size; i++){
			sum = Math.max(a[i], a[i]+sum);
			dp[i] = Math.max(dp[i-1], sum);
			
		}
		return dp[size-1];
	}
	
	public static void main(String[] args) {
		
		int [] a = {-2, 11, -4, 13, -5, 2};
		System.out.println("Max Sum : " + maxSubArraySum(a));
		System.out.println("Max Sum : " + dpMaxSubArraySum(a));
	}

}
