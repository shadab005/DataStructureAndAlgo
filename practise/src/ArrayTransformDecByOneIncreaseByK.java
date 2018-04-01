import java.util.Scanner;

/*
 * https://www.codechef.com/problems/ARRAYTRM
 */
class ArrayTransformDecByOneIncreaseByK {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0) {
			int n = in.nextInt();
			int k = in.nextInt();
			int remainder[] = new int[k+1];
			for(int i=0;i<n;i++) {
				remainder[in.nextInt()%(k+1)]++;;
			}
			boolean ans = true;
			int ncount = 0;
			int nonZeroCount = 0;
			for(int x:remainder) {
				if(x!=0) {
					nonZeroCount++;
					if(x>=n-1)ncount++;
				}
			}
			//Util.printArray(remainder);
			if(nonZeroCount>2) {
				ans = false;
			}
			if(ncount==0) {
				ans = false;
			}
			
			if(ans) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
		}
		in.close();

	}

}
