package algo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class QueenPuzzle {

	
	public ArrayList<ArrayList<String>> solveNQueens(int n) {
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		int board[]=new int[n];
		Arrays.fill(board, -1);
		solve(ans, board, 0);
		return ans;
	}
	
	private void solve(ArrayList<ArrayList<String>> ans, int board[], int col) {
		if(col>=board.length) {
		   ans.add(getBoardConfig(board));
		   return;
		}
		for(int row=0;row<board.length;row++) {
			if(isSafe(board,col,row)){
				board[col]=row;
				solve(ans, board, col+1);
				board[col]=-1;
			}
		}
	}
	
	private boolean isSafe(int[] board,int col, int row) {
		//check for row collision, 
		for(int i=0;i<col;i++)if(board[i]==row)return false;
		//check for diagonal collision
		int i=1;
		while(row-i>=0 && col-i>=0) {
			if(board[col-i]==row-i)return false;
			i++;
		}
		i=1;
		while(row+i<board.length && col-i>=0) {
			if(board[col-i]==row+i)return false;
			i++;
		}
		return true;
	}

	private ArrayList<String> getBoardConfig(int board[]) {
		ArrayList<String> boardConfig = new ArrayList<>();
		int row = 0;
		String s=null;
		for(int i=0;i<board.length;i++) {
			row=board[i];
			if(row==0) {
				char c[]=new char[board.length-row-1];
				Arrays.fill(c, '.');
				s="Q"+new String(c);
			}else if(row==board.length) {
				char c[]=new char[row];
				Arrays.fill(c, '.');
				s=new String(c)+"Q";
			}else {
				char c1[]=new char[row];
				Arrays.fill(c1, '.');
				
				char c2[]=new char[board.length-row-1];
				Arrays.fill(c2, '.');
				s=new String(c1)+"Q"+new String(c2);
			}
			boardConfig.add(s);
		}
		return boardConfig;
	}

	public static void main(String[] args) {
		QueenPuzzle p = new QueenPuzzle();
		ArrayList<ArrayList<String>>  solutions = p.solveNQueens(4);
		p.printAllConfig(solutions);

	}

	public void printAllConfig(ArrayList<ArrayList<String>> solutions) {
	     for(ArrayList<String> c:solutions) {
	    	 System.out.println(c);
	     }
	}

}
