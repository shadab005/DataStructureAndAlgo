import java.util.ArrayList;
import java.util.List;

public class _305_NumberOfIsland {

	public static void main(String[] args) {
		int p[][] = {{0,0},{0,1},{1,2},{2,1}};
		System.out.println(numIslands2(3, 3, p));

	}
	
	static public List<Integer> numIslands2(int m, int n, int[][] positions) {
		List<Integer> ans = new ArrayList<>();
        UnionFind u = new UnionFind(m*n);
        int grid[][] = new int[m][n];
        int[][] adj = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for(int k = 0 ; k < positions.length; k++) {
        	int i = positions[k][0];
        	int j = positions[k][1];
        	int z = i*n+j;
        	grid[i][j] = 1;
        	u.union(z, z);
        	for(int p[] : adj) {
        		int x = i+p[0];
        		int y = j+p[1];
        		if(isValid(x,y,m,n) && grid[x][y] == 1) {
    				u.union(z, x*n+y);
    			}
        	}
        	ans.add(u.component);
        }
		return ans;
    }

	
	private static boolean isValid(int x, int y, int m, int n) {
		return x>=0 && x<m && y>=0 && y<n;
	}


	static class UnionFind{
		Integer id[];
		int childCount[];
		int component;
		public UnionFind(int n) {
			id = new Integer[n];
			childCount = new int[n];
		}
		public void union(int x, int y) {
		
		   if(x == y) {
			   if(id[x] == null) {
				 id[x] = x;
				 component++;
			   }
			   return;
		   }
		   int x_root = root(x);
		   int y_root = root(y);
		   if(x_root != y_root) {
			   if(childCount[x_root] < childCount[y_root]) {
				   //make y_root as parent of x_root
				   id[x_root] = y_root;
				   childCount[y_root] += childCount[x_root]+1;
			   } else {
				   id[y_root] = x_root;
				   childCount[x_root] += childCount[y_root]+1;
			   }
			   component--;
		   }
		}
		public int root(int i){
			while(i!=id[i]) i =id[i];
			return i;
		}
		public boolean isConnected(int x, int y) {
			return root(x)==root(y);
		}
	}
}
