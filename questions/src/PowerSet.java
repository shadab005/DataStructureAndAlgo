import java.util.ArrayList;

public class PowerSet {

	/*
	 * Recursive solution
	 */
	private static ArrayList<Integer> subsetList;
	private static void printPowerSet(int a[], int index){
		if(index == a.length){
			if(subsetList.isEmpty())System.out.print("Empty Set");
			for(int x : subsetList)System.out.print(x + " ");
			System.out.println();
			return;
		}
		Integer z = a[index];
		printPowerSet(a,index+1); // Recursive call when element at index is not the part of subset
		subsetList.add(z);
		printPowerSet(a,index+1); // Recursive call with element at index is in subset
		subsetList.remove(z);
	}
	static void generatePowerSet(int a[]){
		subsetList = new ArrayList<>();
		printPowerSet(a, 0);
	}
	
	/*
	 * Iterative solution
	 */
	
	static void powerSet(int a[]){
		int n = a.length;
		for(int i = 0; i < (1<<n); i++){
			for(int j = 0; j<i; j++){
				//System.out.println("i= " + i +" j = " + j);
				if(((1<<j)&i)!=0){
					System.out.print(a[j]+" ");
				}
			}
			System.out.println();
		}
	}	     
	
/*	i = 101
	j 1
	j 10
	j 100*/        
	public static void main(String[] args) {
		int a[]  = { 4, 5, 6};
		//generatePowerSet(a); recursive 
		powerSet(a);
		//System.out.println((1<<1));
		//System.out.println((1<<1)&2);
		

	}

}
