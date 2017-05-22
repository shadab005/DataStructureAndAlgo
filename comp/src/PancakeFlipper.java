import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class PancakeFlipper {
	
	static void getFlipCount(String s, String k, int caseNumber){
		s=s.replace('-', '1');
		s=s.replace('+', '0');
		//int n = Integer.parseInt(s, 2);
		BigInteger one = new BigInteger("1");
		BigInteger zero = new BigInteger("0");
		BigInteger n = new BigInteger(s,2);
		BigInteger kk = new BigInteger(k);
		BigInteger m = new BigInteger("1");
		while(kk.compareTo(zero)!=0){
		  m = m.shiftLeft(1);
		  kk=kk.subtract(one);
		}
		m=m.subtract(one);
		if(n.compareTo(zero)==0){
			System.out.println("Case #"+caseNumber+": "+0);
		}else{
			int count=0;
			while(n.and(one).compareTo(zero)==0 && n.compareTo(zero)!=0){
				n=n.shiftRight(1);
			}
			while(n.compareTo(zero)!=0 && n.compareTo(m)>=0){
				n=n.xor(m);
				count++;
				while(n.and(one).compareTo(zero)==0 && n.compareTo(zero)!=0){
					n=n.shiftRight(1);
				}
			}
			if(n.compareTo(m)<0 && n.compareTo(zero)!=0){
				System.out.println("Case #"+caseNumber+": IMPOSSIBLE");
			}else{
				System.out.println("Case #"+caseNumber+": "+count);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i = 1; i <= t; i++){
			getFlipCount(in.next(),in.next(),i);
		}
		in.close();

	}
	/*
	 static void getFlipCount(String s, int k, int caseNumber){
		s=s.replace('-', '1');
		s=s.replace('+', '0');
		int n = Integer.parseInt(s, 2);
		int m = (1<<k)-1;
		if(n==0){
			System.out.println("Case #"+caseNumber+": "+0);
		}else{
			int count=0;
			while((n&1)==0 && n!=0){
				n=n>>1;
			}
			while(n!=0 && n >= m){
				n=n^m;
				count++;
				while((n&1)==0 && n!=0){
					n=n>>1;
				}
			}
			if(n<m && n!=0){
				System.out.println("Case #"+caseNumber+": IMPOSSIBLE");
			}else{
				System.out.println("Case #"+caseNumber+": "+count);
			}
		}
	}
	 */

}
