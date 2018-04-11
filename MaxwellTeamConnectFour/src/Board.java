
public class Board {

	private GamePiece[][] board= new GamePiece[6][7];	
	
	public void changeBoard(int row, int col, Colour colour){
		board[row][col] = new GamePiece(colour);
	}

	//YOU LIKE THAt
	
}
