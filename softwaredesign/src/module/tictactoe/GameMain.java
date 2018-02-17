package module.tictactoe;

public class GameMain {
	
	private Board board;
	
	private Player[] players;
	
	private GameState state;
	
	public GameMain(int gridSize, int numPlayer) {
		board = new Board(gridSize);
		players = new Player[numPlayer];
		state = GameState.PLAYING;
	}
	
	public void playGame() {
		int chance = 0;
		Move m = null;
		while(state == GameState.PLAYING) {
			m = players[chance].getMove();
			board.placePieceAt(m.getPiece(), m.getPosition());
			chance = getChance(chance);
			updateStateWithMove(m);
		}
		notifyResult();
	}
	
	private void notifyResult() {
		
		
	}

	private void updateStateWithMove(Move m) {
		//checkForWinner
		//checkForDraw
		
		
	}

	private int getChance(int previousChance) {
		return previousChance^1;
	}

	public static void main(String args[]) {
		
	}
	
	
	
	

}

