package module.chess;

import java.util.Map;

public class GameMain {
	
	private Map<PieceColor, Player> players;
	
	private Board board;
	
	private GameRule rule;
	
	private Anouncer anouncer;
	
	public void playGame() {
		PieceColor chance = PieceColor.WHITE;
		Move move = null;
		while(board.getState() == BoardState.IN_PROGRESS) {
			do {
			   move = players.get(chance).getMove();
			}while(!rule.isValid(board, move, players.get(chance).getPieceColor()));
			board.playMove(move);
			chance = (chance==PieceColor.WHITE)?PieceColor.BLACK:PieceColor.WHITE;
		}
		anouncer.anounceResult(board.getState());
	}
	
}
