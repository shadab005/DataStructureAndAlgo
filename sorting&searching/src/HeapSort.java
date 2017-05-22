
public class HeapSort extends Sort {
	
	/*
	 * Heap is a tree representation of array and the array can be thought as the breadfirst traversal of tree 
	 * For elemet at index k the child are at index at 2k+1 and 2k+2
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

	public static void heapSort(int a[]){
		buildHeap(a); // O(2.5n) linear
		int n = a.length;
		int current;
		for(int i = n-1; i>0 ; i--){
			current = a[i];
			// first element is the largest and in each loop the first element is pushed to end,
			// which will eventually sort the array
			a[i] = a[0]; 
			insertHeap(a,0,i-1,current); //i-1 is the last index of the heap
		}
	}
	

	public static void insertHeap(int a[],int low, int high, int element){ // takes O(log(high/low))
		int vacantPosition = low;
		int leftChildIndex = 2*vacantPosition+1;
		while(leftChildIndex <= high){
			if(leftChildIndex<high && a[leftChildIndex] < a[leftChildIndex+1]){
				leftChildIndex = leftChildIndex + 1;
			}
			if(element > a[leftChildIndex]) break;
			else{
				a[vacantPosition] = a[leftChildIndex];
				vacantPosition = leftChildIndex;
				leftChildIndex = 2*leftChildIndex+1;
			}			
		}
		a[vacantPosition] = element;
	}
	
	public static void buildHeap(int[] a) {
		int n = a.length-1;
		for(int j=(n-1)/2;j>=0;j--){ // j = n-1/2 will be the first element to have left child and node without child is already heap
			insertHeap(a, j, n, a[j]);
		}
	}
	
	
	
	public static void main(String[] args) {
		
		int a[] = { 4,5,6,8,10,17,18,20,24};
		printNumbers(a);
		heapSort(a);
		printNumbers(a);
		System.out.println("\nEnd of main");

	}
	
	public static void printHeap(int a[], int low, int high){
		System.out.print("Printing Heap with low index : " + low + " and high index : " + high);
		int i = low;
		int level = 1;
		while(i<=high){ 
			if( i== level-1){
				System.out.println();
				level = level*2;			
			}
			System.out.print(a[i]+ " ");
			i++;
		}
		System.out.println();
	}

}
