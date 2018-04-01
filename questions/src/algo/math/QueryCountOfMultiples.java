package algo.math;

/*
 * https://www.geeksforgeeks.org/queries-counts-multiples-array/
 * 
 * Given an array of positive integers and many queries for divisibility. 
 * In every query, we are given an integer k ( > 0),
 * we need to count all elements in the array which are perfectly divisible by ‘k’.
 * 
 * ex : i/p 2 4 9 15 21 20
 * for k =2 ans is 3
 * for k=5 and is 5
 * 
 * We will use  concept of Sieve of Eratosthenes.
 * For a number q : q, 2q, 3q , .. mq are the multiples of q
 */
public class QueryCountOfMultiples {

	private int n;
	private int ans[];
	QueryCountOfMultiples(int a[]){
		n = a.length;
		countSieve(a);
	}
	
	private void countSieve(int a[]) {
		int MAX = a[0];
		for(int i = 1; i < n; i++) MAX = Math.max(a[i], MAX);
		
		int cnt[] = new int[MAX + 1];
		ans = new int[MAX + 1];
		
		for(int i=0;i<n;i++)cnt[a[i]]++;
		
		//We are pre-calculating number of multiples of a number ith
		//Lets say i = 3, for every number 3,6,9,12.. and so on we are counting how many 
		//cnt[] turns out to be non-zero and summing that all up.
		for(int i=1;i<=MAX;i++)
			for(int j=i;j<=MAX;j=j+i)
				ans[i]+=cnt[j];
	}
	
	public int countMultiplesofK(int k) {
		return ans[k];
	}
	
	public static void main(String[] args) {
		int a[] = {2, 4, 9, 15, 21, 20};
		QueryCountOfMultiples q = new QueryCountOfMultiples(a);
		System.out.println(q.countMultiplesofK(2));
		System.out.println(q.countMultiplesofK(3));
		System.out.println(q.countMultiplesofK(5));
	}

}
