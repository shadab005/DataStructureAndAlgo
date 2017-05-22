import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AverageSleepTime {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = in.nextInt();
		int k = in.nextInt();
		int a[]=new int[n];
		for(int i = 0;i <n ;i++){
			a[i]=in.nextInt();
		}
		long sum = 0;
		for(int i = 0; i < k; i++){
			sum+=a[i];
		}
		double total=sum;
		for(int j = 1 ; j <= n-k ;j++){
			sum=sum-a[j-1]+a[j+k-1];
			total+=sum;
		}
		System.out.printf("%.9f",(float)total/(n-k+1));
		in.close();

	}

}
