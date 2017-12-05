import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DPMinDifferenceSubset {

	static int k = 0;//12;
	static int a[];//={2,6,11,5};
	static int dp[][];
	public static int minDiff(int n, int sumYet){
		int minDIffYet = Integer.MAX_VALUE;//Infinity
		if(k>=sumYet)minDIffYet=k-sumYet;
		if(n!=-1){
			if(dp[sumYet][n]!=-1) return dp[sumYet][n]; 
			if(a[n]>k)minDIffYet=Math.min(minDIffYet,minDiff(n-1, sumYet));
			else{
				int x=Math.min(minDiff(n-1, sumYet+a[n]), minDiff(n-1, sumYet));
				minDIffYet=Math.min(x, minDIffYet);
			}
			dp[sumYet][n]=minDIffYet;
		}
		return minDIffYet;
	}
	
	static void initializeDp(int m, int n){
		for(int i = 0; i < m ; i++){
			for(int j=0;j<n;j++){
				dp[i][j]=-1;
			}
		}
	}
	
	/*public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i = 1; i <= t; i++){
			int n = in.nextInt();
			a = new int[n];
			int sum=0;
			for(int j = 0; j < n ; j++){
				a[j]=in.nextInt();
				sum+=a[j];
			}
			dp=new int[sum+1][n];
			initializeDp(sum+1, n);
			k=(sum+1)/2;
			//System.out.println(k);
			int min=minimumDifference(a, k);
			//int min  = minDiff(n-1, 0);
			System.out.println("Sum = " + sum);
			System.out.println("k = " + k);
			System.out.println("Minimum = " + min);
			int firstSubsetSum = k-min;
			//System.out.println(firstSubsetSum);
			int secondSubsetSum= sum-firstSubsetSum;
			//System.out.println(secondSubsetSum);
			System.out.println(Math.abs(secondSubsetSum-firstSubsetSum));
		}
		in.close();
	}*/
	
	public static void main(String[] args) {
	   int n=4;
	   a=new int[n];
	   a[0]=2;
	   a[1]=6;
	   a[2]=11;
	   a[3]=5;
	   int sum=0;//sum(a);
	   for(int j = 0; j < n ; j++){
			sum+=a[j];
		}
	   //dp=new int[sum+1][n];
	   //initializeDp(sum+1, n);
	   k=(sum)/2;
	   int min=minimumDifference(a, k);
	   System.out.println(min);
	   int firstSubsetSum = k-min;
	   int secondSubsetSum= sum-firstSubsetSum;
	   System.out.println(Math.abs(secondSubsetSum-firstSubsetSum));
	   
	}
	
	static int minimumDifference(int a[], int sum){
		int n = a.length;
		int min[]=new int[sum+1];
		int currentMinIndex[]=new int[sum+1];
		int prevMinVal[]=new int[sum+1];
		for(int i = 0 ; i< sum+1 ;i++)
		{min[i]=Integer.MAX_VALUE;currentMinIndex[i]=-1;prevMinVal[i]=Integer.MAX_VALUE+1;}
		for(int i = 0 ; i < n  ;i++){
			if(a[i]<=sum){
				for(int j = a[i]; j < sum+1 ; j++){
					if(j-a[i] < min[j-a[i]] && j-a[i] < min[j]){
						prevMinVal[j]=min[j];
						currentMinIndex[j]=i;
						min[j]=j-a[i];
					}else{
						if(currentMinIndex[j-a[i]]!=i){
							if(min[j-a[i]] < min[j]){
								prevMinVal[j]=min[j];
								currentMinIndex[j]=i;
								min[j]= min[j-a[i]];
							}
						}else{
							if(prevMinVal[j-a[i]] < min[j]){
								prevMinVal[j]=min[j];
								currentMinIndex[j]=i;
								min[j]= prevMinVal[j-a[i]];
							} else if(j-a[i] < min[j]){
								prevMinVal[j]=min[j];
								currentMinIndex[j]=i;
								min[j]=j-a[i];
							}
							
						}
					}
			    }
			}
			//Util.printArray(min);
		}
		return min[sum];
	}

}
