
public class StringPermutation {

	static String s = "abc";
	static Character[] perm = {'a','b','c', 'd'};
	static void kString(int n, int k){
		if(k==0)
		{
			Util.printArrayReverse(perm);
			return;
		}
		for(int i = 0; i < n ; i++)
		{
			perm[k-1] = s.charAt(i);
			kString(n,k-1);
		}
	}
	
	static void permutation(int n){
		if(n==0){
			Util.printArray(perm);
			return;
		}
		int k = n-1;
		for(int i=0; i< n; i++){
			char c = perm[k-i];
			perm[k-i] = perm[k];
			perm[k]=c;
			permutation(n-1);
			c=perm[k];
			perm[k]=perm[k-i];
			perm[k-i]=c;
		}
	}
	public static void main(String[] args) {
		//int k = 3;
		//perm = new Character[k];
		//kString(s.length(), k);
		permutation(perm.length);
	}

}
