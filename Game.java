import java.util.Scanner;
import java.util.ArrayList;
public class Game {
	public String[] board;
	public ArrayList<Player> players;
	public Game(int otherPlayers) {
		board = new String[5];
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your player name");
		String yourName = scan.next();
		Player you = new Player(yourName);
		players.add(you);
		scan.close();\
		for (int i = 2; i <= otherPlayers + 1; i++) {
			Player x = new Player("Player " + Integer.toString(i));
			players.add(x);
		}
		
	}

	public void setBoard(int index, String card) {
		board[index] = card;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many other players would you like to play with? (up to 7 others)");
		int n = sc.nextInt();
		Game texas = new Game(n);
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1; i <= 13; i++) {
			list.add(Integer.toString(i) + "s");
		}
		for (int i = 1; i <= 13; i++) {
			list.add(Integer.toString(i) + "h");
		}
		for (int i = 1; i <= 13; i++) {
			list.add(Integer.toString(i) + "c");
		}
		for (int i = 1; i <= 13; i++) {
			list.add(Integer.toString(i) + "d");
		}
		Deck deck = new Deck(list);
		for (int i = 0; i < texas.players.size(); i++) {
			deck.dealHand(texas.players.get(i));
		}
		

	}

}
