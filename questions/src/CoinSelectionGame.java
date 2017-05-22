
public class CoinSelectionGame {
	
	
	static int maxCoinCollection(int a[], int i, int j, int N){
		if(i>=j) return 0;
		int selectedCount = N-(j-i+1);
		if(selectedCount%2==0){
			return Math.max(a[i]+maxCoinCollection(a, i+1, j, N), a[j]+maxCoinCollection(a, i, j-1,N));
		}else{
			return Math.min(maxCoinCollection(a, i+1, j, N), maxCoinCollection(a, i, j-1,N));
		}
		
	}
	
    /*
     * MV(i, j) = Max { Vi + Min{MV(i+2,j), MV(i+1, j-1)} , Vi + Min{MV(i+1,j-1), MV(i, j-2)}}
     */
	static int maxCoin(int a[], int i, int j){
		if(i>j) return 0;
		if(i==j) return a[i];
		return Math.max(a[i]+Math.min(maxCoin(a,i+2,j), maxCoin(a, i+1, j-1	)), 
				a[j]+Math.min(maxCoin(a, i+1, j-1), maxCoin(a, i, j-2)));
	}
	
	static int maxChain(int a[]){
		int n = a.length;
		int dp[][]=new int[n][n];
		for(int l=1;l<=n;l++){
			for(int i=0;i<=n-l;i++){
				int j=i+l-1;
				if(i==j)dp[i][j]=a[i];
				else if(l==2) dp[i][j]=Math.max(a[i], a[j]);
				else{
					dp[i][j]=Math.max(a[i]+Math.min(dp[i+2][j], dp[i+1][j-1]), a[j]+Math.min(dp[i+1][j-1], dp[i][j-2]));
				}
			}
		}
		Util.printArray(dp);
		return dp[0][n-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {5,3,7,10};
		int b[]= {8, 15, 3, 7};
		int c[] = {20, 30, 2, 2, 2, 10};
		int d[] = {2, 2, 2, 2};
		int e[] = {3, 9, 1, 2};
		int coins []  =  { 6, 9, 1, 2, 16, 8};
		System.out.println(maxCoinCollection(a, 0, a.length-1, a.length));
		System.out.println(maxCoinCollection(b, 0, b.length-1, b.length));
		System.out.println(maxCoinCollection(c, 0, c.length-1, c.length));
		System.out.println(maxCoinCollection(d, 0, d.length-1, d.length));
		System.out.println(maxCoinCollection(e, 0, e.length-1, e. length));
		System.out.println(maxCoinCollection(coins, 0, coins.length-1, coins.length));
		System.out.println("=========================================");
		System.out.println(maxCoin(a, 0, a.length-1));
		System.out.println(maxCoin(b, 0, b.length-1));
		System.out.println(maxCoin(c, 0, c.length-1));
		System.out.println(maxCoin(d, 0, d.length-1));
		System.out.println(maxCoin(e, 0, e.length-1));
		System.out.println(maxCoin(coins, 0, coins.length-1));
		
		System.out.println("===========================================");
		/*System.out.println(maxChain(a));
		System.out.println(maxChain(b));
		System.out.println(maxChain(c));
		System.out.println(maxChain(d));
		System.out.println(maxChain(e));*/
		System.out.println(maxChain(coins));

	}

}
