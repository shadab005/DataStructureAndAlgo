import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dhoom4 {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int k = in.nextInt();
		int n = in.nextInt();
		int[] keys = new int[n];
		for(int i=0;i<n;i++) {
			keys[i] = in.nextInt();
		}
		if(x==k) {
			System.out.println(0);
		}else {
			int h[] = new int[100001];
			boolean[] visited= new boolean[100001];
			Queue<Integer> q = new LinkedList<>();
			h[x]=0;
			visited[x]=true;
			q.add(x);
			boolean found = false;
			int y=0, z=0, i =0;
			int ans = -1;
			while(!q.isEmpty() && !found) {
				y = q.remove();
				for(i=0;i<n;i++) {
					z = (int) ((y*1L*keys[i])%100000);
					if(z<0) {
						z=z+100000;
					}
					if(z==k) {
						found=true;
						ans = h[y]+1;
						break;
					}
					if(!visited[z]) {
						visited[z]=true;
						h[z]=h[y]+1;
						q.add(z);
					}
				}
			}
			System.out.println(ans);
			
		}
		in.close();
	}
	
}
