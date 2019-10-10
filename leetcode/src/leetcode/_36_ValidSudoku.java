package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _36_ValidSudoku {

	public static void main(String[] args) {
		System.out.println(getBoxNumber(2, 8));

	}
	
	static public boolean isValidSudoku(char[][] board) {
		boolean ans = true;
		HashMap<Character, Position> map = new HashMap<>();
		for(int i = 0 ; i < 9; i++)map.put(Character.valueOf((char) (i+49)), new Position());
		for(int i = 0 ; i < 9; i++) {
			for(int j = 0 ; j < 9; j++) {
				if(board[i][j] != '.') {
					Position p = map.get(board[i][j]);
					if(p.containsRow(i))return false;
					if(p.containsCol(j))return false;
					if(p.containsBox(getBoxNumber(i, j)))return false;
					p.rows.add(i);
					p.cols.add(j);
					p.box.add(getBoxNumber(i, j));
				}
			}	
		}
		return ans;
    }
	
	private static int getBoxNumber(int i, int j) {
		return (i/3)*(3)+1+j/3;
	}
	
	private static class Position {
		Set<Integer> rows;
		Set<Integer> cols;
		Set<Integer> box;
		Position(){
			rows = new HashSet<>();
			cols = new HashSet<>();
			box  = new HashSet<>();
		}
		public boolean containsBox(int boxNumber) {
			return box.contains(boxNumber);
		}
		public boolean containsCol(int i) {
			return cols.contains(i);
		}
		public boolean containsRow(int i) {
			return rows.contains(i);
		}
	}

}
