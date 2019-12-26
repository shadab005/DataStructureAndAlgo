package leetcode;


//https://leetcode.com/problems/cherry-pickup/
public class _741_CherryPickup {

	public static void main(String[] args) {
		

	}
	
	static Integer dp[][][];
	
	static public int cherryPickup(int[][] grid) {
        
		//r1,c1,r2,c2
		//r2 = r1+c1-c2 , --eq1
		//let's define a function that gives maximum cherry when two people start from (r1,c1) and (r2,c2)
		//and also due to eq1, r2 is derivable
		dp = new Integer[grid.length][grid.length][grid.length];
		return Math.max(0, solve(grid, 0, 0, 0));
    }
	
	static int solve(int grid[][], int r1, int c1, int c2) {
		
		int r2 = r1+c1-c2;
		int n = grid.length;
		
		if(r1 == n || r2 == n || c1 == n || c2 == n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
			return Integer.MIN_VALUE;
		}
		
		if(dp[r1][c1][c2]!=null) return dp[r1][c1][c2];
		if(r1 == n-1 && c1 == n-1) return dp[r1][c1][c2] = grid[r1][c1];
		
		int ans = grid[r1][c1];
		if(c1!=c2) { //i.e if r1,c1 and r2,c2 doesn't coincide. Otherwise it will lead to double counting 
			ans+= grid[r2][c2];
		}
		ans+= max(solve(grid, r1+1,c1, c2), solve(grid, r1,c1+1, c2), solve(grid, r1+1,c1, c2+1), solve(grid, r1,c1+1, c2+1));
		dp[r1][c1][c2] = ans;
		return ans;
	}

	static int max(int a, int b, int c, int d) {
		return Math.max(Math.max(a, b), Math.max(c, d));
	}
}
