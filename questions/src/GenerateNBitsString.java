import java.util.LinkedList;
import java.util.Queue;

import algo.util.Util;

public class GenerateNBitsString {

	static Integer a[];
	static void binaryStringLengthN(int n){  
		//print all binary numbers upto n-bits and each binary number is n-bit long. ex: 0 is represented
		// as 0000 for n=4
		if(n==0) Util.printArrayReverse(a);
		else{
		a[n-1]=0;
		binaryStringLengthN(n-1);
		a[n-1]=1;
		binaryStringLengthN(n-1);
		}
	}
	
	static void allBinaryStringLength(int n, int last){
		//print all binary number upto n-bit and for n=4 0 is represented as 0 and not 0000 
		if(n==0) printFromLast(last);
		else{
		a[n-1]=0;
		allBinaryStringLength(n-1, last);
		a[n-1]=1;
		last = (last==0)? n-1 : last;
		allBinaryStringLength(n-1, last);
		}
	}
	
	static void printFromLast(int last){
		for(int i = last ; i>=0 ; i--){
			System.out.print(a[i]);
		}
		System.out.println();
	}
	
	
	static void generateBinaryNumbersFrom1toN(int n){ 
		//ex: for n = 5, binary numbers are :  1, 10, 11, 100, 101
		//One method is to loop over numbers from one to n and convert decimal to binary for each
		//Other method is to use queue
		Queue<String> queue = new LinkedList<>();
		queue.add("1");
		while(n!=0){
			String front = queue.remove();
			System.out.println(front);
			queue.add(front+"0");
			queue.add(front+"1");
			n--;
		}
		
	}
	
	
	public static void main(String args[]){
		int n = 3;
		a= new Integer[n];
		//allBinaryStringLength(n, 0);
		// 000, 001, 010, 011, 100, 101, 110, 111
		//System.out.println("End.. " + (60^13));
		generateBinaryNumbersFrom1toN(3);
	}
}

