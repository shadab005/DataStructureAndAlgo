import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TraveelingIsFun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 6 0 4 1 4 3 6 4 3 6 2 5
		int n = 6;
		int threshold = 0;
		List<Integer> o = Arrays.asList(1,4,3,6);
		List<Integer> d = Arrays.asList(3,6,2,5);
		connectedCities(n, threshold, o, d);

	}
	
	
	static List<Integer> connectedCities(int n, int threshold, List<Integer> o, List<Integer> d) {
		
		int or[] = new int[o.size()];
		int de[] = new int[d.size()];
		for(int i=0;i<or.length;i++) {
			or[i]=o.get(i);
			de[i]=d.get(i);
		}
		
		int ans[] = connectedCities(n, threshold, or, de);
		List<Integer> answer = new ArrayList<>();
		for(int x : ans)answer.add(x);
		return answer;
		
	}
	
	static int[] connectedCities(int n, int threshold, int[] originCities, int[] destinationCities) {
        Graph g = new Graph(n+1);
        
        for(int i=1;i<=n;i++) {
        	for(int j=i+1;j<=n;j++) {
        		if(gcd(i,j)>threshold) {
        			g.connect(i, j);
        		}
        	}
        }
        
        g.connectedComponent();
        
        int ans[] = new int[originCities.length];
        for(int  i=0;i<originCities.length;i++) {
        	if(g.connected(originCities[i], destinationCities[i])) {
        		ans[i]=1;
        	}else {
        		ans[i]=0;
        	}
        }
		return ans;
    }
	
	
	static int gcd(int a, int b) {
		if(b==0)return a;
		return gcd(b,a%b);
	}
	
	private static class Graph {

		private int n = 0;
		public ArrayList<Integer>[] vertex;
		
		private boolean[] marked;
		private int[] id; 
		private int count; 
		
		@SuppressWarnings("unchecked")
		Graph(int n){
			this.n = n;
			ArrayList<Integer>[] vertex = (ArrayList<Integer>[])new ArrayList[n];
			marked = new boolean[n];
			id = new int[n];
			this.vertex = vertex;
			
			
			for(int i=0;i<n;i++)vertex[i]=new ArrayList<>();
			
			
			
		}
		
		public void connect(int v, int w) {
			vertex[v].add(w);
			vertex[w].add(v);
		}
		public void connectedComponent() {
			for (int v = 0; v < n; v++) {
	            if (!marked[v]) {
	                dfs(v);
	                count++;
	            }
	        }
		}
		
		private void dfs( int v) {
	        marked[v] = true;
	        id[v] = count;
	        for (int w : vertex[v]) {
	            if (!marked[w]) {
	                dfs(w);
	            }
	        }
	    }
		
		public int id(int v) {
	        return id[v];
	    }
		
		public boolean connected(int v, int w) {
	        return id(v) == id(w);
	    }

	}

}
