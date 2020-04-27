
public class Permutation {

	/*
	 * a b c
	 * 
	 * Fix a call permutaion for remaing
	 * swap a with 
	 */
	static int count = 0;
	
	static void permute(char a[], int n){
		if(n < 0) {System.out.println(a);count++;}

		for(int i = n; i>=0 ; i--){
			//unswap char at n and i
			swap(a, i, n);
		    //call permutation
			permute(a, n-1);
			//unswap char at n and i
			swap(a, i, n);
		}
	}
	
	static void permuteWithDuplicates(char a[], int n){
		if(n < 0) {System.out.println(a);count++;}

		int x = 0;
		boolean swapped = true;
		for(int i = n; i>=0 ; i--){
			//unswap char at n and i
			if(a[i]!=a[n] && ((x& (1<<(a[i]-'a') )) == 0 ))	{
				swapped = true;
				x = x | (1 << (a[i]-'a'));
				swap(a, i, n);
			}
		    //call permutation
			if(swapped)
			permuteWithDuplicates(a, n-1);
			//unswap char at n and i
			if(a[i]!=a[n] && swapped) 	swap(a, i, n);
			swapped=false;
		}
	}
	
	static void swap(char a[], int i, int j) {
		//System.out.println("Swapping  " + a[i] +" and " + a[j]);
	   char temp = a[i];
	   a[i] = a[j];
	   a[j] = temp;
	}
	
	public static void main(String[] args) {
		//char a[] = {'a', 'b', 'c','a','b'};
		//permuteWithDuplicates(a, a.length-1);
		//System.out.println("Number of permutations = " + count);
		
		permutation("abc");

	}
	
	
	public static void permutation(String str) { 
	    permutation("", str); 
	}
	
	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}

}
