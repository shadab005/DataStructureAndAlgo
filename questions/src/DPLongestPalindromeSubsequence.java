public class DPLongestPalindromeSubsequence {
	
	static int longestPallindromeSubsequence(char s[]){
		System.out.println(s);
		int n = s.length;
		int len[] = new int[n];
		int lastindex[] = new int [n];
		for (int i = 0; i < lastindex.length; i++) {
			len[i]=1;
			lastindex[i]=i;
		}
	/*	Util.printArray(len);
		Util.printArray(lastindex);*/
		int max = 1;
		int inc=1;
		for(int l = 2 ; l <= n ; l=l+inc){
			//System.out.println("Last increment value : " + inc);
			inc=1;
			//boolean changed = false;
			System.out.println("Solving for length " + l );
			Util.printArray(len);
			Util.printArray(lastindex);
			for(int i=0;i<n;i++){
				int lengthI = len[i];
				for(int k = i+1; k < n ;k++){
					if(len[k]>=l-1){
						if(s[i]==s[lastindex[k]] || s[i]==s[lastindex[k]-1]){
							//System.out.println("i="+ i + " k=" +k + " Len[k]= " + len[k] + " Lastindex[k]="+lastindex[k]);
							int count=countChar(s[i], s, k, lastindex[k]);
							if(count>=l-1 && len[i]==lengthI){
								//changed=true;
								//if(count==len[k]){
								//System.out.println("i="+i+" count="+count);
								    if(len[i]<count+1){
									
									if(s[i]==s[lastindex[k]]){
										len[i]=count+1;
										lastindex[i]=lastindex[k];
									}
									else{
										len[i]=len[k];
										lastindex[i]=lastindex[k]-1;
									}
								    }
								//}
								/*else{
									
								}
								if(len[k]%2==1){
									
								}else{
									len[i]=len[k]+1;
									
								}*/
								//inc=1;
								max=Math.max(max, len[i]);
								break;
							}
						}
						int searchIndex = search(s[i], s, lastindex[k]+1, n);
						if(searchIndex!=-1 && len[k]==l-1){
							//System.out.println("i="+i);
							if(len[i]==lengthI){
								//System.out.println("ii="+ i + " k=" +k + " Len[k]= " + len[k] + " Lastindex[k]="+lastindex[k]);
								//System.out.println("search index = " + searchIndex);
								//changed=true;
								len[i]=len[k]+2;
								lastindex[i]=searchIndex;
								max=Math.max(max, len[i]);
							//	inc=2;
							}else{
								//System.out.println("iii="+ i + " k=" +k + " Len[k]= " + len[k] + " Lastindex[k]="+lastindex[k]);
								if(lastindex[i]>searchIndex)lastindex[i]=searchIndex;
							}
						}
					}
				}
			}
			/*if(changed){
				max=l;
			}
			else break;*/
		}
		/*System.out.println("Solved");
		Util.printArray(len);
		Util.printArray(lastindex);*/
		return max;
	}

	static int LPS(char s[]){
		int n = s.length;
		int dp[][]= new int[n+1][n];
		for(int i = 0; i < n ; i++){//for lenght = 1 
			dp[1][i]=1;
		}
		for(int l=2 ; l<=n ;l++){
			for(int i=0;i<=n-l;i++){
				int j = i+l-1;
				if(s[i]!=s[j]){
					dp[l][i]=Math.max(dp[l-1][i],dp[l-1][i+1]);
				}else{
					dp[l][i]=Math.max(dp[l-2][i+1]+2, dp[l-1][i]);
				}
			}
		}
		//Util.printArray(dp);
		return dp[n][0];
	}
	
	static int LPSSpaceEfficient(char s[]){
		int n = s.length;
		int dp[][]= new int[2][n];
		for(int i = 0; i < n ; i++){//for lenght = 1 
			dp[1][i]=1;
		}
		for(int l=2 ; l<=n ;l++){
			for(int i=0;i<=n-l;i++){
				int j = i+l-1;
				if(s[i]!=s[j]){
					dp[l%2][i]=Math.max(dp[(l+1)%2][i],dp[(l+1)%2][i+1]);
				}else{
					dp[l%2][i]=Math.max(dp[l%2][i+1]+2, dp[(l+1)%2][i]);
				}
			}
		}
		//Util.printArray(dp);
		return Math.max(dp[0][0],dp[1][0]);
	}
	
	private static int countChar(char c, char s[], int start, int end){
		int count=0;
		for(int i = start ; i<=end ;i++){
			if(s[i]==c)count++;
		}
		return count;
	}
	
	private static int search(char c, char[] s, int i, int n) {
		if(i >= n) return -1;
		for(int j = i; j < n ; j++){
			if(s[j]==c) return j;
		}
		return -1;
	}


	public static void main(String[] args) {
		char s1[] = {'B', 'B', 'B', 'A', 'B'};
		char s2[] = {'B', 'B', 'A', 'B', 'C', 'B', 'C', 'A', 'B'};
		//abaababaab
		//System.out.println(s);
		//"BBABCBCAB".toCharArray();
	/*	System.out.println(longestPallindromeSubsequence(s));
		System.out.println(longestPallindromeSubsequence("BABCBOB".toCharArray()));
		System.out.println(longestPallindromeSubsequence("abaababaab".toCharArray()));
		System.out.println(longestPallindromeSubsequence("abababaabababaabababa".toCharArray()));*/
		System.out.println(LPSSpaceEfficient("ababbaba".toCharArray()));
		System.out.println(LPSSpaceEfficient("abababaabababaabababa".toCharArray()));
		System.out.println(LPSSpaceEfficient("BABCBOB".toCharArray()));
		System.out.println(LPSSpaceEfficient(s1));
		System.out.println(LPSSpaceEfficient(s2));
	}

}
