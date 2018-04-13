
public class Board {

	public GamePiece[][] board= new GamePiece[6][7];	
	
	public void placePiece(int col, Colour colour){
		board[0][col] = new GamePiece(colour);
		printBoard();
		pieceFall(col,colour);
		
		board[0][col] = null;
		printBoard();
	}
	
	private void pieceFall(int col, Colour colour){
		for(int i = 1; i < board.length; i++){
			if(i == board.length-1){
				board[i][col] = new GamePiece(colour);
			}
			else if(board[i][col] == null){
				continue;
			}
			else if(board[i][col] != null){
				board[i-1][col] = new GamePiece(colour);
			}
			
			
		}
	}
	
	
	public void printBoard(){
		for(int i=0;i < board.length ; i++){
			for(int j = 0 ; j < board[0].length ; j++){
				if(board[i][j] == null){
					System.out.print("X");
				}
				else if(board[i][j].pieceColour == Colour.Red){
					System.out.print("R");
				}else if(board[i][j].pieceColour == Colour.Blue){
					System.out.print("B");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	//YOU LIKE THAt
	
}
