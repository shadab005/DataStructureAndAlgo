import java.util.Arrays;
import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
	      // {5,2,8,5,1,5}; 
		 int a[] ={1,2,5,5,5,8};
		 System.out.println(maxTripletSum(a));
	}
	
	
	
	static long maxTripletSum(int[] a){
        // Write your code here
		Arrays.sort(a);
		int n = a.length;
		int i = 0 , j = n-2;
		long ans = 0;
		while(i<j) {
			//System.out.println("i="+i+", j="+j +" , a[j] = " + a[j]);
			ans+= a[j];
			j=j-2;
			i++;
		}
		return ans;
    }
	
	
	
	
	
	
	
	static int calculate(char[][] k, String s, int n, int m) {
        //write your code here
		//n rows, m cols
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < n ;i++) {
			for(int j = 0; j < m ; j++) {
				if(map.containsKey(k[i][j])) return -1;
				map.put(k[i][j], oneD(i, j, m));
			}
		}
		
	   int prev = 0;
	   int ans = 0;
	   Integer current =0;
	   for(char c : s.toCharArray()) {
		   current = map.get(c);
		   if(current == null) return -1;
		   ans+=cost(prev, current, m);
		   prev = current;
	   }
		return ans;
    }
	
	
	private static int cost(int prev, Integer current, int colSize) {
		int prev_i = prev/colSize;
		int prev_j = prev%colSize;
		int current_i = current/colSize;
		int current_j = current%colSize;
		return Math.abs(prev_i-current_i)+Math.abs(prev_j-current_j);
	}


	static int oneD(int i, int j, int colSize) {
		return i*colSize+j;
	}
}