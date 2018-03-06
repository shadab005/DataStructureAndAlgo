import java.util.Scanner;

public class PeculiarAppleTree {

	
	public static void main(String[] args) {
	   Scanner in  = new Scanner(System.in);
	   int n = in.nextInt();
	   int a[] = new int[n+1];
	   int levelCount[] = new int[n+1];
	   int jump[] = new int[n+1];
	   levelCount[0]=1;
	   for(int i=2;i<=n;i++) {
		   a[i]=in.nextInt();
		   jump[i]=jump[a[i]]+1;
		   levelCount[jump[i]]++;
	   }
	   int ans = 0;
	   for(int x:levelCount) {
		   if(x%2!=0)ans++;
	   }
	   System.out.println(ans);
	   in.close();

	}

}

