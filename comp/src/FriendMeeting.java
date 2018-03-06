import java.util.Scanner;

public class FriendMeeting {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a  = in.nextInt();
		int b = in.nextInt();
		int diff = Math.abs(a-b);
		
			if(diff%2!=0) {
				int steps = (diff-1)/2;
				System.out.println(count(steps)+count(steps+1));
			}else {
				int steps = diff/2;
				System.out.println(2*count(steps));
			}
			in.close();
				
	}
	
	public static int count(int n)
	{
		return n*(n+1)/2;
	}

}
