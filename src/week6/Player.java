package week6;

import java.util.ArrayList;
import java.util.List;

public class Player extends Card{
	private List<Card> hand = new ArrayList<Card>();
	private int score;
	private String name;
	
	public Player() {};
	public Player(String playerName) {
		this.score = 0;
		this.name = playerName;
	};	
	
	public int getScore(String playerName) {
		return this.score;
	}
	
	public String getname() {
		return this.name;
	}
		
	// Prints out information about the player and calls the describe method for each card in the Hand list.
	public void describe() {
		System.out.println("PLAYER: " + this.name);
		System.out.println("The SCORE is: " + this.score);
		if(hand.size() > 0) {
			System.out.println("The PLAYER has CARD count of: " + hand.size());
			System.out.println("The PLAYER has the following CARDS: ");
			for(Card card: hand) {
				super.describe(card);
			}
		}
	}
	
	//Draw method takes a deck as an argument and calls the draw method on the deck, 
	//adding the returned card to the hand field.
	public void draw(Deck deckCard) {
		Card topCard = deckCard.draw();  
		hand.add(topCard);
		this.setName(topCard.getName());
		this.setValue(topCard.getValue());
		
	}
		
	//Removes and returns the top card of the Hand.
	public Card flip() {
		Card topCard = new Card();
				
		if(hand.size() > 0){
			topCard = this.hand.get(hand.size()-1);
			hand.remove(hand.size()-1);
		}
		else {
			System.out.println("We have flipped all the cards. The hand size is: " + hand.size());
		}
		return topCard;
	}
	
	//Adds 1 to the palyer's score list
	public void incrementScore() {
		this.score += 1;
	}

}
