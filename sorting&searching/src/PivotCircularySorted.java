
public class PivotCircularySorted {

	public static void main(String[] args) {
		//int a[]={7,8,9,10,11,1,2,3};
		int a[] = {5, 6, 7, 8, 9, 10, 1, 2, 3, 4};
		//int a[] = {1,2,3};
		int i=findPivot(a);
		System.out.println("Pivot = " + i + " eclent = " + a[i]);
		//System.out.println(-1%4);

	}
	
	//7 1 3 4 5 6

	private static int findPivot(int[] a) {
		int n = a.length;
		int low = 0;
		int high = n-1;
		int mid = (low+high)/2;
		while(low<=high){
			if(a[low] < a[high]) return low;
		    mid = low+(high-low)/2;
		    if(a[mid] > a[(mid-1+n)%n] && a[mid] > a[(mid+1)%n]) return mid;
		    else if(a[mid] < a[low]) high = mid-1;
			else if(a[mid] > a[high]) low = mid+1;
			
		}
		return 0;
	}

}
