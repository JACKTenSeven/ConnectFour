
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class GUIDriver extends Application {
	public static Board gameBoard = new Board(6, 7);
	public static Colour player1;
	public static Colour player2;
	public static Colour currentTurn;
	public static boolean isWinner = false;
	public static Colour gameWinner;
	
	
	static int a;
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage window) throws Exception {

		player1 = Colour.Red;
		player2 = Colour.Blue;

		currentTurn = Colour.Red;
		VBox box = new VBox();
		box.setAlignment(Pos.TOP_CENTER);

		Text turnAndWinnerText = new Text();
		turnAndWinnerText.setText(currentTurn + "'s turn");
		turnAndWinnerText.setFont(Font.font("Verdana", 60));
		turnAndWinnerText.setTextAlignment(TextAlignment.CENTER);

		GridPane gridOut = new GridPane();
		gridOut.setAlignment(Pos.TOP_CENTER);

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		box.getChildren().add(turnAndWinnerText);
		gridOut.add(grid, 0, 1);

		gridOut.add(box, 0, 0);

		Circle[][] circ = new Circle[6][7];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				circ[i][j] = new Circle(0, 0, 25);

				// circ[i][j].setFill(javafx.scene.paint.Color.GREY); //grey
				circ[i][j].setOpacity(0.6);
				grid.add(circ[i][j], j, i + 2);
			}
		}

		upDateBoardColour(circ);

		Button[] buttons = new Button[7];
		for (int i = 0; i < buttons.length; i++) {
			int j = i;

			buttons[i] = new Button();
			grid.add(buttons[i], i, 1);

			buttons[i].addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					highlightColumn(j, circ);
					highLightPiece(circ,j);
				}	
			});

			buttons[i].addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					unHighlightColumn(j, circ);
				
					if(a != -1){
						circ[a][j].setFill(javafx.scene.paint.Color.GREY);
					}
					upDateBoardColour(circ);
				}
			});

			buttons[i].setText("Here");

			buttons[i].setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					if (isWinner) {
						turnAndWinnerText.setText(gameWinner + " Already won");
					} 
					
					else if (gameBoard.colFull(j) != true) {
						Colour winner = gameBoard.placePiece(j, currentTurn);
						
						upDateBoardColour(circ);
						
						if (currentTurn == Colour.Red)
							currentTurn = Colour.Blue;
						else
							currentTurn = Colour.Red;
						
						highLightPiece(circ,j);
						
						if (winner == Colour.None) {
							turnAndWinnerText.setText(currentTurn + "'s turn");
						} else {
							turnAndWinnerText.setText(winner + " wins!");
							gameWinner = winner;
							isWinner = true;
						}

					} else {
						turnAndWinnerText.setText("Redo, " + currentTurn);
					}
					
				
				}
			});

		}

		Scene scene = new Scene(gridOut, 600, 500);

		window.setTitle("Connect four");
		window.setScene(scene);
		window.show();

	}

	private static void highlightColumn(int col, Circle[][] circ) {
		for (int j = 0; j < 6; j++) {

			circ[j][col].setOpacity(1);
		}
	}

	private static void highLightPiece(Circle[][] circ, int col){
		highlightColumn(col, circ);
		a = gameBoard.topRowAvailable(col);
		if(a != -1){
			if(currentTurn == Colour.Blue)
			circ[a][col].setFill(javafx.scene.paint.Color.BLUE);
			
			if(currentTurn == Colour.Red)
				circ[a][col].setFill(javafx.scene.paint.Color.RED);
		}
	
	}
	
	private static void upDateBoardColour(Circle[][] circ) {
		for (int i = 0; i < circ.length; i++) {
			for (int j = 0; j < circ[0].length; j++) {
				if (gameBoard.board[i][j].getColour().equals(Colour.Blue)) {
					circ[i][j].setFill(javafx.scene.paint.Color.BLUE);
				} else if (gameBoard.board[i][j].getColour().equals(Colour.Red)) {
					circ[i][j].setFill(javafx.scene.paint.Color.RED);
				} else {
					circ[i][j].setFill(javafx.scene.paint.Color.GREY);
				}
			}
		}
	}

	private static void unHighlightColumn(int col, Circle[][] circ) {
		for (int j = 0; j < 6; j++) {

			circ[j][col].setOpacity(0.6);
		}
	}

}
