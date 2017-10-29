import java.util.Scanner;

//http://xoptutorials.com/index.php/2017/01/01/spojpour1/
class POUR {

	public static void main(String[] args) {
		//POUR p = new POUR();
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int temp = 0;
		while (t-- > 0) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			if(a<b) {
				temp = a;
				a = b;
				b = temp;
			}
			if (a < c && b < c)
				System.out.println(-1);
			else {
				int gcd = gcdIterative(a, b);
				if (c % gcd != 0) {
					System.out.println(-1);
				} else {
					System.out.println( Math.min(cnt(a, b, c), cnt(b, a, c)));
				}
			}
		}
		in.close();

	}

	
	static int gcdIterative(int a, int b) {
		int r=0;
		while(b!=0) {
			r = a % b;
			a=b;
			b=r;
		}
		return a;
	}
	
	static int cnt(int A, int B, int C) {
		int move = 1, a = A, b = 0, pour;
		while(a != C && b != C) {
			pour = Math.min(a, B-b);
			b += pour;
			a -= pour;
			move++;
			if(a == C || b == C) break;
			if(b==B) {
				b = 0;
				move++; 
			}
			else if(a==0) {
				a = A;
				move++;
			}
		}
		return move;
	}
}
