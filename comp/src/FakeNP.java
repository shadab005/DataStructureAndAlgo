import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FakeNP {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new java.io.BufferedReader(new InputStreamReader (System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		if(l!=r)System.out.println(2);
		else{
			if((l&1)==1){
				System.out.println(l);
			}else{
				System.out.println(2);
			}
		}

	}

}
