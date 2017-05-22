
public class QuickSort extends Sort{

	/*
	 * Complexity:
	 * 
	 * Worst Case Time Complexity : O(n^2)
	 * Best Case Time Complexity : O(n log n)
	 * Average Time Complexity : O(n log n)
	 * 
	 * Comparisons C(0)=C(1)=0
	 * Partition function compares pivot with every other key in the list exactly once, therefore, n-1 comparisons
	 * If one of the sublist has r length and another n-r-1
	 * ∴ C(n) = n-1 + c(r)+ C(n-r-1)
	 * 
	 * Worst case: (when pivot fails to split the list i.e r=0 always
	 * C(n)=n-1+C(n-1),  ∴C(n)=0.5n^2-0.5n
	 * Number of swaps in worst case
	 * S(n) = n+1+S(n-1), ∴ S(n)= 1.5n^2+1.5n-1
	 * 
	 * In worst case therefore quicksort is worse than inserion sort and is therfore a disaster
	 * 
	 * Average case:
	 * Comaprisons
	 * When pivot is a p then C(n,p) = n-1 + C(p-1) + C(n-p)
	 * And when we average p from p=1 to p=n and dividing by n
	 * C(n) = n + 2/n(C(0)+C(1)+...C(n-1)),  C(n) = 1.39nlogn+O(n)
	 * Swaps
	 * Number of swaps made when partion is at p is p+1
	 * S(n,p) = (p+1) + S(p-1) + S(n-p)
	 * When we average p from p=1 to p=n and dividing by n 
	 * S(n) = n/2+3/2+2/n(S(0)+S(1)+...+S(n-1)), therefore, S(n) = 0.69logn+O(n)
	 * Note we can reduce swaps by 3 times if we use two index from start and end as we are doing below
	 * 
	 * 
	 * Comparison with mergesort:
	 * Quicksort in average case does 39% comparisons more than mergesort
	 */
	public static void quickSort(int a[], int low, int high){
		if(low<high)
		{
			int pivotpos = partition(a,low,high);
			quickSort(a,low,pivotpos-1);
			quickSort(a,pivotpos+1,high);
		}
	}
	
	private static int partition(int[] a, int low, int high) {
		
		swap(low,(low+high)/2,a);//pivot is the mid-point
		int pivot = a[low];
		int i=low+1, j=high;
		while(true)
		{
			while(i<high && pivot > a[i])i++;
			while(pivot<a[j])j--;
			if(i<j)swap(i,j,a);
			else{
				swap(low,j,a);
				return j;
			}
			
		}
	}
	
	public static int kthLargest(int a[], int k){
		int low = 0;
		int high = a.length-1;
		while(low<high){
			int pivotpos = partition(a, low, high);
			if(pivotpos>k-1) high = pivotpos-1;
			else if(pivotpos<k-1) low = pivotpos+1;
			else return a[k-1];
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 100, 40, 30, 99, 150, 80, 70, 90, 120, 110 };
		printNumbers(a);
		//quickSort(a,0,a.length-1);
		printNumbers(a);
		System.out.println("Hello sort");
		//4th largest is 80
		System.out.println(kthLargest(a, 4));

	}

}
