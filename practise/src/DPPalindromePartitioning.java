import java.util.HashMap;

/*
 * https://www.interviewbit.com/problems/palindrome-partitioning-ii/
 */
public class DPPalindromePartitioning {

	HashMap<String, Integer> map;
    public int minCut(String s) {
      int ans = s.length()-1;
      map = new HashMap<>();
      ans = minPartitionAnother(s);
      return ans;
    }
    
    @SuppressWarnings("unused")
	private int minPartition(String s) {
    	if(s==null)return 0;
    	if(map.containsKey(s))return map.get(s);
    	if(isPallindrome(s))return 0;
    	int n = s.length();
    	int ans = n-1;
    	for(int i=1;i<n;i++) {
    		int x = minPartition(s.substring(0, i))+minPartition(s.substring(i,n));
    		ans  = Math.min(ans, 1+x);
    	}
    	map.put(s, ans);
    	return ans;
    }
    
    private int minPartitionAnother(String s) {
    	int n = s.length();
    	int dp[][]=new int[n][n];
    	for(int l = 1; l <= n; l++){
			for(int i = 0; i<= n-l ; i++){
				int j = i+l-1;
				dp[i][j] = l-1;
				if(isPallindrome(s.substring(i, j+1))) {
					dp[i][j] = 0;
				}else {
					for(int k = i; k<=j-1 ; k++){
						dp[i][j]=Math.min(dp[i][j], 1+dp[i][k]+dp[k+1][j]);
					}
				}
			}
    	}
    	//Util.printArray(dp);
    	return dp[0][s.length()-1];
    }

	private boolean isPallindrome(String s) {
		int i = 0;
		int j = s.length()-1;
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j))return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		DPPalindromePartitioning d = new DPPalindromePartitioning();
		System.out.println(d.minCut("ababb"));

	}

}
