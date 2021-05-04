package week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck extends Card {
	
	private List<Card> cards = new ArrayList<Card>();
	
	public Deck() {};
	
	public Deck(int value, String name) {
		super(value, name);
	}
	
	public Deck(int value, String name, Card card) {
		super(value, name);
		cards.add(card);
	}
		
	public void addCard(Card card) {
		cards.add(card);
	}
	
	// The shuffle method randomizes the order of the cards
	public void shuffle() {
		Collections.shuffle(this.cards);
		
	}
	
	// The draw method removes and returns the top card of the Cards field
	public Card draw() {
		Card topCard = cards.get(cards.size()-1);
		cards.remove(cards.size()-1);
		return topCard;
	}

}
