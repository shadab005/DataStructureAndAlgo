import java.util.Scanner;

public class WorldCup {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numZeroChild = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		
		int numTwoChild = numZeroChild-1;
		
		int a_new = a + numTwoChild;
		int b_new = b + numTwoChild;
		
		int finalRound = (int) (Math.log(a_new)/Math.log(2));
		
		int round = 1;
		while(a_new/2 != b_new/2) {
			round++;
			a_new = a_new/2;
			b_new = b_new/2;
		}
		if(round==finalRound) {
			System.out.println("Final!");
		}else {
			System.out.println(round);
		}
		in.close();

	}

}
