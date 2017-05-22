import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Bytelandian{
	
	public static void main(String[] args) throws Exception{
		
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	while(in.hasNext()){
		int n = in.nextInt();
		int q = n/12;
		int r = n%12;
		int total = 13*q+r;
		System.out.println(total);
	}
	in.close();
	}

}
