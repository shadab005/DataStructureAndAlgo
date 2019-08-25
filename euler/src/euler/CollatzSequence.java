package euler;

import java.util.Arrays;

/*
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 */
public class CollatzSequence {

	public static void main(String[] args) {
		//find max chain till one million
		int n = 1000000;
		int a[] = new int[n];
		Arrays.fill(a, -1);
		a[1] = 0;
		a[2] = 1;
		long max  = 0;
		int ans = 0;
		for ( int i = 3; i < a.length;i++) {
			
			//get chain length for i
			long k = i;
			int count = 0;
			while(k!=1) {
				if(k > 0 && k < n && a[(int)k]!=-1) {
					count+=a[(int)k];
					break;
				} else {
					count++;
				}
				//odd case
				if((k&1) == 1) {
					k = 3*k + 1;
				} else {
					k = k/2;
				}
			}
			a[i] = count;
			if(max < count) {
				max = count;
				ans = i;
			}
		}
		
		System.out.println(max +" ## " + ans + " ## " + a[ans]);

	}

}
