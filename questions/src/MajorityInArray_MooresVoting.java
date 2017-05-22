
public class MajorityInArray_MooresVoting {
	
	/*Moore's Voting Algorithm */
	/*
	 * The algorithm works in two phase.
	 * First, it finds the probable candidate for majority (i.e count > n/2)
	 * Then, it versifies by traversing the array once again
	 * Complexity : O(n) 
	*/
	
	/*
	 * Note : Moore's voting algorithm is not meant to find the max frequency in an array
	 */
	static int findMaxFreq(int a[], int size){
		int maj_index = 0 ;
		int count = 1;
		for(int i = 1; i < size ; i++){
			if(a[maj_index] == a[i]) count++;
			else count--;
			
			if(count == 0){
				maj_index = i;
				count = 1;
			}
		}
		return a[maj_index];
	}

	public static void main(String args[]) {
       int a[] = {1,2,3,2,2,4,5,6,7};
       System.out.println(findMaxFreq(a, a.length));
	}
}
