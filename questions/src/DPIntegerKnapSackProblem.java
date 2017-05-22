public class DPIntegerKnapSackProblem {

	/*
	 * c: 10 w: 5 6 v: 6 9
	 */

	public static int iKSWithDuplicates(int c, int w[], int v[]) {
		if (c == 0)
			return 0;
		int n = w.length;
		int max = 0, ret = 0;
		for (int i = 0; i < n; i++) {
			if (c >= w[i])
				ret = v[i] + iKSWithDuplicates(c - w[i], w, v);
			if (max < ret) {
				max = ret;
			}
		}
		return max;
	}

	/*
	 * j: quantity iks(j)=max(iks(j-1),max(iks(j-w[i])+v[i]) for i = 1 to n) ,
	 * j>=1 0 if j<=0;
	 */
	public static int ikSIterativeWithDuplicates(int c, int w[], int v[]) {
		int n = w.length;
		int dp[] = new int[c + 1];
		int max = 0;
		for (int q = 1; q <= c; q++) {
			max = dp[q - 1];
			for (int j = 0; j < n; j++) {
				if (q - w[j] >= 0) {
					max = Math.max(max, v[j] + dp[q - w[j]]);
				}
			}
			dp[q] = max;
		}
		return dp[c];
	}

	static int knapSack01(int c, int w[], int v[]) {
		int n = w.length;
		int dp[][] = new int[n + 1][c + 1];
		for (int i = 1; i <= n; i++) {
			for (int q = 1; q <= c; q++) {
				if (w[i - 1] > q)
					dp[i][q] = dp[i - 1][q];
				else {
					dp[i][q] = Math.max(v[i - 1] + dp[i - 1][q - w[i - 1]], dp[i - 1][q]);
				}
			}
		}
		return dp[n][c];
	}

	/*
	 * M(i,j)=Max{M(i-1,j), M(i-1,j-w[i])+v[i]}
	 * 
	 * i : element j : quantity
	 */
	static int knapSack01R(int c, int w[], int v[], int n) {
		if (n == 0 || c == 0)
			return 0;
		if (w[n - 1] > c)
			return knapSack01R(c, w, v, n - 1);
		else
			return Math.max(v[n - 1] + knapSack01R(c - w[n - 1], w, v, n - 1), knapSack01R(c, w, v, n - 1));
	}

	public static void main(String args[]) {
		/*
		 * int w[]={4,8}; int v[]={6,9}; int c = 8;
		 */

		/*int w[] = { 10, 20, 30 };
		int v[] = { 60, 100, 120 };
		int c = 48;
		System.out.println("Weight limit " + c);
		System.out.println("Weight matrix");
		Util.printArray(w);
		System.out.println("Value matrix");
		Util.printArray(v);
		System.out.println(IntegerKnapSackProblem.iKSWithDuplicates(c, w, v));
		System.out.println(IntegerKnapSackProblem.ikSIterativeWithDuplicates(c, w, v));
*/
		
		  int w[]={1,5,3,4}; int v[]={15,10,9,5};
		 
		 int c = 8;
		System.out.println(knapSack01(c, w, v));
		System.out.println(knapSack01R(c, w, v, w.length));
		System.out.println("End");
	}
}
