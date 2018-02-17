package module.carddeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
	
	private List<Card> cards;
	
	public CardDeck() {
		cards = new ArrayList<>();
		
		for(Suit s: Suit.values()) {
			for(Rank r : Rank.values()) {
				cards.add(new Card(s,r));
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public void printCards() {
		cards.forEach(System.out::println);
	}
	
	public static void main(String args[]) {
		CardDeck deck = new CardDeck();
		deck.printCards();
		deck.shuffle();
		System.out.println("==============================");
		deck.printCards();
		
	}

}
