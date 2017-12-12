
public class Player {
	private String name;
	private String[] hand;
	private int score;
	public String[] total;

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
		total = new String[7];
		total[0] = hand[0];
		total[1] = hand[1];
		for (int i = 2; i < 7; i++) {
			total[i] = tableCards[i - 2];
		}
		total = sort(total);
		int bestHand = getHandInt(total);
		if (bestHand == 10) {
			return "Royal Flush!!";
		}
		if (bestHand == 9) {
			return "Straight Flush";
		}
		if (bestHand == 8) {
			return "Four of a Kind";
		}
		if (bestHand == 7) {
			return "Full House";
		}
		if (bestHand == 6) {
			return "Flush";
		}
		if (bestHand == 5) {
			return "Straight";
		}
		if (bestHand == 4) {
			return "Three of a Kind";
		}
		if (bestHand == 3) {
			return "Two Pair";
		}
		if (bestHand == 2) {
			return "Pair";
		}
		if (bestHand == 1) {
			return "High card :(";
		}
		return "";
	}

	public static String[] sort(String[] cards) {
		String temp;
		for (int i = 1; i < cards.length; i++) {
			for (int j = i; j > 0; j--) {
				if (Integer.parseInt(cards[j].substring(1)) < Integer.parseInt(cards[j - 1].substring(1))) {
					temp = cards[j];
					cards[j] = cards[j - 1];
					cards[j - 1] = temp;
				}
			}
		}
		return cards;
	}

	public int getHandInt(String[] cards) {
		if (straight(cards) && flush(cards)) {
			if (royalFlush(cards)) {
				// Royal flush
				return 10;
			} else {
				// Straight flush
				return 9;
			}
		}
		if (flush(cards)) {
			// Flush
			return 6;
		}
		if (straight(cards)) {
			// Straight
			return 5;
		}
		if (pair(cards)) {
			if (threeOfAKind(cards)) {
				if (fourOfAKind(cards)) {
					// Four of a kind
					return 8;
				} else if (fullHouse(cards)) {
					// Full house
					return 7;
				} else {
					// Three of a kind
					return 4;
				}
			}
			if (twoPair(cards)) {
				// Two pair
				return 3;
			} else {
				// Pair
				return 2;
			}
		}
		// if not flush nor straight nor pair, then high cards.
		return 1;
	}

	/*
	 * test for each hand an
	 */
	public boolean royalFlush(String[] cards) {
		if (straight(cards) && flush(cards)) {
			int count = 0;
			for (int i = 0; i < cards.length; i++) {
				if (cards[i].substring(1).equals("10")) {
					count++;
				}
				if (cards[i].substring(1).equals("11")) {
					count++;
				}
				if (cards[i].substring(1).equals("12")) {
					count++;
				}
				if (cards[i].substring(1).equals("13")) {
					count++;
				}
				if (cards[i].substring(1).equals("14")) {
					count++;
				}
			}
			if (count == 5) {
				return true;
			}
		}

		return false;
	}

	public boolean straightFlush(String[] cards) {
		return straight(cards) && flush(cards);
	}

	public boolean pair(String[] cards) {
		int count = 0;
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				if (i != j && cards[i].substring(1).equals(cards[j].substring(1))) {
					count++;
					break;
				}
			}
		}
		if (count > 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean fourOfAKind(String[] cards) {
		int count = 0;
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				if (i != j && cards[i].substring(1).equals(cards[j].substring(1))) {
					count++;
					break;
				}
			}
		}
		if (count == 4) {
			return true;
		} else {
			return false;
		}
	}

	public boolean fullHouse(String[] cards) {
		return threeOfAKind(cards) && twoPair(cards);

	}

	public boolean flush(String[] cards) {
		int count = 0;
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				if (i != j && cards[i].substring(0, 1).equals(cards[j].substring(0, 1))) {
					count++;
					break;
				}
			}
		}
		if (count == 5) {
			return true;
		} else {
			return false;
		}
	}

	public boolean straight(String[] cards) {
		int count = 0;
		for (int i = 1; i < cards.length; i++) {
			if (Integer.parseInt(cards[i - 1].substring(1)) + 1 == Integer.parseInt(cards[i].substring(1))) {
				count++;
			}
		}
		if (count >= 4) {
			return true;
		} else {
			return false;
		}
	}

	public boolean threeOfAKind(String[] cards) {
		int count = 0;
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				if (i != j && cards[i].substring(1).equals(cards[j].substring(1))) {
					count++;
					break;
				}
			}
		}
		if (count == 3) {
			return true;
		} else {
			return false;
		}
	}

	public boolean twoPair(String[] cards) {
		int count = 0;
		for (int i = 1; i < cards.length; i++) {
			if (Integer.parseInt(cards[i - 1].substring(1)) == Integer.parseInt(cards[i].substring(1))) {
				count++;
				if (i != cards.length - 1) {
					i++;
				}
			}
		}
		if (count >= 2) {
			return true;
		} else {
			return false;
		}
	}

}
