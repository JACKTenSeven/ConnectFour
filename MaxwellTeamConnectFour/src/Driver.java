import java.util.Scanner;

public class Driver  {
	public static Board gameBoard = new Board(6,7);
	public static void main(String[]args){
		Scanner k = new Scanner(System.in);
		boolean gameEnd=false;
		Colour player1;
		Colour player2;
		//GOOD JOB
		
		player1 = Colour.Blue;
		player2 = Colour.Red;
		
		while (!gameEnd){
		System.out.println("Player 1 (Blue) Turn");
		System.out.println("Enter the number key from 1-7 of the column you wish to place a game piece");
		int loc = k.nextInt();
		if(loc>7){
			System.out.println("Invalid entry");
			System.out.println("Turn forfiet");
		}
		else{
		playerDrop(loc-1,player1);
		}
		
		
		System.out.println("Player 2 (Red) Turn");
		System.out.println("Enter the number key of the column you wish to place a game piece");
		 loc = k.nextInt();
		if(loc>7){
			System.out.println("Invalid entry");
			System.out.println("Turn forfiet");
		}
		else{
		playerDrop(loc-1,player2);
		}
	
		
		}
		
		
	}
	
	  static void playerDrop(int col, Colour playerCol){
		  System.out.println("HERE");
		  gameBoard.placePiece(col, playerCol);
	}

}
