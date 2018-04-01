package algo.dynamicprogramming;

public class DPMaximumSumWithNoAdjacent {

    static int[]dp;	
    //Recursive dp solution
	static int findMaxSumNoAdjacent(int a[], int i, int n){
		if(i>=n) return 0;
		int x = Math.max(a[i]+(((i+2)< n && dp[i+2]!=-1)?dp[i+2]:findMaxSumNoAdjacent(a, i+2, n)),
				a[i]+(((i+3)< n && dp[i+3]!=-1)?dp[i+3]:findMaxSumNoAdjacent(a, i+3, n)));
		if(dp[i] < x) dp[i] = x;
		return dp[i];
	}
	
	
	//iterative dp solution
	static int anotherMaxSumNoAdjacent(int a[]){
		dp = new int[a.length];
		dp[0] = a[0];
		dp[1] = Math.max(a[0], a[1]);
		for(int i = 2; i < a.length ;i++){
			dp[i] = Math.max(a[i]+dp[i-2], dp[i-1]);
		}
		return dp[a.length-1];
		 
	}
	//Array traversal solution
	//inc : Max sum by including a[i]
	//exc : Max sum by exluding a[i]
	static int maxSumNoAdjacent(int a[]){
		if(a.length == 1) return a[0];
		if(a.length == 2) return Math.max(a[0], a[1]);
		
		int exc = a[0];
		int inc = a[1];
		for(int i = 2; i < a.length ; i++){
				int temp = exc;
				exc = Math.max(exc,inc);
				inc = temp+a[i];
		}
		return Math.max(inc, exc);
	}
	public static void main(String[] args) {
		int C[] =  {5, 5, 10, 40, 10, 5,1,1,1,1,111};
		System.out.println(maxSumNoAdjacent(C));
		System.out.println(anotherMaxSumNoAdjacent(C));
		/*dp = new int[C.length];
		for(int i = 0 ; i < dp.length ; i++) dp[i] = -1;
		System.out.println(Math.max(findMaxSumNoAdjacent(C, 0,C.length),findMaxSumNoAdjacent(C, 1,C.length)));*/
	}

}
