import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class EasyUberCount {

	private static class Tuple{
		int startIndex, endIndex;
		Tuple(int s, int e){
			startIndex = s;
			endIndex = e;
		}
		public boolean collide(Tuple that) {
			if(this.endIndex < that.startIndex) return false;
			else return true;
		}
		public  static Tuple mix(Tuple prev, Tuple interval) {
			return new Tuple(prev.startIndex, Math.max(prev.endIndex, interval.endIndex));
		}
	}
	
	public static void main(String[] args) {
	   Scanner in = new Scanner(System.in);
	   int n = in.nextInt();
	   ArrayList<Tuple> l = new ArrayList<>();
	   for(int i = 0;i<n;i++) {
		   l.add(new Tuple(in.nextInt(), in.nextInt()));
	   }
	   solve(l);
	   in.close();

	}
	
	
	private static void solve(ArrayList<Tuple> listOfTuples) {
		listOfTuples.sort(startComparator());
		ArrayList<Tuple> mergeTuple = new ArrayList<>();
		Tuple preTuple = listOfTuples.get(0);
		for(int currentTuple=1;currentTuple<listOfTuples.size();currentTuple++) {
			if(preTuple.collide(listOfTuples.get(currentTuple))) {
				preTuple = Tuple.mix(preTuple,listOfTuples.get(currentTuple)); 
			}else {
				mergeTuple.add(preTuple);
				preTuple = listOfTuples.get(currentTuple);
			}
		}
		mergeTuple.add(preTuple);
		int answer = 0;
		for(Tuple tuple : mergeTuple) {
			answer+=(tuple.endIndex-tuple.startIndex+1);
		}
		System.out.println(answer);
		
	}
	
	private static Comparator<Tuple> startComparator(){
		Comparator<Tuple> byStart = (o1,o2)->o1.startIndex-o2.startIndex;
		return byStart;
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
