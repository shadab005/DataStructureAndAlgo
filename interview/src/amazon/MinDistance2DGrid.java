package amazon;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinDistance2DGrid {

	public static void main(String[] args) {
		
	}
	
	private static final int PRIME = 1009;
	static int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
    {
		class A{
			
		}
        // WRITE YOUR CODE HERE
		int m = numRows, n=numColumns;
		int a[][] = new int[numRows][numColumns];
		for(int i=0; i< numRows;i++) {
			for(int j=0; j<numColumns; j++) {
				a[i][j] = area.get(i).get(j);
			}
		}
		
		int i,j=0;
		
		boolean visited[] = new boolean[m*PRIME+n];
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		while(!q.isEmpty()) {
			
		}
		
		return -1;
    }
	
	private static boolean isValidPosition(int i, int j, int m, int n) {
		if(i<0 || i>=m || j<0 || j>=n)return false;
		return true;
	}
	
	static class Pair {
		int x;
		int y;
		Pair(int a, int b){
			x=a;
			y=b;
		}
	}

}
