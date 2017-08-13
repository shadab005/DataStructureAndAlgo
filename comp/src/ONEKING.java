import java.util.Arrays;
import java.util.Scanner;

class ONEKING {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
		int n = in.nextInt();
		Tuple[] kingdoms = new Tuple[n];
		for(int i = 0; i<n ;i++){
			kingdoms[i]=new Tuple(in.nextInt(),in.nextInt());	
		}
		Arrays.sort(kingdoms, (Tuple o1, Tuple o2)-> o1.y-o2.y); //O(nlogn)
		int c = 0;
		int prev=kingdoms[0].y;
		for(int i=1;i<n;i++){
			if(prev < kingdoms[i].x){
				c++;
				prev = kingdoms[i].y;
			}
		}
		c++;
		
		System.out.println(c);
		}
		in.close();
	}
	
	static class Tuple{
		int x;
		int y;
		Tuple(int a, int b){
			x=a;y=b;
		}
		
		@Override
		public String toString(){
			return "["+x+","+y+"]";
		}
	}

}
