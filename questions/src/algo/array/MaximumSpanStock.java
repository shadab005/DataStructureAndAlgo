package algo.array;
import java.util.Stack;

public class MaximumSpanStock {

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
	
	//looks better
	private static void findMaxSpanII(int[] a) {
	    int n = a.length;
	    int span[] = new int[n];
	    Stack<Integer> s = new Stack<>();
	    for(int j = 0; j < n ;j++){
	    	span[j]=1;
	    	while(!s.isEmpty() && a[s.peek()] <= a[j]){
	    		s.pop();
	    	}
	    	if(s.isEmpty()) span[j] = j+1;
	    	else {
	    		span[j] = j-s.peek();
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
		 int price[] = {10, 4, 4, 90, 120, 80};
		 findMaxSpan(price);
		 findMaxSpanII(price);
		 test2(new int[] {5,4,3,2,1});
	}
	
	 static void test2(int price[] ) {
		 findMaxSpan(price);
		 findMaxSpanII(price);
	 }


}
