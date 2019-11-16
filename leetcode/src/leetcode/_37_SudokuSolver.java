package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import algo.util.Util;

public class _37_SudokuSolver {

	public static void main(String[] args) {

		char[][] ch = {
				{'.','.','.','.','.','.','.','.','6'},
				{'.','.','.','4','.','.','.','.','1'},
				{'8','.','9','5','.','.','7','.','.'},
				{'9','.','1','2','.','.','.','.','.'},
				{'.','7','.','.','.','.','.','.','.'},
				{'2','.','5','.','6','.','9','.','7'},
				{'4','9','7','.','1','.','8','.','5'},
				{'.','.','6','.','.','8','3','.','.'},
				{'.','.','.','6','7','4','.','.','.'}
		};
		solveSudoku(ch);
		Util.printArray(ch);
		
	}
	
	static public void solveSudoku(char[][] board) {
        HashMap<Integer, Set<Character>> rowData = new HashMap<>();
        HashMap<Integer, Set<Character>> colData = new HashMap<>();
        HashMap<Integer, Set<Character>> boxData = new HashMap<>();
        
        //initialization
        for(int i = 0 ; i < 9; i++) {
        	rowData.put(i, new HashSet<>());
        	colData.put(i, new HashSet<>());
        	boxData.put(i, new HashSet<>());
        }
        for(int i = 0 ; i < 9; i++) {
			for(int j = 0 ; j < 9; j++) {
				if(board[i][j] != '.') {
					rowData.get(i).add(board[i][j]);
					colData.get(j).add(board[i][j]);
					boxData.get(boxNumber.apply(i, j)).add(board[i][j]);
				}
			}
        }
        
        
        //filling up possible position for each (i,j)
        Set<Character> possibleCharacters = IntStream.range(0, 9).mapToObj(i->Character.valueOf((char) (i+49))).collect(Collectors.toSet());
        PriorityQueue<GridUnit> gridUnitQueue = new PriorityQueue<>();
        for(int i = 0 ; i < 9; i++) {
			for(int j = 0 ; j < 9; j++) {
				if(board[i][j] == '.') {
					HashSet<Character> possible = new HashSet<>(possibleCharacters);
					rowData.get(i).forEach(ch->possible.remove(ch));
					colData.get(j).forEach(ch->possible.remove(ch));
					boxData.get(boxNumber.apply(i, j)).forEach(ch->possible.remove(ch));
					GridUnit newGridUnit = new GridUnit(i, j, possible);
					gridUnitQueue.add(newGridUnit);
				}
			}
        }
        solve(board, new Configuration(gridUnitQueue, rowData, colData, boxData));
        
    }
	
	private static boolean solve(char[][] board, Configuration configuration) {
		PriorityQueue<GridUnit> gridUnitQueue = configuration.gridUnitQueue;
		if(gridUnitQueue.isEmpty()) return true;

		GridUnit gridUnit = gridUnitQueue.remove();
		int i = gridUnit.row, j = gridUnit.col;
		
		for(Character ch : gridUnit.possibleCharacters) {
		   if(!configuration.rowData.get(i).contains(ch) && 
		      !configuration.colData.get(j).contains(ch) && 
		      !configuration.boxData.get(boxNumber.apply(i, j)).contains(ch)) {
			   //Changes to configuration
			   board[i][j] = ch;
			   configuration.rowData.get(i).add(ch);
			   configuration.colData.get(j).add(ch);
			   configuration.boxData.get(boxNumber.apply(i, j)).add(ch);
			   
			   boolean isSolved = solve(board, configuration);
			   if(!isSolved) {
				   //undo
				   board[i][j] = '.';
				   configuration.rowData.get(i).remove(ch);
				   configuration.colData.get(j).remove(ch);
				   configuration.boxData.get(boxNumber.apply(i, j)).remove(ch);
				   
			   } else {
				   return true;
			   }
		   }
		}
		gridUnitQueue.add(gridUnit);
		return false;
	}

	private static BiFunction<Integer, Integer, Integer> boxNumber = (i,j)->(i/3)*(3)+j/3;
	
	private static class GridUnit implements Comparable<GridUnit>{
		int row;
		int col;
		Set<Character> possibleCharacters;
		private int size;
		GridUnit(int i, int j, Set<Character> characters){
			row = i;
			col = j;
			possibleCharacters = characters;
			size = characters.size();
		}
		@Override
		public int compareTo(GridUnit that) {
			return this.size-that.size;
		}
		
		@Override
		public String toString() {
			return "[" + row + " , " + col + " => " + possibleCharacters;
		}
		
	}
	
	static class Configuration {
		PriorityQueue<GridUnit> gridUnitQueue;
		HashMap<Integer, Set<Character>> rowData;
        HashMap<Integer, Set<Character>> colData;
        HashMap<Integer, Set<Character>> boxData;
        public Configuration(PriorityQueue<GridUnit> gridUnitQueue, HashMap<Integer, Set<Character>> row,
        		HashMap<Integer, Set<Character>> col, HashMap<Integer, Set<Character>> box) {
        	this.gridUnitQueue = gridUnitQueue;
        	rowData = row;
        	colData = col;
        	boxData = box;
			
		}
	}
	 
}
