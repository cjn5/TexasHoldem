import java.util.Scanner;
import java.util.ArrayList;
public class Game {
	public String[] board;
	public ArrayList<Player> players;
	public int highHand;
	public Game(int otherPlayers) {
		players = new ArrayList<Player>();
		board = new String[5];
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your player name");
		String yourName = scan.next();
		Player you = new Player(yourName);
		players.add(you);
		scan.close();
		for (int i = 2; i <= otherPlayers + 1; i++) {
			Player x = new Player("Player " + Integer.toString(i));
			players.add(x);
		}
		
	}

	public void setBoard(int index, String card) {
		board[index] = card;
	}
	public void printBoard(int howMany) {
		int count = 0;
		while(count < howMany) {
			System.out.print(board[count] + " ");
			count++;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many other players would you like to play with? (up to 7 others)");
		int n = sc.nextInt();
		Game texas = new Game(n);
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 2; i <= 14; i++) {
			list.add("s" + Integer.toString(i));
		}
		for (int i = 2; i <= 14; i++) {
			list.add("h" + Integer.toString(i));
		}
		for (int i = 2; i <= 14; i++) {
			list.add("c" + Integer.toString(i));
		}
		for (int i = 2; i <= 14; i++) {
			list.add("d" + Integer.toString(i));
		}
		Deck deck = new Deck(list);
		for (int i = 0; i < texas.players.size(); i++) {
			deck.dealHand(texas.players.get(i));
		}
		System.out.println("First Round");
		System.out.println("You have " + texas.players.get(0).getHand());
		System.out.println("Second Round");
		deck.dealBoard(texas, 3);
		texas.printBoard(3);		
		System.out.println("Third Round");
		deck.dealBoard(texas, 1);
		texas.printBoard(4);
		System.out.println("Final Round");
		deck.dealBoard(texas, 1);
		texas.printBoard(5);
		String bestHand = texas.players.get(0).getBestHand(texas.board);
		int highHandScore = texas.players.get(0).getHandInt(texas.players.get(0).total);
		int index = 0;
		for (int i = 0; i < texas.players.size(); i++) {
			String cards = texas.players.get(i).getBestHand(texas.board);
			if (highHandScore < texas.players.get(i).getHandInt(texas.players.get(i).total)) {
				highHandScore = texas.players.get(i).getHandInt(texas.players.get(i).total);
				bestHand = cards;
				index = i;
			}
		}
		if (index == 0) {
			System.out.println("Congrats! You won with a " + bestHand);
		} else {
			System.out.println("Sorry, Player " + (index + 1) + " won with a " + bestHand);
			System.out.println(texas.players.get(index).getHand());
		}
	}

}
