import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DPMinSumDiff {

	static int min=0;
	static int maxMin = 0;
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		int a[] = new int[100000];
		int n = 0;
		int answer = 0;
		while(t-->0){
			n = in.nextInt();
			for(int i = 0;i<n;i++)a[i]=in.nextInt();
			answer = orderNSolution(a,n);
			System.out.println(answer);
		}
		in.close();
		//int a[]= {100,2,100,2,100};
			   //{10,1,10,1,10};
		       //{5,9,10,12,3};
	/*	calculateMinDIff(a,a.length-2, a[a.length-1],0);
		//System.out.println();
		calculateMinDIff(a,a.length-2, 1 ,0);
		System.out.println(min);*/
		

	}
	public static int orderNSolution(int[] a, int n) {
		int diffN=0;
		int diffOne=0;
		int newDiffN=0;
		int newDiffOne=0;
		for(int i=1;i<n;i++){
			newDiffN = Math.max(Math.abs(a[i]-a[i-1])+diffN, Math.abs(a[i]-1)+diffOne);
			newDiffOne = Math.max(Math.abs(1-a[i-1])+diffN, Math.abs(diffOne));
			diffN=newDiffN;
			diffOne=newDiffOne;
		}
		return Math.max(diffN, diffOne);
	}
	
	
	public static void calculateMinDIff(int[] a, int n, int prev, int prevDiff) {
		//System.out.println("n="+n +" prev="+prev+ " prevDiff="+prevDiff);
		if(n<0) return;
		if(n==0){
			int diff = prevDiff+Math.max(Math.abs(a[n]-prev),Math.abs(prev-1));
			//System.out.println("diff="+diff+" prev="+ prev +" prevdiff="+prevDiff);
			if(diff>min)min =diff;
			return;
		}
		//Choosing max a[n];
		calculateMinDIff(a, n-1, a[n], prevDiff+Math.abs(a[n]-prev));
		//Choosing a[n] to be 1
		calculateMinDIff(a, n-1, 1, prevDiff+Math.abs(prev-1));
		
	}
	
	

}
