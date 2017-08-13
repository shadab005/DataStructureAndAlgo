package algo.strings;

public class KMPPatternMatching {

	/*
	 * Knuth-Morris-Pratt - Pattern Matching
	 * m=sizeof(pattern)
	 * n=sizeof(text)
	 * Time complexity : O(m+n)
	 * Space complexity: O(m)
	 */
	
	public static void main(String[] args) {
		String text = "bacbabababacaca";
        String pattern = "ababaca";
        System.out.println(new KMPPatternMatching().KMP(text.toCharArray(),pattern.toCharArray()));

	}
	
	public int KMP(char[] text, char[] pattern){
		int n = text.length;
		int m = pattern.length;
		int f[] = computePrefixTable(pattern);
		printArray(f);
		
		int i=0,j=0;
		while(i<n){
			if(text[i]==pattern[j]){
				if(j==m-1) return i-j;
				i++;
				j++;
			}else if(j!=0){
				j=f[j-1];
			}else{
				i++;
			}
		}
		return -1;
	}

	private int[] computePrefixTable(char[] pattern) {
		int m = pattern.length;
		int f[] = new int[m];
		f[0]=0;
		int j=0, i=1;
		while(i<m){
			if(pattern[i]==pattern[j]){
				f[i]=j+1;
				i++;
				j++;
			}else if(j!=0){
				j=f[j-1];
			}else{
				f[i]=0;
				i++;
			}
		}
		return f;
	}
	
	private static void printArray(int a[]){
		for(int i = 0 ; i< a.length; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

}
