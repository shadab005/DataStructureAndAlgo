import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class InputTest {

	public static void main(String[] args) throws IOException {
		//Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		//boolean a[]=new boolean[n+1];
		String arrayInput=br.readLine();
		//System.out.println(arrayInput);
		String s[] = arrayInput.split(" ");
		
		/*for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}*/
		/*for(int i=1;i<=n;i++){
			byte b = in.nextByte();
			//System.out.println(b);
			if(b==1)a[i]=true;
			else a[i]=false;
			
		}*/
		/*for (boolean b : a) {
			System.out.println(b +" " + (b^true));
		}*/
		for(int i = 0; i < q ;i++){
			StringTokenizer stt = new StringTokenizer(br.readLine());
			int op=Integer.parseInt(stt.nextToken());
			if(op==1){
				int j=Integer.parseInt(stt.nextToken());
				if(s[j-1].equals("1"))s[j-1]="0";
				else s[j-1]="1";
				//a[j]=a[j]^true;
			}else{
				int j = Integer.parseInt(stt.nextToken());
				j=Integer.parseInt(stt.nextToken());
				if(s[j-1].equals("1"))System.out.println("ODD");
				else System.out.println("EVEN");
			}
		}
		//in.close();

	}

}
