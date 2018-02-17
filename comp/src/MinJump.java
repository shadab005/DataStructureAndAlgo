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
			System.out.println(minJump(a,n));
		}
		in.close();
	}
	
	public static int minJump(int[] a, int n) {
		if(a[0]==0)return -1;
		int count = 0;
		int i = 0;
		while(i+a[i] < n-1) {
			//System.out.println("Solving for i = " + i);
			i = getMax(a, i+1, i+a[i]);
			//System.out.println("Next index to jump = " + i);
			if(a[i]==0)return -1;
			count++;
			//System.out.println("count = " + count);
		}
		return count+1;
	}

	private static int getMax(int[] a, int i, int j) {
		int max = -1, maxIndex = 0;
		max = i+a[i];
		maxIndex = i;
		for(int k = i+1 ; k<=j ;k++) {
			if(max < a[k]+k) {
				max = a[k]+k;
				maxIndex = k;
			}
		}
		return maxIndex;
	}
}
