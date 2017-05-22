import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConfusedMonk {

	static int gcd(int a, int b){
		int temp=1;
		while(b!=0){
			temp = b;
			b=a%b;
			a=temp;
		}
		return a;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int q=1000000007;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a[]=new int[n];
		long ans=1;
		long b=1;
		int x=Integer.parseInt(st.nextToken());
		a[0]=x;
		int g=a[0];
		b=(b*x)%q;
		int i = 1;
		n--;
		while(n>0){
			x=Integer.parseInt(st.nextToken());
			a[i++]=x;
			g=gcd(g,x);
			b=(b*x)%q;
			n--;
		}
		/*for(int y: a){
			g=gcd(g,y);
			b=(b*y)%q;
		}*/
		
		while(g!=0){
			if((g&1)==1)ans=(b*ans)%q;
			b=(b*b)%q;
			g=g/2;
		}
		System.out.println(ans);

	}

}
