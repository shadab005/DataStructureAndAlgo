
public class Heap {

	
	static void swim(int a[], int k){
		while(k > 0 && a[(k-1)/2] < a[k]){
			swap(a, (k-1)/2, k);
			k=(k-1)/2;
		}
	}
	
	static void sink(int a[], int k, int high){
		while(2*k+1 <= high){
			int j = 2*k+1;
			if(j<high && a[j]<a[j+1])j++;
			if(a[k]>=a[j])break;
			else{
				swap(a, j, k);
			}
			k = j;
		}
	}
	
	static void heapSort(int a[]){
		buildHeap(a);//Building max heap
		int j = a.length-1;
		while(j>0){
			swap(a,0,j);
			sink(a,0, j-1);
			j--;
		}
	}
	
	
	private static void buildHeap(int[] a) {
		int high = a.length-1;
		int j = (high-1)/2;
		while(j>=0){
			sink(a,j, high);
			j--;
		}
	}

	public static void main(String[] args) {
		int a[] = { 7 , 6 , 5, 10, 8, 17, -1, 20, 2 };
		//printNumbers(a);
		Util.printArray(a);
		heapSort(a);
		Util.printArray(a);
		System.out.println("\nEnd of main");

	}
	
	static void swap(int a[], int i , int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	
}
