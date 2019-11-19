package module.chess;

public abstract class PlayRule {
	
	private ValidationRule validator;
	
	public void apply(Board board, Move move) {
		validator.validate(board, move);
		play(board, move);
	}
	
	protected abstract void play(Board board, Move move); 
}


class SimpleChessRule extends PlayRule {

	@Override
	protected void play(Board board, Move move) {
		
		//check if it is a castle move do castle
				
		//check if it is enpassant move, do en passant
		
		//Killing case. Make the position of piece getting killed to null
		if(board.getPieceAt(move.getToPosition()) != null) {
			board.playMove(new Move(board.getPieceAt(move.getToPosition()), move.getToPosition(), null));
		}
		board.playMove(move);

		//update game state as per the play rule
	}
	
}
