import java.util.Scanner;

class KthSmallest {

	public static void main(String[] args) {
		/*int n = 6;
		int a[] = {7,10, 4, 3, 20, 15};
		int k = 3;	
		System.out.println(kSmallest(a, a.length, 1));
		System.out.println(kSmallest(a, a.length, 2));
		System.out.println(kSmallest(a, a.length, 3));
		System.out.println(kSmallest(a, a.length, 4));
		System.out.println(kSmallest(a, a.length, 5));
		System.out.println(kSmallest(a, a.length, 6));
		System.out.println("End..");
		*/
		int a[] = new int[1000];
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
			int n = in.nextInt();
			for(int i = 0 ; i<n;i++)a[i]=in.nextInt();
			int k = in.nextInt();
			System.out.println(kSmallest(a, n, k));
		}
		in.close();

	}
	
	/*
	 * Returns the partition index
	 */
	static int parition(int a[], int low, int high){
		swap(a,low,(low+high)/2);
		int pivot = a[low];
		int i = low+1;
	    int j=high;
		while(true){
			while(i<= j && a[i] <= pivot)i++;
			while(j >= i && a[j] >= pivot)j--;
			if(i<j)swap(a,i,j);
			else{
				swap(a,low,j);
				return j;
			}
		}
	}
	
	static int kSmallest(int a[], int size, int k){
		int low=0;
		int high = size-1;
		while(low<high){
			//System.out.println("low="+low+" high="+high);
			//Util.printArray(a);
			int pivotpos = parition(a, low, high);
			//Util.printArray(a);
			//System.out.println(pivotpos);
			if(pivotpos<k-1)low=pivotpos+1;
			else if(pivotpos>k-1)high=pivotpos-1;
			else{
				low=pivotpos;
				break;
			}
		}
		return a[low];
	}
	static int kSmallest(int a[], int low, int high, int k){
		//System.out.println("low="+low+" high="+ high +" k="+k);
    //  Util.printArray(a);
		if(low<=high){
			int pivotpos = parition(a, low, high);
	//Util.printArray(a);
		//System.out.println("Pivotpos="+pivotpos);
			if(pivotpos < low+k-1){
				int left = kSmallest(a,pivotpos+1,high,low+k-pivotpos-1);
				if(left!=-1)return left;
			}else if(pivotpos > low+k-1){
				int right = kSmallest(a,low,pivotpos-1,k);
				if(right!=-1)return right;
			}else{
				return a[pivotpos];
			}
		}
		return -1;
	}
	
	static void swap(int a[], int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
