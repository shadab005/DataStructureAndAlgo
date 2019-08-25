import java.util.Scanner;

class SALARY {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0) {
			int n = in.nextInt();
			int min = Integer.MAX_VALUE;
			int a[] = new int[n];
			int i = 0;
			while(n-->0) {
				a[i] = in.nextInt();
				min = Math.min(min, a[i]);
				i++;
			}
			n = a.length;
			int ans = 0;
			for(i=0; i<n;i++) {
				ans += (a[i]-min);
			}
			System.out.println(ans);
		}
		in.close();
	}

}
