import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class DPLongestIncreasingSubsequence {

	/*
	 * lis(i)=1+Max(lis[1 to i-1]) where lis(i) is the longest sequence that ends with a[i]
	 */
	
	/*
	 * L[i]=0 if i = 0
	 *      1+Max(L[j]) where 0<=j<=i-1 and a[j]<a[i] 
	 */
	//O(n^2)
	static int longestIncreasingSubsequence(int a[]){
		int n = a.length;
		int dp[]= new int[a.length];
		ArrayList<Stack<Integer>> list = new ArrayList<>(n);
		for(int i = 0 ; i < n ; i++){
			list.add(i,new Stack<>());
		}
		dp[0]=1;
		int max = 0;
		list.get(0).push(a[0]);
		for(int i = 1; i < n; i++){
			max=0;
		   	for(int j = 0 ; j<i ;j++){
		   		if(a[j]< a[i] && max < dp[j]){
		   			list.get(i).push(a[j]);
		   			max=dp[j];
		   		}
		   	}
		   	list.get(i).push(a[i]);
		   	dp[i]=max+1;
		}
		max=0;
		for(int i = 0; i < n ; i++){
			if(max<dp[i])max=dp[i];
			//System.out.println(list.get(i));
		}
		//System.out.println("=========================");
		return max;
	}
	
	
	HashMap<Integer,Integer> map = new HashMap<>();
	public static int lis(int a[], int n, int x) {
        if(n<0)return 0;
        int m = lis(a, n-1,x);//nth element is not included in the solution
        if(a[n]<x) {
        	m = Math.max(m, 1+lis(a,n-1,a[n]));
        }
		return m;
	}
	//1 5 2 3
	public static void main(String[] args) {
		int a[]={ 15, 27, 14, 38, 26, 55, 46, 65, 85 };
		int b[]={3,4,5,1,0};
		int c[]={2,7,8};
		int d[] = {5,4,3,2,1};	
		int e[] = {10,5,1,6};
		int f[] = {3,2,6,4,5,1};
		int g[] = {10, 13, 17, 18, 1, 2};
		System.out.println(longestIncreasingSubsequence(a));
		System.out.println(lis(a,a.length-1,Integer.MAX_VALUE));
		
		System.out.println(longestIncreasingSubsequence(b));
		System.out.println(longestIncreasingSubsequence(c));
		System.out.println(longestIncreasingSubsequence(d));
		System.out.println(longestIncreasingSubsequence(e));
		System.out.println(longestIncreasingSubsequence(f));
		System.out.println(longestIncreasingSubsequence(g));

	}

}
