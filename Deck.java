import java.util.ArrayList;

public class Deck {
	public ArrayList<String> cards;

	public Deck(ArrayList<String> cards) {
		this.cards = cards;
	}

	public void dealHand(Player p) {
		String first = cards.get((int) (Math.random() * cards.size()));
		cards.remove(first);
		String second = cards.get((int) (Math.random() * cards.size()));
		cards.remove(second);
		p.setHand(first, second);
	}

	public void dealBoard(Game g, int number) {
		if (number == 3) {
			for (int i = 0; i < 3; i++) {
				String c = cards.get((int) (Math.random() * cards.size()));
				g.setBoard(i, c);
				cards.remove(c);
			}
		}
		if (number == 1 && g.board[3] == null) {
			String aCard = cards.get((int) (Math.random() * cards.size()));
			g.setBoard(3, aCard);
			cards.remove(aCard);
		} else if (g.board[4] == null) {
			String card = cards.get((int) (Math.random() * cards.size()));
			g.setBoard(4, card);
			cards.remove(card);
		}
	}
}
