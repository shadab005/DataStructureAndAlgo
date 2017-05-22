import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Marbles {

	static long dp[][];
	static long ncR(int n,int r){
		if(r==0) return 1;
		if(r==1) return n;
		if(n==r) return 1;
		//System.out.println("n="+n+" r="+r);
		if(dp[n][r]!=0)return dp[n][r];
		if(r>n-r) {
			long y = ncR(n,n-r);
			dp[n][r]=y;
			dp[n][n-r]=y;
			return y;
		}
		long x = ncR(n-1,r)+ncR(n-1,r-1); //pascal formula
		dp[n][r]=x;
		//dp[n][n-r]=x;
		return x;
	}
	
	static long ncr(int n,int r){
		dp=new long[n+1][r+1];
		return ncR(n, r);
	}
/*	
	static long binomialCoeff(int n, int k)
    {
    long C[][] = new long[n+1][k+1];
    int i, j;
     
        // Calculate  value of Binomial Coefficient in bottom up manner
    for (i = 0; i <= n; i++)
    {
        for (j = 0; j <= Math.min(i, k); j++)
        {
            // Base Cases
            if (j == 0 || j == i)
                C[i][j] = 1;
      
            // Calculate value using previosly stored values
            else
                C[i][j] = C[i-1][j-1] + C[i-1][j];
          }
     }
      
    return C[n][k];
    }
	*/
	static long binomialCoeff(int n, int k)
    {
        long res = 1;
     
        // Since C(n, k) = C(n, n-k)
        if ( k > n - k )
            k = n - k;
     
        // Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
        for (int i = 0; i < k; ++i)
        {
        res *= (n - i);
        res /= (i + 1);
        }
     
        return res;
    }
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new java.io.BufferedReader(new InputStreamReader (System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=1;i<=t;i++){
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int r = k-1;
			//if(n-k<k-1)r=n-k;
			System.out.println(binomialCoeff(n-1,r));
		}
	}

}
