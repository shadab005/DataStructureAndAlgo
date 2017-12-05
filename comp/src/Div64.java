import java.util.Scanner;

public class Div64 {

	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		String s = in.next();
		int i = 0;
		int n = s.length();
		while(i<n && s.charAt(i)!='1')i++;
		if(i==n)System.out.println("no");
		else {
			int j = i+1;
			while(j<n && s.charAt(j)!='0')j++;
			if(j==n) {
				if(j-i>=5) {
					System.out.println("yes");
				}else {
					System.out.println("no");
				}
			}else {
				i=j-1;
				int countZero = 0;
				while(j<n) {
					if(s.charAt(j)=='0') {
						countZero++;
					}
					j++;
				}
				if(countZero>=5)System.out.println("yes");
				else System.out.println("no");
			}
			
		}
		in.close();
		

	}

}
