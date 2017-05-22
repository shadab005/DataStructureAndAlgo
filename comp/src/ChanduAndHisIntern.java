import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChanduAndHisIntern {
	public static void main(String[] args)  throws Exception{
		int n = 10000000;
		int a[]=new int[n+1];
		a[0]=0;
		a[1]=0;
		for(int i = 2; i*i<=n;i++){
			if(a[i]==0){
				for(int j = i*i; j<=n;j=j+i){
					a[j]=i;
				}
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringBuilder output=new StringBuilder();
		int x=0;
		while(N>0){
			x=Integer.parseInt(br.readLine());
			if(a[x]==0 || x==a[x]*a[x])output.append("NO"+"\n");
			else output.append("YES"+"\n");
			N--;
		}
		System.out.println(output.toString());
	}
}
