import javafx.scene.shape.Circle;

public class NeuralNetworkTrainingManager {

	private static int[] input = new int[42];
	private static int [] output = new int[1];

	private static GUIDriver driver;

	public static void main(String[] args) {

		collectInput();
	}
		
		private static void collectInput(){
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 7; j++) {

					if (driver.gameBoard.board[i][j].getColour() == Colour.Red) {
						input[i * j] = 1;

					}
					else if (driver.gameBoard.board[i][j].getColour() == Colour.Red) {
						input[i * j] = 2;

					}
					else{
						
						input[i * j] = 0;
					}
				}
			}
		}
	
}
