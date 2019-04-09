
public class BinarySearch {
	
	
	public static int search(int a[], int key) {
		
		int low = 0, high = a.length-1;
		int mid = (low+high)/2;
		while(low<=high) {
			mid = (low+high)/2;
			if(a[mid] == key) return mid;
			else if(a[mid] > key) high = mid-1;
			else low = mid+1;
		}
		return -1;
	}

	public static void main(String[] args) {
		
		int a[] = {5, 10, 18, 24, 32};
		System.out.println(search(a, 32));

	}

}
