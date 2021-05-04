package week6;

public class Card{
	private int value;  //values are 2-14
	private String name;  //names are Ace of diamonds, Jack of spades etc.
	
	public Card() {};
	
	public Card(int value, String name) {
		this.value = value;
		this.name = name;
	};
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//Prints out information about a Card
	public void describe(Card card) {
		System.out.println("    "+ card.name + ", value: " + card.value);
	}
}
