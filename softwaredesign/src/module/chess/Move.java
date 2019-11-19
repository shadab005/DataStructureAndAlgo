package module.chess;

public class Move {
	

	private Piece piece;
	
	private Position fromPosition;
	
	private Position toPosition;
	
	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Position getFromPosition() {
		return fromPosition;
	}

	public void setFromPosition(Position position) {
		this.fromPosition = position;
	}
	
	public Position getToPosition() {
		return toPosition;
	}

	public void setToPosition(Position position) {
		this.toPosition = position;
	}


}
