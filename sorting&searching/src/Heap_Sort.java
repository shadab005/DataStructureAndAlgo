
public class Heap_Sort extends Sort {
	/*
	 * Heap is a tree representation of array and the array can be thought as the breadfirst traversal of tree 
	 * For element at index k the child are at index at 2k+1 and 2k+2
	 * This can be easily seen by drawing the tree
	 * And property of heap is that each node is not less than any of its child (max-heap)
	 * 
	 * Complexity:
	 * Build heap:
	 * run n/2 (say m=[n/2]) times and calls insertHeap
	 * And in insertHeap no. of passes cannot exceed log(high/low)
	 * And each pass does through loop does at most two comparison and one assignment
	 * Total comparison therefore, 2(Σ)log(n/k) where k varies from 0 to m-1 = 2.5n
	 * Therefore building a heap takes linear time
	 * 
	 * Similarly in sorting phase total comparision is 2Σlogk where k varies from 2 to n = 2nlogn-3n
	 * This term dominates previous phase andd hence number of comparisons is 2nlogn+O(n)
	 * And similarly for one assignment per insertHeap, total assignments = nlogn+O(n)
	 * 
	 * Worst Case Time Complexity : O(n log n)
	 * Best Case Time Complexity : O(n log n)
	 * Average Time Complexity : O(n log n)
	 * 
	 * Heapsort guarantees nlogn complexity even in worst case and better in quick sort in this case
	 * on an average heapsort is somewhat slower than quicksort
	 * 
	 */
	/**                HEAP FUNCTIONS    **/
	// insert element at nth position in array and swim up to maintain the heap
	// n : position at which key is going to be inserted.
	public void insertInHeap(int a[], int key, int n) {
		a[n] = key;
		swim(a, n);
	}

	public static int deleteMaxFromHeap(int a[], int high) {
		int max = a[0];
		swap(0, high, a);
		sink(a, 0, high-1);
		return max;
	}

	// This will swim up the element till it is larger than its parent
	// Basically, swim funtion will push bigger elements up
	private static void swim(int a[], int k) {
		while (k > 0 && a[(k - 1) / 2] < a[k]) {
			swap((k - 1) / 2, k, a);
			k = (k - 1) / 2;
		}
	}

	private static void sink(int a[], int k, int high) {
		while (2 * k + 1 <= high) {
			int j = 2 * k + 1;
			if (j < high && a[j] < a[j + 1])
				j++;
			if (a[k] > a[j])
				break;
			swap(k, j, a);
			k = j;
		}
	}
	
	/**            END OF HEAP FUNCTIONS    **/
	
	/**            HEAP SORT FUNCTIONS    **/
	
	public static void heapSort(int a[]){
		buildHeap(a);
		int n = a.length;
		for(int i = n-1; i>0 ; i--){
			swap(0,i,a);
			sink(a, 0, i-1);
		}
	}
	
	public static void buildHeap(int[] a) {
		int n = a.length-1;
		for(int j=(n-1)/2;j>=0;j--){ 
			// j = n-1/2 will be the first element to have left child 
			//and node without child is already heap
			sink(a, j, n);
		}
	}

	/*
	 * Building Max heap in this Heap_Sort and all the method sink, swim is written
	 * accordingly to maintain maxheap
	 */
	public static void main(String[] args) {
		int a[] = { 7 , 6 , 5, 10, 8, 17, -1, 20, 2 };
		printNumbers(a);
		heapSort(a);
		printNumbers(a);
		System.out.println("\nEnd of main");

	}

	public static void printHeap(int a[], int low, int high) {
		System.out.print("Printing Heap with low index : " + low + " and high index : " + high);
		int i = low;
		int level = 1;
		while (i <= high) {
			if (i == level - 1) {
				System.out.println();
				level = level * 2;
			}
			System.out.print(a[i] + " ");
			i++;
		}
		System.out.println();
	}

}
