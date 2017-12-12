
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
	public String getHand() {
		return hand[0] + " " + hand[1];
	}
	public String getBestHand(String[] tableCards) {
		String[] total = new String[7];
		total[0] = hand[0];
		total[1] = hand[1];
		for (int i = 2; i < 8; i++) {
			total[i] = tableCards[i - 2];
		}
	}
	/**
	 * 
	 * @param cards
	 * @return
	 */
	public boolean royalFlush(String[] cards) {
		
	}
	public boolean straightFlush(String[] cards) {
		
	}
	public boolean fourOfAKind(String[] cards) {
		
	}
	public boolean fullHouse(String[] cards) {
		
	}
	public boolean flush(String[] cards) {
		
	}
	public boolean straight(String[] cards) {
		
	}
	public boolean threeOfAKind(String[] cards) {
		
	}
	public boolean twoPair(String[] cards) {
		
	}
	
}
