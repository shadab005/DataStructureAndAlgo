
/*
 * https://www.interviewbit.com/problems/arrange-ii/
 */
public class DPArrangeWhiteAndBlackHorse {
	
	String s;
	Integer dp[][];

	public int arrange(String s, int k) {
		this.s = s;
		dp= new Integer[s.length()+1][k+1];
		int ans = getMinArrangement(s.length(), k);
		if(ans == Integer.MAX_VALUE)return -1;
		return ans;
	}
	
	//n horses k stables
	public int getMinArrangement(int n, int k) {
		if(n==0 && k == 0)return 0;
		if(n==0 || k == 0)return Integer.MAX_VALUE;
		if(k<0)return Integer.MAX_VALUE;
		if(dp[n][k]!=null)return dp[n][k]; 
		//System.out.println("n="+n+" k="+k);
		int ans = Integer.MAX_VALUE;
		int nWhite = 0,nBlack=0;
		for(int i=1;i<=n-k+1;i++) {
			
			if(s.charAt(n-i)=='B')nBlack++;
			else nWhite++;
			int x = getMinArrangement(n-i, k-1);
			if(x!=Integer.MAX_VALUE)
			ans = Math.min(ans, nWhite*nBlack+x);
		}	
		dp[n][k]=ans;
		return ans;
	}
	
	public static void main(String[] args) {
		DPArrangeWhiteAndBlackHorse d = new DPArrangeWhiteAndBlackHorse();
		System.out.println(d.arrange("WWWBBWWB", 3));

	}

}
