package codeforces;

import java.util.Scanner;

public class BinaryProtocol {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int n = N - 1;
		String s = in.next();
	//	System.out.println(s);
		
		int zeroCountInEnd = 0;
		while(n>=0 && s.charAt(n)=='0'){
			zeroCountInEnd++;
			n--;
		}
		
		//System.out.println(zeroCountInEnd);
		
		int length = N - zeroCountInEnd;
		//System.out.println("Length " + length);
		
		int oneCount = 0;
		int zeroCount = 0;
		for(int i = 0 ; i < length; i++){
			if(s.charAt(i)=='1'){
				oneCount++;
				if(zeroCount-1>0)printZeroes(zeroCount-1);
				zeroCount=0;
			}else{
				
				if(oneCount>0)
				System.out.print(oneCount);
				oneCount = 0;
				zeroCount++;
			}
		}
		if(oneCount>0)
		System.out.print(oneCount);
		printZeroes(zeroCountInEnd);	
		
		in.close();

	}

	private static void printZeroes(int i) {
		while(i-->0){
			System.out.print(0);
		}
		
	}

}
