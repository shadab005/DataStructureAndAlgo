package leetcode;

// #interview
//#prepare https://leetcode.com/problems/dungeon-game/
public class _174_DungeonGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[][] = new int[][] {{1,-3,3},{0,-2,0},{-3,-3,-3}};
		
		System.out.println(calculateMinimumHP(a));

	}
	
	static public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		int dp[][] = new int[m][n];
		dp[m-1][n-1] = Math.max(0, 1-dungeon[m-1][n-1]);
		//last row
		for(int i = n-2; i>=0 ; i--) {
			int requiredAtNeighbour = dp[m-1][i+1];
			dp[m-1][i] = minEnergyRequiredAtThisPosition(dungeon, dp, m-1, i, requiredAtNeighbour);
		}
		//last col
		for(int i = m-2; i>=0 ; i--) {
			int requiredAtNeighbour = dp[i+1][n-1];
			dp[i][n-1] = minEnergyRequiredAtThisPosition(dungeon, dp, i, n-1, requiredAtNeighbour);
		}
		
		for(int i = m-2 ; i >=0; i--) {
			for(int j = n-2; j>=0 ; j--) {
				int requiredAtNeighbour = Math.min(dp[i][j+1], dp[i+1][j]);
				dp[i][j] = minEnergyRequiredAtThisPosition(dungeon, dp, i, j, requiredAtNeighbour);
			}
		}
		return Math.max(dp[0][0],1);
    }
	
	static int minEnergyRequiredAtThisPosition(int dungeon[][], int dp[][], int i, int j, int requiredAtNeighbour) {
		if(requiredAtNeighbour == 0) {
			return Math.max(0, 1-dungeon[i][j]);
		} else {
			return Math.max(0, requiredAtNeighbour-dungeon[i][j]);
		}
	}

}
