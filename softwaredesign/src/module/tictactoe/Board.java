package module.tictactoe;

public class Board {
	
	private Piece[][]  cell;
	
	public Board(int n){
		cell = new Piece[n][n];
	}
	
	public void placePieceAt(Piece piece, Position position) {
		cell[position.getX()][position.getY()]  =  piece;
	}

}
