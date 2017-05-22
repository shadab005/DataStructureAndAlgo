import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * This is partition into equal sum subset
 */
public class DPPartitionProblem {

	public static boolean canBePartioned (int a[]){
	
		int sum=0;
		for(int x:a)sum+=x;
		if((sum&1)==1) return false;
		return isSubSetSum(a,sum/2);
	}
	
	private static boolean isSubSetSum(int a[], int k){
		
		int m = k;
		int n = a.length;
		boolean dp[][] = new boolean[m+1][n+1];
		for (int i = 0; i <= n; i++)dp[0][i] = true;
		
		for(int i=1;i<=k;i++){
		  for(int j=1 ; j <= n ; j++){
			  if(a[j-1] > i)dp[i][j]=dp[i][j-1];
			  else{
				  dp[i][j]=dp[i-a[j-1]][j-1] || dp[i][j-1];
			  }
		  }
		}
		return dp[k][n];
	}
	public static void main(String[] args) {
		//int a[] = {1,3,5};
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	//	int t = in.nextInt();
		int a[] ;
		//for(int i = 1; i <= t; i++){
			int n = in.nextInt();
			a = new int[n];
			for(int j = 0; j < n ; j++){
				a[j]=in.nextInt();
			}
			System.out.println(canBePartioned(a)?"YES":"NO");
		//}
		in.close();

	}

}
