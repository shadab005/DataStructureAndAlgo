import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class TidyNumbers {
	static String getTidyNumber(String s){
		int n = s.length();
		int i = 0;
		char maxChar=s.charAt(0);
		int maxPos=0;
		while(i<n-1){
			if(s.charAt(i)>s.charAt(i+1))break;
			if(s.charAt(i+1)>maxChar){
				maxChar=s.charAt(i+1);
				maxPos=i+1;
			}
			i++;
		}
		if(i==n-1)return s;
		if(s.charAt(i)==maxChar)i=maxPos;
		int z = Character.getNumericValue(s.charAt(i));
		if(z==1){
			return String.join("", Collections.nCopies(n-1, "9"));
		}else{
			z=z-1;
			return s.substring(0, i)+z+String.join("", Collections.nCopies(n-i-1, "9"));
		}
		
	}
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++){
			System.out.println("Case #"+i+": "+getTidyNumber(br.readLine()));
		}
	}

}
