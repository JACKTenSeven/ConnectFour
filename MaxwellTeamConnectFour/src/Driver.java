import java.util.Random;
import java.util.Scanner;

public class Driver {
	public static Board gameBoard = new Board(6, 7);
	public static Colour player1;
	public static Colour player2;
	public static Scanner k = new Scanner(System.in);
	public static int loc;
	public static void main(String[] args) {

		Random r = new Random();
		boolean gameEnd = false;
		boolean local = true;

		player1 = Colour.Blue;
		player2 = Colour.Red;

		System.out.println("Enter 1 to play with a friend");
		System.out.println("Enter 2 to play against the computer");
		int selection = k.nextInt();

		if (selection == 1) {
			while (!gameEnd) {

				System.out.println("Player 2 (Red) Turn");
				System.out.println("Enter the number key of the column you wish to place a game piece");
				loc = k.nextInt();
				if (loc > 7) {
					System.out.println("Invalid entry");
					System.out.println("Turn forfiet");
				} else {
					playerDrop(loc - 1, player1);
				}

			}
		}

		if (selection == 2) {
			while (!gameEnd) {
				System.out.println("Player 1 (Blue) Turn");
				System.out.println("Enter the number key from 1-7 of the column you wish to place a game piece");
				int loc = k.nextInt();
				if (loc > 7) {
					System.out.println("Invalid entry");
					System.out.println("Turn forfiet");
				} else {
					playerDrop(loc - 1, player1);
				}

				System.out.println("Computer (Red) Turn");
				loc = r.nextInt(7 - 1) + 1;
				playerDrop(loc - 1, player2);

			}

		}

	}

	static void player1Turn() {
		System.out.println("Player 1 (Blue) Turn");
		System.out.println("Enter the number key from 1-7 of the column you wish to place a game piece");
		loc = k.nextInt();
		gameBoard.colFull(loc-1);
		playerDrop(loc - 1, player1);
	}

	static void playerDrop(int col, Colour playerCol) {
		gameBoard.placePiece(col, playerCol);
	}

}
