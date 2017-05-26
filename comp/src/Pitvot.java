import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Pitvot {

	public static void getPivot(int a[], int n){
		int i=0;
		int j=n-1;
		int mid=i+(j-i)/2;;
		while(i!=j){
			if(a[mid]>a[(mid-1+n)%n] && a[mid]>a[(mid+1)%n])break;
			if(a[i]>a[j]){
				if(a[i]>a[(mid+1)%n])j=mid-1;
				else i=mid+1;
			}
			else{
				if(a[j]>a[(mid-1+n)%n])i=mid+1;
				else j=mid-1;
			}
			mid=(i+j)/2;
		}
		int type=0;
		if(mid==n-1 && a[(mid+1)%n]<a[mid-1])type=1;
		else if(mid==0 && a[(mid-1+n)%n]<a[(mid+1)])type=2;
		else if(a[(mid+1)%n]<a[(mid-1+n)%n])type=4;
		else type=3;
		System.out.println(a[mid]+" "+type);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		int n = 0;
		int a[]=new int[100];
		while(t-->0){
			n = in.nextInt();
			for(int i=0;i<n;i++)a[i]=in.nextInt();
			getPivot(a, n);
		}
		in.close();
	}

}
