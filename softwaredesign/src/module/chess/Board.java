package module.chess;

public class Board {

	private Piece[][]  cell;
	
	private BoardState state;
	
	private MoveHistory moveHistory;
	
	private PlayRule playRule;
	
	public Board() {
		state = BoardState.IN_PROGRESS;
	}
	
	public void resetBoard() {
		state = BoardState.IN_PROGRESS;
		//reset cells
	}
	
	public void tryMove(Move move) {
		playRule.apply(this, move);
	}
	
	public void playMove(Move move) {
		cell[move.getFromPosition().getX()][move.getFromPosition().getX()] = null;
		cell[move.getToPosition().getX()][move.getToPosition().getX()] = null;
		moveHistory.recordMove(move);
	}
	
	public BoardState getState() {
		return state;
	}

	public Piece getPieceAt(Position toPosition) {
		return null;
	}
	
}
