import algo.util.Util;

public class TravellingSalesmanPerson {

	int INF = 100000000;  
	int shortestTSPdistance(int dist[][]) {  
	    int n = dist.length; 
	    int lim = 1 << n;  
	    int dp[][] = new int[lim][n]; 
	    for(int i=0;i<lim;i++) {
	    	for(int j = 0; j<n;j++) {
	    		dp[i][j]=INF;
	    	}
	    }
	    for (int i = 0; i < n; i++) {  
	        dp[1 << i][i] = 0;    // base case of visiting just 1 city  
	    }  
	    for (int mask = 0; mask < lim; mask++) {  
	    	System.out.println("Mask = " + mask + " : " + Integer.toBinaryString(mask));
	        for (int last = 0; last < n; last++) {  
	        	System.out.println("last " + last);
	            if ((mask & (1 << last)) == 0) {      
	                continue;  
	            }  
	            for (int curr = 0; curr < n; curr++) {
	            	System.out.println("curr " + curr);
	                if ((mask & (1 << curr)) == 0) {  
	                    continue;  
	                }  
	                int otherMask = mask ^ (1 << curr);  
	                System.out.println("Other mask : " + otherMask +" : " + Integer.toBinaryString(otherMask));
	                dp[mask][curr] = min(dp[mask][curr], dp[otherMask][last] + dist[last][curr]);  
	                System.out.println("dp["+mask+"]["+curr+"]="+dp[mask][curr]);
	            }  
	        }  
	    }  
	    Util.printArray(dp);
	    int ans = INF;  
	    for (int i = 0; i < n; i++) {  
	        ans = min(ans, dp[lim - 1][i]+dist[i][0]);  
	    }  
	    return ans;  
	}
	
	int min(int x, int y){
		if(x<y)return x;
		else return y;
	}
	
	public static void main(String[] args) {
		int d[][] = {
				{0,10,15,20},
				{5,0,9,10},
				{6,13,0,12},
				{8,8,9,0}
		};
		TravellingSalesmanPerson t = new TravellingSalesmanPerson();
		System.out.println(t.shortestTSPdistance(d));

	}

}
