import java.util.Arrays;
import java.util.Scanner;

public class CF_GrowTheTree {

	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for(int i = 0; i< n ; i++) {
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		int j = n/2;
		long X = getSum(a, 0, j-1);
		long Y = getSum(a, j, n-1);
		System.out.println(X*X+Y*Y);
		in.close();
	}

	static long getSum(int a[] , int i, int j) {
		long sum = 0;
		for(int k = i; k<=j; k++) {
			sum+=a[k];
		}
		return sum;
	}
}
