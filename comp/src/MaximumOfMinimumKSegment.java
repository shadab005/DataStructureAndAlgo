import java.util.Scanner;

public class MaximumOfMinimumKSegment {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int smin = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			a[i]=in.nextInt();
			if(a[i]>max) {
				max=a[i];
			}
			if(a[i]<min){
				smin=min;
				min=a[i];
			}else if(a[i]<smin) {
				smin=a[i];
			}
		}
		
		if(k==1) {
			System.out.println(min);
		}else if(a[0]==max || a[n-1]==max || k>2) {
			System.out.println(max);
		}else {
		    System.out.println(Math.max(a[0], a[n-1]));	
		}
		in.close();
	}

}
