import java.util.Scanner;

class CHNGOR {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
			int n = in.nextInt();
			int ans = 0;
			while(n-->0)ans  = ans | in.nextInt(); 
			System.out.println(ans);
		}
		in.close();
	}

}
