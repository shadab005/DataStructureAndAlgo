package module.chess;


public class Board {

	private Piece[][]  cell;
	
	private BoardState state;
	
	private PlayManager playManager;
	
	public Board() {
		state = BoardState.IN_PROGRESS;
	}
	
	public void resetBoard() {
		state = BoardState.IN_PROGRESS;
		//reset cells
	}
	
	public void playMove(Move move) {
		playManager.takeAction(this, move);
	}
	
	public void placePiece(Piece piece, Position position) {
		cell[position.getX()][position.getY()] = piece;
	}
	
	public void removePiece(Position position) {
		
	}
	
	public BoardState getState() {
		return state;
	}
	
}
