package week6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
	
	public static int drawCount = 0;
	public static void main(String[] args) {
		List<Deck> deckOfCards = new ArrayList<Deck>();
			
		//3. a. Instantiate a Deck.
		deckOfCards = instanciateDeckOfCards();
		Deck deckCard = new Deck();
		
		for(Deck deck: deckOfCards) {
			deckCard.addCard(deck); 
		}
		
		//3. b. Call the shuffle method on the deck.
		deckCard.shuffle();
		
		//3. c. Instantiate two Players.
		Player player1 = new Player("Tommy");
		Player player2 = new Player("Pam");
		
		//4. Using a traditional for loop, iterate 52 times calling the Draw method on 
		//the other player each iteration using the Deck you instantiated.
		
		distributeDeckOfCardsBetweenTwoPlayers(player1, player2, deckCard);
		
		//5. Using a traditional for loop, iterate 26 times and call the flip method for each player.
		//a. Compare the value of each card returned by the two player’s flip methods. Call the 
		//incrementScore method on the player whose card has the higher value.
		
		comparePlayersCardsToIncrementScore(player1, player2);
		
		//6. After the loop, compare and print the final score of each player. 
		compareAndPrintScoresOfEachPlayer(player1, player2); 
				
		//7. Print the final score of the player who won - “Player 1”, “Player 2”, or “Draw” 
		//depending on which score is higher or if they are both the same.
		
		printFinalResult(player1, player2);
			
	} // main()
	
	
	//In the constructor, when a new Deck is instantiated, the Cards field should be populate dwith the standard 52 cards.
	public static List<Deck> instanciateDeckOfCards() {
		List<Deck> deckOf52Cards = new ArrayList<Deck>();
		Set <String> colors = new HashSet<>();  // {"Clubs", "Diamonds","Hearts", "Spades"};
		colors.add("Clubs");
		colors.add("Diamonds");
		colors.add("Hearts");
		colors.add("Spades");
		
		for(String color: colors) {
			for(int i = 2; i < 15; i++) {
				if(i < 11 ) {
					Deck newCard = new Deck(i, i + " of " + color);
					deckOf52Cards.add(newCard);
				}
				else {
					if(i == 11) {
						Deck newCard = new Deck(i, "Jack of " + color);
						deckOf52Cards.add(newCard);
						
					}
					else if(i == 12) {
						Deck newCard = new Deck(i, "Queen of " + color);
						deckOf52Cards.add(newCard);
						
					}
					else if(i == 13) {
						Deck newCard = new Deck(i, "King of " + color);
						deckOf52Cards.add(newCard);
						
					}
					else {
						Deck newCard = new Deck(i, "Ace of " + color);
						deckOf52Cards.add(newCard);
						
					}
				}// else statement
				
			}// for i
		}// for color
		
		System.out.println("The DECK size is: " + deckOf52Cards.size());
		return deckOf52Cards;
	}// instanciateDeckOfCards()
	
	//4. Using a traditional for loop, iterate 52 times calling the Draw method on 
	//the other player each iteration using the Deck you instantiated.
	public static void distributeDeckOfCardsBetweenTwoPlayers(Player player1, Player player2, Deck deckOfCards) {
		for(int i = 0; i < 52; i++){
			if(i%2 == 0) {
				player1.draw(deckOfCards); 
			}
			else {
				player2.draw(deckOfCards); 
			}
		}
		
		System.out.println("\n****** The CARDS PLAYER1 RECEIVED after the SHUFFLE ******");
		player1.describe();
				
		System.out.println("\n****** The CARDS PLAYER2 RECEIVED after the SHUFFLE ******");
		player2.describe();
	
	}
	
	//5. Using a traditional for loop, iterate 26 times and call the flip method for each player.
	//a. Compare the value of each card returned by the two player’s flip methods. Call the 
	//incrementScore method on the player whose card has the higher value.
	public static void comparePlayersCardsToIncrementScore(Player player1, Player player2) {		
		Card player1Card;
		Card player2Card;
		
		for(int i = 0; i < 26; i++){
			player1Card = player1.flip();
			player2Card = player2.flip();
			
			if(player1Card.getValue() > player2Card.getValue()){
				player1.incrementScore();
			}
			else if(player1Card.getValue() < player2Card.getValue()){
				player2.incrementScore();
			}
			else {
				player1.incrementScore();
				player2.incrementScore();
				drawCount++;
			}
		}
		
	}
	
	//6. After the loop, compare and print the final score of each player. 
	public static void compareAndPrintScoresOfEachPlayer(Player player1, Player player2) {	
		System.out.println("\n****** The FINAL SCORE of each PLAYER after the FLIP game  ******");
		player1.describe();
		player2.describe();
	}
	
	//7. Print the final score of the player who won - “Player 1”, “Player 2”, or “Draw” 
	//depending on which score is higher or if they are both the same.
	public static void printFinalResult(Player player1, Player player2) {		
		int player1Score = player1.getScore(player1.getname());
		int player2Score = player2.getScore(player2.getname());
		
		System.out.println("\n****** THE WAR GAME HAS BEEN WON BY:  ******");
		if(player1Score > player2Score) {
			player1.describe();
			System.out.println("Number of draw hands(flipped cards with equal value for both players): " + drawCount); 			
		}
		else if(player2Score > player1Score) {
			player2.describe();
			System.out.println("Number of draw hands(flipped cards with equal value for both players): " + drawCount); 
		}
		else {
			System.out.println("****** IT WAS A DRAW ****** ");
			player1.describe();
			player2.describe();
			System.out.println("Number of draw hands(flipped cards with equal value for both players): " + drawCount); 			
		}
	}
	
}

