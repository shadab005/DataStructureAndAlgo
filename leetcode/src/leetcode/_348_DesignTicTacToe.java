package leetcode;

import java.util.function.Supplier;

public class _348_DesignTicTacToe {

	public static void main(String[] args) {
		TicTacToe t = new TicTacToe(2);
		play(()->t.move(0, 0, 1));
		play(()->t.move(1, 1, 2));
		play(()->t.move(1, 0, 1));
	}
	
	public static void play(Supplier<Integer> f) {
		System.out.println(f.get());
	}

	static class TicTacToe {

	    /** Initialize your data structure here. */
		char board[][];
		int chance = 0;
		int n;
		private static final char CROSS = 'X';
		private static final char NOUGHT = 'Y';
	    public TicTacToe(int n) {
	        board = new char[n][n];
	        this.n = n;
	    }
	    
	    /** Player {player} makes a move at ({row}, {col}).
	        @param row The row of the board.
	        @param col The column of the board.
	        @param player The player, can be either 1 or 2.
	        @return The current winning condition, can be either:
	                0: No one wins.
	                1: Player 1 wins.
	                2: Player 2 wins. */
	    public int move(int row, int col, int player) {
	        if(player == 1) {
	        	board[row][col] = CROSS;
	        } else {
	        	board[row][col] = NOUGHT;
	        }
	       // System.out.println("Chance = " + chance + " Player = " + player);
	        if(isWinningCondition(row, col)) {
	        	return player;
	        }
	    	return 0;
	    }

		private boolean isWinningCondition(int row, int col) {
			//check row horizontal
			char symbol = board[row][col];
			boolean gameComplete = true;
			for(int i=0; i < n; i++) {
				if(board[row][i] != symbol) {
					gameComplete = false;
					break;
				}
			}
			if(gameComplete) return true;
			//Checking col vertical
			gameComplete = true;
			for(int i=0; i < n; i++) {
				if(board[i][col] != symbol) {
					gameComplete =  false;
					break;
				}
			}
			if(gameComplete) return true;
			//Check first diagonal 
			if(row==col) {
				gameComplete = true;
				for(int i = 0 ; i < n; i++) {
					if(board[i][i] != symbol) {
						gameComplete = false;
						break;
					}
				}
				if(gameComplete) return true;
			}
			//check second diagonal
			if(row+col == n-1) {
				gameComplete = true;
				for(int i = 0 ; i < n; i++) {
					if(board[i][n-i-1] != symbol) {
						gameComplete = false;
						break;
					}
				}
				if(gameComplete) return true;
			}
			return false;
			
		}
	}

}
