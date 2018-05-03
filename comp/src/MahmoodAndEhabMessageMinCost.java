import java.util.HashMap;
import java.util.Scanner;

public class MahmoodAndEhabMessageMinCost {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int m = in.nextInt();
		
		HashMap<String, Integer> map = new HashMap<>();
		
		String input[] = new String[n];
		for(int i=0;i<n;i++) {
			input[i]= in.next();
			map.put(input[i],i);
		}
		
		int cost[] = new int[n];
		for(int i=0;i<n;i++) {
			cost[i]= in.nextInt();
		}
		
		for(int i=0;i<k;i++) {
			int c = in.nextInt();
			int val[] = new int[c];
			int j = 0;
			int minCost = Integer.MAX_VALUE;
			while(c-->0) {
				val[j] = in.nextInt();
				minCost = Math.min(minCost, cost[val[j]-1]);
				j++;
			}
			for(int x:val) {
				cost[x-1]=minCost;
			}
		}
		
		long ans = 0;
		String word = null;
		while(m-->0) {
			word = in.next();
			ans+=cost[map.get(word)];
		}
		System.out.println(ans);
		in.close();

	}

}
