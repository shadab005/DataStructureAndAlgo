package module.chess;

import java.util.Map;

public class GameMain {

	private Map<PieceColor, Player> players;

	private Board board;

	public void playGame() {
		PieceColor chance = PieceColor.WHITE;
		Move move = null;
		while (board.getState() == BoardState.IN_PROGRESS) {
			move = players.get(chance).getMove();
			boolean isSuccess = false;
			try {
				board.tryMove(move);
				isSuccess = true;
			} catch (InvalidMoveException e) {
				System.out.println(e);
			}
			if (isSuccess) {
				chance = (chance == PieceColor.WHITE) ? PieceColor.BLACK : PieceColor.WHITE;
			}
		}
		//anounce result to players
	}
}
