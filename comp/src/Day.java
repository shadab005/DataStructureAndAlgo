import java.util.Scanner;

public class Day {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);  
		long n=  sc.nextLong();
		long m = sc.nextLong();
		long k=n-m;
		if(k<=0){
			System.out.print(n);
		}else{
			Double x = (-1+Math.sqrt(1+8*k))/2;
			long y = x.longValue();
			if(y*(y+1)/2<k)y++;
			System.out.print(y+m);
			
		}
		sc.close();
	}
}
