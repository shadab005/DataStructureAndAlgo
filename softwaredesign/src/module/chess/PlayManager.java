package module.chess;

/**
 * 
 * Responsible to take action on board,
 * handles piece killing, piece promotion, castling,  en Passant  and other type of rules that apply
 * 
 * The PlayManager will actually be interface and different play manager will be impemented as per the game rule.
 * Ex : There will be different play maanger for anti chess.
 * 
 *
 */
public class PlayManager {

	MoveHistory history;
	
	public void takeAction(Board board, Move move) {
		
	}
}
