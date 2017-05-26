import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MinJump {

	public static int minStep(int[] a, int n) {
		int minIndexToJump[]  = new int[n];
		int i = 0;
		for(int j=1;j<n;j++){
			while(i+a[i]<j && i<j)i++;
			if(i>=j) return -1;
			else minIndexToJump[j]=i;
		}
		int count=1;
		int j=n-1;
		while(minIndexToJump[j]!=0){
			j=minIndexToJump[j];
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		//int a[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int a[]=new int[100];
		int n = 0;
		while(t-->0){
			n = in.nextInt();
			for(int i=0;i<n;i++)a[i]=in.nextInt();
			System.out.println(minStep(a,n));
		}
		in.close();
	}
}
