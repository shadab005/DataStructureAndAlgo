import java.util.Scanner;

class CHNGFUNC {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		long sqr = 0, ans = 0;
		int count = 0;
		for(int i = 1;i<=a;i++){
			sqr  = i*1L*i;
			count = (int) Math.sqrt(sqr+b)-i;
			ans+=count;
		}
		System.out.println(ans);
		in.close();

	}
}
	