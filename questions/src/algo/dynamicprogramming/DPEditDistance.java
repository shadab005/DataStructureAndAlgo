package algo.dynamicprogramming;
import algo.util.Util;

public class DPEditDistance {
	
	/*
	 * e(i,j) = Min { e(i-1, j) + d
	 *                e(i, j-1) + i
	 *                e(i-1, j-1) + r if(first[i]!=second[j])
	 *                e(i-1, j-1) if(first[i]=second[j]) 
	 *              }
	 *                
	 * d : deletion cost
	 * r : replacement cost
	 * i : insertion cost                
	 */
	static int editDistance(String first,String second){
		int m  = first.length();
		int n = second.length();
		int e[][] = new int[m+1][n+1];
		for(int i = 1; i<=m ; i++) e[i][0]=i;
		for(int j = 1; j<=n ; j++) e[0][j]=j;
		
		for(int i = 1; i <= m ; i++){
			for(int j = 1; j <= n ;j++){
				if(first.charAt(i-1)!=second.charAt(j-1)){
					e[i][j]=Util.minimum(e[i-1][j], e[i][j-1], e[i-1][j-1])+1;
				}else{
					e[i][j]=Util.minimum(e[i-1][j]+1, e[i][j-1]+1, e[i-1][j-1]);
				}
			}
		}
		
		Util.printArray(e);
		return e[m][n];
	}
	
	

	public static void main(String[] args) {
		System.out.println(editDistance("sitting", "kitten"));
		System.out.println(editDistance("geek", "gesek"));
	}

}
