package module.chess;

public class Piece {

	PieceColor pieceColor;
	
	PieceType pieceType;
	
	
	
	public PieceColor getPieceColor() {
		return pieceColor;
	}
	
}
 
enum PieceColor {
	WHITE, BLACK;
}

enum PieceType {
	PAWN,
	ROOK,
	KNIGHT,
	BISHOP,
	KING,
	QUEEN
}
