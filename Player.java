
public class Player {
	private String name;
	private String[] hand;
	public Player(String name) {
		this.name = name;
	}
	public void setName(String setName) {
		this.name = setName;
	}
	public String getName() {
		return this.name;
	}
	public void setHand(String firstCard, String secondCard) {
		hand = new String[2];
		hand[0] = firstCard;
		hand[1] = secondCard;
	}
	public String[] getHand() {
		return hand;
	}
}
