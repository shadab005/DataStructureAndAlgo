import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MakeThemOdd {

	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0) {
			HashMap<Integer, Integer> map = new HashMap<>();
			int n = in.nextInt();
			int a[] = new int[n];
			for(int i = 0; i < n ;i ++) {
				a[i] = in.nextInt();
				
				int x = 0;
				while(a[i]%2==0) {
					a[i] = a[i]/2;
					x++;
				}
				
				map.put(a[i], Math.max(x, map.getOrDefault(a[i], 0)));
			}
			
			int sum = map.values().stream().collect(Collectors.summingInt(Integer::intValue));
			System.out.println(sum);
					
		}
		in.close();

	}

}
