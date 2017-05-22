import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreePallindrome {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new java.io.BufferedReader(new InputStreamReader (System.in));
		int n = Integer.parseInt(br.readLine());
		if(n==1)System.out.println("a");
		else if(n==2)System.out.println("aa");
		else{
			StringBuilder s = new StringBuilder("aab");
			for(int i=3;i<n;i++){
				//System.out.println("i="+i);
				if(s.charAt(i-2)=='a' && s.charAt(i-1)=='a'){
					s.append("b");
				}else if(s.charAt(i-2)=='b' && s.charAt(i-1)=='b'){
					s.append("a");
				}else if(s.charAt(i-2)=='a' && s.charAt(i-1)=='b'){
					s.append("b");
				}else if(s.charAt(i-2)=='b' && s.charAt(i-1)=='a'){
					s.append("a");
				}
			}
			System.out.println(s);
		}

	}

}
