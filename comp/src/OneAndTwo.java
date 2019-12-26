import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OneAndTwo {

	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0) {
			String s = in.next();
			List<Integer> a = new ArrayList<>();
			int count = 0;
			int i = 0, j = i+2;
			while(i<s.length()-2) {
				j = i + 2;
				if(s.substring(i, j+1).equals("one")) {
					count++;
					a.add(j+1);
					i = j+1;
				} else if(s.substring(i, j+1).equals("two")) {
					int k = j+2;
					if(k<s.length() && s.substring(j, k+1).equals("one")) {
						count++;
						a.add(j+1);
						i = k+1;
					} else {
						count++;
						a.add(j+1);
						i = j+1;
					}
				} else {
					i = i+1;
				}
			}
			System.out.println(count);
			for(int z:a) {
				System.out.print(z + " ");
			}
			System.out.println();
		}
		in.close();
	}
	
	
	static int getPatternCount(String s, String pattern) {
		return  s.split(pattern, -1).length  - 1;
	}

}
