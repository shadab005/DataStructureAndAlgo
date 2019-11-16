package leetcode;

import java.util.Arrays;

import algo.util.Util;

public class _909_SnakesLadders {

	public static void main(String[] args) {
		int b[][] = 
			{
					{-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1},
					{-1,-1,-1,-1,-1,-1},
					{-1,35,-1,-1,13,-1},
					{-1,-1,-1,-1,-1,-1},
					{-1,15,-1,-1,-1,-1}};
		System.out.println(snakesAndLadders(b));

	}

	private static final int INFINITY = 1000;

	static public int snakesAndLadders(int[][] board) {
		int n = board.length;
		int a[] = new int[n * n];
		int k = 0;
		int j = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (j == 0) {
				for (j = 0; j < n; j++) {
					//System.out.println("board["+i+"]["+j+"]="+board[i][j]);
					a[k] = Math.max(-1, board[i][j]-1);
					k++;
				}
				j = n;
			} else if (j == n) {
				for (j = n - 1; j >= 0; j--) {
					//System.out.println("board["+i+"]["+j+"]="+board[i][j]);
					a[k] = Math.max(-1, board[i][j]-1);
					k++;
				}
				j = 0;
			}
		}
		
	//	Util.printArray(a);

		n = a.length;
		int ans[] = new int[n];
		
		Arrays.fill(ans, INFINITY);
		ans[n - 1] = 0;
		
		

		for (int i = n - 2; i >= 0; i--) {
			System.out.println("i="+i);
			if (a[i] > i) {
				ans[i] = Math.min(ans[i], 1 + ans[a[i]]);
				System.out.println("Setting at Ladder case " +" ans["+i+"]="  +  ans[i]);
			} else if(a[i] < i && a[i] != -1) {
				System.out.println("Setting  " + " ans["+i+"]=" + + INFINITY);
				ans[i] = INFINITY;
				continue;
			}
			if (i + 6 >= n - 1) {
				System.out.println("Setting ans[i] i+6 case " +" ans["+i+"]=" + 1);
				ans[i] = 1;
			}
			// snake bite
			if (a[i] < i && a[i] != -1) {
				System.out.println("Setting ans[i] Snake bite  case " +" ans["+i+"]=" + INFINITY);
				ans[i] = INFINITY;
			}
			for (k = i + 1; k < Math.min(n, i + 7); k++) {
				//ladder
				//ans[i] = Math.min(ans[i], 1 + ans[k]);
				//System.out.println("Setting ans[i] Normal case at k = " +k +" ans["+i+"]=" +  ans[i]);
				if (a[k] > k) {
					//ans[i] = Math.min(ans[i], 1 + ans[a[k]]);
					ans[i] = Math.min(ans[i], ans[k]);
					System.out.println("Setting ans[i] Ladder case at k = " +k +" ans["+i+"]=" +  ans[i]);
				} else {
					ans[i] = Math.min(ans[i], 1 + ans[k]);
					System.out.println("Setting ans[i] Normal case at k = " +k +" ans["+i+"]=" +  ans[i]);
				}

			}

		}

		//Util.printArray(ans);
		return ans[0];
	}

}
