import java.util.Scanner;

public class ArrayManipulation {

	public static void main(String[] args) {
		int n=0;
		int m=0;
		int a=0,b=0,c=0;
		
		Scanner in = new Scanner(System.in);
		n=in.nextInt();
		m=in.nextInt();
		
		long[] ar=new long[n+1];
		for(int i=1;i<=n;i++)ar[i]=0;
		for(int i=0;i<m;++i)
		{
			a=in.nextInt();
			b=in.nextInt();
			c=in.nextInt();
			
			for(int j=a;j<=b;++j)
			{
				ar[j]+=c;
			}
		}
		
		//for(int i=1;i<=n;i++)System.out.println(ar[i]);
		long max=ar[0];
		for(int i=1;i<=n;++i)
		{
			if(max<ar[i])
				max=ar[i];
		}
		System.out.println(max);
		in.close();
	}

}


