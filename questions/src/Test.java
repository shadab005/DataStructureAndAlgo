import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Test {

	static Map<Integer,Long> mem;
	static long solve(int n){
		if(n<12)return n;
		if(mem.get(n)!=null)return mem.get(n);
		else {
			long x =  solve(n/2)+solve(n/3)+solve(n/4);
			mem.put(n, x);
			return x;
		}
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		while(in.hasNext()){
			mem = new HashMap<>();
			int n = in.nextInt();
			System.out.println(solve(n));
		}
		in.close();
	}

}
