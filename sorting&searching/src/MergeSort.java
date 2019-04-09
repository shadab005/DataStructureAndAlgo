
public class MergeSort extends Sort{

	/*
	 * Complexity
	 * T(n) = 2T(n/2) + n, n is for merging, therefore T(n) = nlogn-1.15n
	 * 
	 * Worst Case Time Complexity : O(n log n)
	 * Best Case Time Complexity : O(n log n)
	 * Average Time Complexity : O(n log n)
	 *  
	 *  low, high ->indices of first and last term
	 */
	public static void mergeSort(int a[], int low, int high) {
		int mid;
		if (low < high) {
			mid = (low + high) / 2;
			mergeSort(a, low, mid);
			mergeSort(a, mid + 1, high);
			simpleMerge(a, low, mid, high);
		}
	}

	public static void simpleMerge(int a[], int low, int mid, int high) {
		int c[] = new int[high - low + 1]; //This auxillary need not be created again and again
		int i = low, j = mid + 1, k = 0;
		while (i <= mid && j <= high) 
		{
			if (a[i] < a[j]) 
			{
				c[k] = a[i];
				i++;
				k++;
			} else 
			{
				c[k] = a[j];
				j++;
				k++;
			}
		}
		while (i <= mid) 
		{
			c[k] = a[i];
			i++;
			k++;
		}
		while (j <= high) 
		{
			c[k] = a[j];
			j++;
			k++;
		}
		for(i = 0 ; i <= high-low ; i++)
		{
			a[low+i] = c[i];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 100, 40, 30, 99, 150, 80, 70, 90, 120, 110 };
		mergeSort(a,0,a.length-1);
		printNumbers(a);
		System.out.println("Hello sort");

	}

}
