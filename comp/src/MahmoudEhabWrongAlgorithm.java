import java.util.Scanner;

public class MahmoudEhabWrongAlgorithm {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		printWrongTree(n);
		//System.out.println();
		printCorrectTree(n);
		in.close();
	}

	private static void printCorrectTree(long n) {
		for(int i=2;i<=n;i++) {
			System.out.println("1 "+i);
		}
	}

	private static void printWrongTree(int n) {
		if(n<=5)System.out.println(-1);
		else if(n>7) {
			for(int i=1;i<3;i++) {
				System.out.println(i+" "+(2*i));
				System.out.println(i+" "+(2*i+1));
			}
			System.out.println("3 6");
			for(int i=7;i<=n;i++) {
				System.out.println("4 "+i);
			}
		}else {
			//n=6
			//n=7
			System.out.println("1 2");
			System.out.println("1 3");
			System.out.println("1 6");
			System.out.println("2 4");
			System.out.println("2 5");
			if(n==7)System.out.println("2 7");
		}
		
	}

}
