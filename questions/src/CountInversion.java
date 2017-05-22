import java.util.Scanner;

public class CountInversion {
	
	/*
	 * 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3). Ans : 3
	 * 2  7  4  1  3  9 . Ans : 1+3+2
	 * 
	 */
    // Count inversion is number of element smaller than the current element and after current element position.
	
	public static int merge(int a[], int low, int mid, int high){
		int count = 0;
		int c[] = new int[high - low + 1];
		int i = low;
		int j = mid+1;
		int k =0;
		System.out.println("low = "+ low + " mid="+ mid+" high="+high);
		while(i<=mid && j <=high){
			if(a[i]>a[j]){
				c[k]=a[j];
				j++;
				k++;
			}else{
				System.out.println("k="+k+" i="+i);
				c[k]=a[i];
				i++;
				k++;
				count=count+(j-mid-1);
			}
		}
		while (j <= high) 
		{
			c[k] = a[j];
			j++;
			k++;
		}
		while (i <= mid) 
		{
			if(a[i]>a[high])count=count+(j-mid-1);
			c[k]=a[i];
			i++;
			k++;
		}
		for(i = 0 ; i <= high-low ; i++)
		{
			a[low+i] = c[i];
		}
		
		return count;
	}
	public static int countInversion(int a[], int low, int high){
		if(low<high){
			int mid=low+(high-low)/2;
			int lcount=countInversion(a, low, mid);
			int rcount=countInversion(a, mid+1, high);
			int mergecount = merge(a, low, mid, high);
			return lcount+rcount+mergecount;
		}
		return 0;
	}
	public static void main(String[] args) {
		int a[] = {1, 20, 6, 4, 5};
		/*int b[] = { 2, 4, 1, 3, 5};
		a=b;*/
		Scanner sc = new Scanner(System.in);
		int t = 1;;//sc.nextInt();
		//int[] a = new int[100];
		while (t > 0){
			int n = 5;//sc.nextInt();
			//for (int i = 0; i < n; i++) a[i] = sc.nextInt();
			System.out.println(countInversion(a, 0, n-1));
			t--;
		}
		sc.close();
		
	}

}
