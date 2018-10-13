

/*
 * 
 * Floor: floor(x)= Largest integer less than or equal to x.  y = [x]. ex : [4.3] = 4
 * Ceil : ceil(x) = Least integer greater than or equal to x .  y = ⌈x⌉ . ex : ⌈4.3⌉ = 5
 */
public class BinarySearchCeilFloor {

	//Number of integer strictly less than key
	public static int rank(int a[], int key) {
	  
		int low = 0; 
		int high = a.length - 1;
		int mid = -1;
		while(low<=high) {
			mid = low + (high-low)/2;
			if(key < a[mid])high=mid-1;
			else if(key > a[mid]) low=mid+1;  
			else return mid;
		}
		return low;
		
	}
	
	//Array has to be sorted to apply binary search.
	public static  int floorIndex(int a[], int key) {
		int rank = rank(a, key);
		System.out.println("Rank = " + rank);
		if(rank < a.length && a[rank]==key)return rank;
		return rank-1;
	}
	
	//Array has to be sorted to apply binary search.
    public static int ceilIndex(int a[], int key) {
    	int rank = rank(a, key);
    	if(rank == a.length) return -1;
    	return rank;
	}
	
	public static void main(String[] args) {
	  	int a[] = {1,3,9,10,12,13};
	  	System.out.println(floorIndex(a, 8));
	  	System.out.println(ceilIndex(a, 2));
	  	System.out.println(ceilIndex(a, 4));
	  	System.out.println(ceilIndex(a, 10));
	  	System.out.println(ceilIndex(a, 15));
	}

}
