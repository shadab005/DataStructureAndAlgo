import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

class RoadAndLibrary {

	static int city[];
	static int count[];
	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		while(t-->0){
			int n = in.nextInt();
			int m = in.nextInt();
			int lCost = in.nextInt();
			int rCost = in.nextInt();
			if(lCost <= rCost){
				for(int i=1;i<=m;i++){
				   in.next();
				   in.next();
				}
				long answer  = n*1L*lCost;
				System.out.println(answer);
			}else{
				city = new int[n + 1];
				count = new int[n + 1];	
				for(int i = 1; i<=n ; i++){
					city[i]=i;
					count[i]=0;
				}
				for(int i=1;i<=m;i++){
					union(in.nextInt(), in.nextInt());
				}
				solve(n,lCost,rCost);
			}
		}
		in.close();
	}

	private static void solve(int n, int costLib , int costRoad) {
		
		HashSet<Integer> s = new HashSet<>(n); 
		for(int i = 1; i<= n ;i++){
			s.add(root(i));
		}
		long total = 0;
		for(Integer root : s){
			total+=(costLib+count[root]*1L*costRoad);
		}
		System.out.println(total);
		
	}
	

	public static void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if(i==j) return;
		if(count[i]<count[j]){
			city[i]=j;
			count[j]=count[i]+count[j]+1;
		}else{
			city[j]=i;
			count[i]=count[i]+count[j]+1;
		}
	}

	private static int root(int i){
		while(city[i]!=i){
			city[i]=city[city[i]];
			i=city[i];
		}
		return i;
	}
	
	

}
