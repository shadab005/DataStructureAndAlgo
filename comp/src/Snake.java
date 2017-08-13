import java.util.Scanner;

class Snake {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int n = 0;
		boolean first=false;
		boolean second=false;
		while(t-->0){
			first=false;
			second=false;
			n = in.nextInt();
			String s1 = in.next();
			String s2 = in.next();
			first=s1.contains("*");
			second=s2.contains("*");
			if(first&&second){
			  solve(s1,s2,n);	
			}
			else if(first)solve(s1, n);
			else solve(s2, n);
		}
		in.close();
	}

	public static void solve(String s1, String s2, int n) {
		int divide=0;
		int u = -1;
		int v = -1;
		for(int i=0;i<n;i++){
			if(s1.charAt(i)=='*'){
			   if(u==-1)u=i;
			   else{
				  divide++;
				  u=i;
				  v=-1;
			   }
			}
			if(s2.charAt(i)=='*'){
				if(v==-1)v=i;
				else{
					divide++;
					v=i;
					if(s1.charAt(i)=='*'){
						u=i;
					}else{
						u=-1;
					}
				}
			}
		}
		System.out.println(divide+1);
	}

	public static void solve(String s, int n) {
		int divide=0;
		int i=0;
		while(i<n && s.charAt(i)=='.')i++;
		if(i==n){
			System.out.println(0);
			return;
		}
		for(i=i+1;i<n;i++){
			if(s.charAt(i)=='*')divide++;
		}
		System.out.println(divide);
		
	}


}