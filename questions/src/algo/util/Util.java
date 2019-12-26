package algo.util;

public class Util {

	public static <T> void printArrayReverse(T a[]) {
		for(int i = a.length-1; i>=0 ; i--){
			System.out.print(a[i]);
		}
		System.out.println();
	}
	
	public static <T> void printArray(T a[]) {
		for(int i = 0 ; i< a.length; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static <T> void intialize(T a[], T x) {
		for(int i = 0 ; i< a.length; i++){
			a[i]=x;
		}
	}
	
	public static void printArray(int a[]){
		for(int i = 0 ; i< a.length; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static void printArray(char a[]){
		for(int i = 0 ; i< a.length; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static void printArray(int a[], String delimeter){
		for(int i = 0 ; i< a.length-1; i++){
			System.out.print(a[i]+ delimeter);
		}
		System.out.print(a[a.length-1]);
		System.out.println();
	}
	
	public static void printArray(int a[][]){
		int m  = a.length; //Number of rows
		int n  = a[0].length; //Number of columns
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void printArray(char a[][]){
		int m  = a.length; 
		int n  = a[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void printArray(long a[][]){
		int m  = a.length;
		int n  = a[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void printArray(boolean a[][]){
		int m  = a.length;
		int n  = a[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int minimum(int... a){
		int min = Integer.MAX_VALUE;
		for(int x : a){
			if(min>x)min=x;
		}
		return min;
	}
	
	/* Sorting array b based on array a in desc
	 * Arrays.sort(b, new Comparator<Integer>() {
		public int compare(Integer i, Integer j){
			return a[j]-a[i];
		}
	});*/

}
