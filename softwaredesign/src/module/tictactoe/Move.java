package module.tictactoe;

public class Move {

	Position position;
	Player player;
	
	Move(Position position, Player player){
		this.position = position;
		this.player = player;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public Piece getPiece() {
		return player.getPiece();
	}
	
}
