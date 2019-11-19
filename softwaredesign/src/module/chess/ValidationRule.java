package module.chess;

import java.util.Map;

public abstract class ValidationRule {

	public abstract void validate(Board board, Move move) throws InvalidMoveException;

}

class SimpleChessValidationRule extends ValidationRule {
	
	Map<PieceType, ValidationRule> pieceTypeValidation;
	@Override
	public void validate(Board board, Move move) throws InvalidMoveException {

		ValidationRule pieceRule = pieceTypeValidation.get(move.getPiece().getPieceType());
		pieceRule.validate(board, move);
		
		//Validate other boundary condition
		//Validate if moving the piece leaves the king in check position
		
	}
	
	public void addPieceValidationRule(PieceType pieceType, ValidationRule validationRule) {
		pieceTypeValidation.put(pieceType, validationRule);
	}
	
}

class PawnValidationRule extends ValidationRule {

	@Override
	public void validate(Board board, Move move) throws InvalidMoveException {
		
		//Check if it is straight move
		     //check it is not crossing or hitting any piece on the way
		    //Check if is two move whether the pawn is in second row
		//If it is one slant move check either it is killing piece of other piece color or not. More than one move in slant direction is invalid
		
	}
	
}