import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class EasyUberCount {

	
	public static void main(String[] args) {
	   Scanner in = new Scanner(System.in);
	   int n = in.nextInt();
	   ArrayList<Interval> l = new ArrayList<>();
	   for(int i = 0;i<n;i++) {
		   l.add(new Interval(in.nextInt(), in.nextInt()));
	   }
	   solve(l);
	   in.close();

	}
	
	
	private static void solve(ArrayList<Interval> l) {
		Comparator<Interval> byStart = (o1,o2)->o1.s-o2.s;
		l.sort(byStart);
		ArrayList<Interval> ans = new ArrayList<>();
		Interval prev = l.get(0);
		for(int i=1;i<l.size();i++) {
			if(prev.intersect(l.get(i))) {
				prev = merge(prev,l.get(i)); 
			}else {
				ans.add(prev);
				prev = l.get(i);
			}
		}
		ans.add(prev);
		int ret = 0;
		for(Interval z : ans) {
			ret+=(z.e-z.s+1);
			//System.out.println(z);
		}
		System.out.println(ret);
		
	}


	private static Interval merge(Interval prev, Interval interval) {
		return new Interval(prev.s, Math.max(prev.e, interval.e));
	}


	static class Interval{
		int s, e;
		Interval(int x, int y){
			s = x;
			e = y;
		}
		public boolean intersect(Interval that) {
			if(this.e >= that.s) return true;
			return false;
		}
		
		public String toString() {
			return "["+s + " , " + e +" ]"; 
		}
	}
	
	/*
public static void main(String[] args) throws IOException {

BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(in.readLine());
int []arr = new int[20002];
for (int i=0;i<20002;i++){
arr[i]=0;
}
int z = 10001;
for (int i=0;i<n;i++){
String[] arg = in.readLine().split(" ");
int a = Integer.parseInt(arg[0]);
int b = Integer.parseInt(arg[1]);
arr[a+z-1] = arr[a+z-1]-1;
arr[b+z] = arr[b+z]+1;	
}
int ans =0,s=0;
for (int i=0;i<20002;i++){
s = s+arr[i];
if(s<0 || s >0){
ans ++;
}
}
System.out.println(ans);
}

	 */

}
