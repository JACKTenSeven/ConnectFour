
public class Board {
	private int numBlues;
	private int numReds;
	
	public GamePiece[][] board;	
	
	public Board(int rows, int cols){
		board=new GamePiece[rows][cols];
		for(int i = 0 ; i < board.length ; i++){
			for(int j = 0 ; j < board[0].length ; j++){
				board[i][j] = new GamePiece(Colour.None);
			}
		}
	}
	/**
	 * places piece of the desired colour at the top of the column desired
	 * @param col	the column to place the piece
	 * @param colour	colour of the piece
	 */
	public void placePiece(int col, Colour colour){
		
		board[0][col] = new GamePiece(colour);
	
		int rowNum = pieceFall(col,colour);
		if(rowNum != 0){
			board[0][col] = new GamePiece(Colour.None);
		}
		if(colour == Colour.Red){numReds++;}
		else if(colour== Colour.Blue){numBlues++;}
		printBoard();
		Colour winner = isWinner(rowNum,col);
		System.out.println(winner);
	}
	
	/**
	 * Makes the piece at the top of the column go
	 * to the lowest possible position on the board
	 * @param col	The column where the just placed piece is
	 * @param colour	the colour of the piece, red or blue
	 */
	private int pieceFall(int col, Colour colour){
		for(int i = 1; i < board.length; i++){
			if(i == board.length-1 && board[i][col].getColour() == Colour.None){
				board[i][col] = new GamePiece(colour);
				return i;
			}
			else if(board[i][col].getColour() == Colour.None){
				continue;
			}
			else if(board[i][col].getColour() != Colour.None){
				board[i-1][col] = new GamePiece(colour);
				return i-1;
			}
			
			
			
		}
		return 0;
	}
	/**
	 * checks the rows, columns and diagonals around the piece specified 
	 * to determine if their is four in a row of the colour
	 * @param row	The row position of the piece tested
	 * @param col	The column position of the piece tested
	 * @return	The colour of the person who has one, or none if no-one has won.
	 */
	private Colour isWinner(int row, int col){
		
		Colour colourChecking = board[row][col].getColour();
		int numInARow = 0;
		//Checking the row
		for(int i = 0 ; i < board.length ; i ++){
			if(board[i][col].getColour() == colourChecking){
				numInARow++;
				if(numInARow >=4){
					return colourChecking;
				}
			}
			else{
				numInARow = 0;
			}
		}
		numInARow = 0;
		//Checking the column
		for(int i = 0 ; i < board[0].length ; i ++){
			if(board[row][i].getColour() == colourChecking){
				numInARow++;
				if(numInARow >=4){
					return colourChecking;
				}
			}
			else{
				numInARow = 0;
			}
		}
		
		
		
		numInARow = 0;
		
		
		//Checking the diagonal from bottom left to top right
		int bottomOfDiagonalRow = row + col;
		int bottomOfDiagonalCol = 0;
		if((row + col) > board.length-1){
			bottomOfDiagonalRow = board.length-1;
			bottomOfDiagonalCol = row+col - (board.length-1);

		}

		for(int i = 0; bottomOfDiagonalRow -i >= 0 
				&& bottomOfDiagonalCol + i < board.length; i++){
			 
			if(board[bottomOfDiagonalRow -i][bottomOfDiagonalCol + i].getColour() == colourChecking){
				numInARow++;
				if(numInARow >=4){
					return colourChecking;
				}
			}
			else{
				numInARow = 0;
			}
		}
		
		numInARow = 0;
		//checking the diagonal from top left to bottom right
		int topOfDiagonalRow = row - col;
		int topOfDiagonalCol = 0;
		if((row - col) < 0){
			topOfDiagonalRow = 0;
			topOfDiagonalCol = -1*(row-col);

		}
		
		
		for(int i = 0; topOfDiagonalRow + i < board.length
				&& topOfDiagonalCol + i < board[0].length; i++){
			 
			if(board[topOfDiagonalRow + i][topOfDiagonalCol + i].getColour() == colourChecking){
				numInARow++;
				if(numInARow >=4){
					return colourChecking;
				}
			}
			else{
				numInARow = 0;
			}
		}
		
		
		return Colour.None;
	}
	
	public boolean colFull(int col){
		for(int i = 0 ; i < board.length ; i ++){
			if(board[i][col].getColour().equals(Colour.None)){
				return false;
			}
		}
		return true;
	}
	
	public void printBoard(){
		for(int i=0;i < board.length ; i++){
			for(int j = 0 ; j < board[0].length ; j++){
				if(board[i][j].getColour() == Colour.None){
					System.out.print(" X");
				}
				else if(board[i][j].getColour() == Colour.Red){
					System.out.print(" R");
				}else if(board[i][j].getColour() == Colour.Blue){
					System.out.print(" B");
				}
			}
			System.out.println();
		}
		System.out.println();
	}


	
}
