
public class Sort {
	
	public static void swap(int i, int j, int[]a){
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	public static void printNumbers(int[] input) {

		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println("");
	}

}
