package module.carddeck;

public class Card {

	private Suit suit;
	private Rank rank;
	
	public Card(Suit s, Rank r) {
	   setSuit(s);
	   setRank(r);
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return suit + "-" + rank;
	}
}
