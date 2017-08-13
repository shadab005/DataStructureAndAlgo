import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class EqualChocolates {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		while(t-->0){
		    int n = in.nextInt();
		    int a[] = new int[n];
		    for(int i=0;i<n;i++)a[i]=in.nextInt();
		    Arrays.sort(a);
		    counMinWay(a,n);
		}
		in.close();
	}

	private static void counMinWay(int[] a, int n) {
		int count = 0;
		int min = a[0];
		int i = 1;
		while(  i<n && a[i]==min)i++;
		if(i==n)System.out.println(0);
		else{
			while(i<n){
				int x = (a[i]-min)/5;
				count+= x;
				a[i]=a[i]-5*x;

				x = (a[i]-min)/2;
				count+=x;
				a[i]=a[i]-2*x;
				
				count= count + a[i]-min;
				
				i++;
			}
			System.out.println(count);
		}
		
	}

}
