
public class Board {

	private int numBlues;
	private int numReds;
	
	public GamePiece[][] board= new GamePiece[6][7];	
	
	/**
	 * places piece of the desired colour at the top of the column desired
	 * @param col	the column to place the piece
	 * @param colour	colour of the piece
	 */
	public void placePiece(int col, Colour colour){
		board[0][col] = new GamePiece(colour);
	
		int rowNum = pieceFall(col,colour);
		
		board[0][col] = null;
		
		if(colour == Colour.Red){numReds++;}
		else if(colour== Colour.Blue){numBlues++;}
		printBoard();
		Colour winner = isWinner(rowNum,col);
	}
	/**
	 * Makes the piece at the top of the column go
	 * to the lowest possible position on the board
	 * @param col	The column where the just placed piece is
	 * @param colour	the colour of the piece, red or blue
	 */
	private int pieceFall(int col, Colour colour){
		for(int i = 1; i < board.length; i++){
			if(i == board.length-1 && board[i][col] == null){
				board[i][col] = new GamePiece(colour);
				return i;
			}
			else if(board[i][col] == null){
				continue;
			}
			else if(board[i][col] != null){
				board[i-1][col] = new GamePiece(colour);
				return i-1;
			}
			
			
			
		}
		return 0;
	}
	
	private Colour isWinner(int row, int col){
		Colour colourChecking = board[row][col].pieceColour;
		for(int i = -1 ; i <= 0 ; i++){
			
		}
		return null;
	}
	
	public void printBoard(){
		for(int i=0;i < board.length ; i++){
			for(int j = 0 ; j < board[0].length ; j++){
				if(board[i][j] == null){
					System.out.print(" X");
				}
				else if(board[i][j].pieceColour == Colour.Red){
					System.out.print(" R");
				}else if(board[i][j].pieceColour == Colour.Blue){
					System.out.print(" B");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	//YOU LIKE THAt
	
}
