import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FlipDBeat {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		int a[]= new int[10001];
		int n = 0;
		while(t-->0){
			n = in.nextInt();
			for(int i=0;i<n;i++){
				a[i]=in.nextInt();
			}
			solve(a,n);
		}
		in.close();
			//{1,0,1,1,0,0,1};

	}
	
	static void solve(int a[], int n){
		int i=0;
		int j=0;
		while(a[i]!=0 && i<n)i++;
		if(i==n){
			System.out.println(n);
			return;
		}
		j=i+1;
		int countZero=1;
		int countOne=0;
		int max=-1;
		int maxj=-1;
		int maxi=i;
		int ans=0;
		while(j<n){
			if(a[j]==0)countZero++;
			else countOne++;
			if(countOne<=countZero){
				if(countZero-countOne>max){
					max=countZero-countOne;
					maxj=j;
					maxi=i;
					ans=countZero;
				}
				max=Math.max(max, countZero-countOne);
			}else{
				i=j+1;
				countZero=0;
				countOne=0;
			}
			j++;
		}
		i=maxi-1;
		while(i>=0){
			if(a[i]==1)ans++;
			i--;
		}
		i=maxj+1;
		while(i<n){
			if(a[i]==1)ans++;
			i++;
		}
		System.out.println(ans);
	}

}
