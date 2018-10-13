import java.util.Scanner;


//import java.util.Scanner;

class DPCandies {

	public static void main(String[] args) {
		// int n = 10;
		// int a[] ={2,4,2,6,1,7,8,9,2,1};
		/*
		 * n = 3; int a[] = {1,2,2};
		 */
	/*	Scanner in = new Scanner(System.in);
		// int t = in.nextInt();
		// while(t-->0){
		int n = in.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		calculateMinCandies(a, n);
		// }
		in.close();*/
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();

		int[] children = new int[length];
		int[] candies = new int[length];

		// seed
		children[0] = scan.nextInt();
		candies[0] = 1;

		// search forward sequences
		for (int i = 1; i < length; i++){
			children[i] = scan.nextInt();
			candies[i] = 1;
			if (children[i] > children[i - 1]) 
				candies[i] = candies[i - 1] + 1;   
		}

		// search reverse sequences
		for (int i = length - 1; i > 0; i--){
		    if (children[i] < children[i - 1]) 
			    candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
		}

		long sum = 0;
		for (int i= 0; i < candies.length; i++){
			sum += candies[i];
		}

		System.out.println(sum);
		scan.close();

	}

	// 1 2 2
	public static void calculateMinCandies(int[] a, int n) {
		int dp[] = new int[n];
		dp[0] = 1;
		int i = 0;
		for (i = 1; i < n; i++) {
			if (a[i] > a[i - 1]) {
				if (dp[i - 1] <= 1)
					dp[i] = 2;
				else
					dp[i] = dp[i - 1] + 1;
			} else if (a[i] == a[i - 1])
				dp[i] = 1;
			else
				dp[i] = 0;
		}
		//Util.printArray(dp);
		i = n - 1;
		while (i >= 0) {
			int j = i - 1;
			if (dp[i] == 0) {
				j = i;
				dp[i] = 1;
				j--;
				while (j >= 0) {
					if (a[j] > a[j + 1])
						dp[j] = dp[j + 1] + 1;
					else if (a[j] == a[j + 1]) {
						dp[j] = 1;
					} else {
						// Correcting a[j+1]
						if (j < n - 2) {
							if (a[j + 1] == a[j + 2]) {
								dp[j + 1] = Math.max(1 + dp[j], dp[j + 2]);
								if(dp[j+1]==1)dp[j+1]=2;
							} else {
								dp[j + 1] = 1 + Math.max(dp[j], dp[j + 2]);
							}
						}
						break;
					}
					j--;
				}
			}
			i = j;
		}
		long sum = 0;
		for (i = 0; i < n; i++)
			sum += dp[i];
		System.out.println(sum);

	}

}
