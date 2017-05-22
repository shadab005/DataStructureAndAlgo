
public class GeneratePowerSet {

	public static void printPowerSet(int a[]){
		int n = a.length;
		for(int i = 0 ; i < (1<<n) ; i++){
			//System.out.println("i="+Integer.toBinaryString(i));
			for(int count = 0; count < n ; count++){
				if((i&(1<<count)) != 0){
					System.out.print(a[count] + " ");
				}
			}
			System.out.println("");
		}
	}
	public static void main(String args[]){
		System.out.println("Start");
		int a[]={1,2,3};
		printPowerSet(a);
		System.out.println("End");
	}
}
