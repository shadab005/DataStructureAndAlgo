
/*
* Counting sort is a sorting technique based on keys between a specific range. 
* It works by counting the number of objects having distinct key values (kind of hashing).
* 
* Complexity : O(n) 
*/
			
public class CountingSort {
	
	static void countSort(char a[]){
    	int n = a.length;
    	char count[] = new char[256]; //256 characters
    	for(int i=0;i<n;i++)count[a[i]]++;
    	for(int i=1;i<256;i++)count[i]+=count[i-1];
    	
    	char[] output = new char[n];
    	for(int i=0;i<n;i++){
    		output[count[a[i]]-1] = a[i];
    		count[a[i]]--;
    	}
    	for(int i=0;i<n;i++)a[i]=output[i];
    }
	
	public static void main(String[] args) {
		char a[] = "bbabbaac".toCharArray();
		int x= 'a';
		System.out.println(x);
		countSort(a);
		for(int i=0;i<a.length;i++)System.out.print(a[i]+" ");
		System.out.println();
		
		System.out.printf("0-9 = %d-%d , A-Z = %d-%d , a-z = %d-%d",'0'-0, '9'-0,'A'-0, 'Z'-0, 'a'-0,'z'-0);

	}

}
