
public class SelectionBubbleInsertion extends Sort{
	
	/*
	 * In bubble sort largest element in pushed to bottom in each iteration
	 * Best-case performance	O(n)
	 * Average performance	 O(n2) // compares O(n2) and swaps O(n2)
	 * Worst-case performance	 O(n2)
	 * 
	 * In best case both bubble and insertion has same big-O
	 * but go with insertion due to less overheads.(No extra comparision of !sorted)
	 */
	public static void bubbleSort(int a[]){
		
		int n = a.length;
		boolean sorted = false; // this flag will indicate if the swapping has happened or not
		for(int i=0; i < n-1 && !sorted; i++){
			sorted = true;
			for(int j = 0; j < n-i-1 ; j++ ){
				if(a[j] > a[j+1]){
					//swap a[j-1] and a[j] if a[j-1] is greater
					int temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
					sorted = false;
				}
			}
		}
	}

	/*
	 * In insertion sort first size 1 array is sorted aad then we sort size 2 and then 3 and so on
	 * 
	 * works well for smaller number of elements but lot of movement is involved
	 * which is costly when the size of list grows Efficient for data sets that are already substantially sorted 
	 * Best case: O(n) when the array is already sorted 
	 * Avg case : O (n^2) // compares O(n2) and swaps O(n2)
	 * Worst case : O(n^2) 
	 * 
	 * O(nk) when each element in the input is no more than k places away from
	 * its sorted position i.e k-sorted array
	 * 
	 *                                                Selection        Insertion 
	 * (Average) Assignment of entries/Movement/Swaps 3n+O(1)          0.25n^2+O(n) 
	 * Comparison of keys                             0.5n^2+O(n)      0.25n^2+O(n)
	 * 
	 * Therefore selection is better for larger values of n with random entries
	 */
	public static void insertionSort(int a[]) {

		int n = a.length;
		for (int i = 1; i < n; i++) {
			int temp = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > temp) { // comparision
				a[j + 1] = a[j]; // data movement
				j--;
			}
			a[j + 1] = temp;
		}
	}

	/*
	 * In selection sort in each iteration minimun is found and then inserted at ith position (starting from i=0)
	 * Best Case Time Complexity : O(n2)
	 * Average Time Complexity : O(n2) // compares O(n2) and swaps O(n)
	 * Worst Case Time Complexity : O(n2) 
	 */
	public static void selectionSort(int a[]) {
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			int minpos = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[minpos]) {
					minpos = j;
				}
			}
			if (i != minpos) {
				int temp = a[i];
				a[i] = a[minpos];
				a[minpos] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int a[] = { 10, 40, 30, 99, 50, 80, 70, 90, 120, 110 };
		bubbleSort(a);
		printNumbers(a);
		System.out.println("Hello sort");
	}

	
}
