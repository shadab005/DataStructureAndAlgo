import java.util.Scanner;

public class CabScheduling {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n =0 , k =0;
		n = in.nextInt();
		k = in.nextInt();
		int a[] = new int[k];
		int min = Integer.MAX_VALUE;
		for(int i=0;i<k;i++) {
			a[i]=in.nextInt();
			min = Math.min(min, a[i]);
		}
		
		int end = (int) Math.ceil(n/min);
		int start = min;
		int result = bsearch(start, end, n, a, k);
		System.out.println(result);
		in.close();
	}

	private static int bsearch(int start, int end, int n, int[] arr, int k) {
		int mid = (start + end)/2;
		int trips = calculateTrips(mid, arr, k);
		if(trips < n) {
		return bsearch(mid + 1, end, n, arr, k);
		}
		else if(trips > n) {
		return bsearch(start, mid - 1, n, arr, k);
		}
		return mid;
	}

	private static int calculateTrips(int time, int[] arr, int k) {
		int trips = 0;
		for (int i = 0; i < k; i++) {
		trips += time/arr[i];
		}
		return trips;
	}

}
