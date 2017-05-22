import java.util.Stack;

public class MaximumSpan {

	private static void findMaxSpan(int[] a) {
	    int n = a.length;
	    int span[] = new int[n];
	    Stack<Integer> s = new Stack<>();
	    for(int j = 0; j < n ;j++){
	    	span[j]=1;
	    	while(!s.isEmpty() && a[s.peek()] <= a[j]){
	    		span[j]+=span[s.pop()];
	    	}
	    	s.push(j);
	    }
	    for(int i = 0 ; i< span.length; i++){
			System.out.print(span[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
	   /* int a[] ;
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i = 1; i <= t; i++){
			int n = in.nextInt();
			a = new int[n]; 
			for(int j = 0; j < n ; j++){
				a[j]=in.nextInt();
			}
			findMaxSpan(a);
		}
		in.close();*/
		 int price[] = {10, 4, 5, 90, 120, 80};
		 findMaxSpan(price);
	}


}
