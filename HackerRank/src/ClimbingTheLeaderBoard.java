import java.util.Scanner;

public class ClimbingTheLeaderBoard {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int s[] = new int[n];
		int rank[] = new int[n];
		s[0]=in.nextInt();
		rank[0]=1;
		for(int i=1;i<n;i++) {
			s[i]=in.nextInt();
			if(s[i]==s[i-1]) 
			  rank[i]=rank[i-1];
			else
			  rank[i]=rank[i-1]+1;
		}
		
		int m = in.nextInt();
		int r = rank[n-1]+1;
		int currentPos = n;
		int value=0;
		for(int i=0;i<m;i++) {
			value=in.nextInt();
			while(currentPos>=1 && value>=s[currentPos-1]) {
				r=rank[currentPos-1];
				currentPos--;
			}
			System.out.println(r);
		}
		
		in.close();

	}

}
