import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MagicNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		long a=in.nextInt();
		long b = in.nextInt();
		String s=in.next();
		int n =s.length();
		in.close();
		int i = 0;
		long ans=0;
		a=a%b;
		while(i<n){
			if(s.charAt(i)=='1'){
			  ans=(ans+(a)%b)%b;	
			}
			a=(a*a)%b;
			i++;
		}
		System.out.print(ans);

	}

}
