

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
import javafx.stage.Stage;
public class GUIDriver extends Application {
	public static Board gameBoard = new Board(6, 7);
	public static Colour player1;
	public static Colour player2;
	
	

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage window) throws Exception {
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		//VBox vbox = new VBox();
	//	vbox.setAlignment(Pos.CENTER);
		
		
	
		
		
		Circle[][] circ = new Circle[6][7];
		for(int i = 0 ; i < 6 ; i++){
			for(int j = 0 ; j < 7 ; j++){
				circ[i][j] = new Circle(0,0,25);
				if(Math.random() > 0.5)
					circ[i][j].setFill(javafx.scene.paint.Color.BLUE); //grey
				else
					circ[i][j].setFill(javafx.scene.paint.Color.DARKRED);
				
				circ[i][j].setOpacity(0.6);
				grid.add(circ[i][j],j,i+1);
			}
		}
		
		Button[] buttons = new Button[7];
		for(int i = 0 ; i < buttons.length ; i++){
			int j = i;
			
			buttons[i] = new Button();
			grid.add(buttons[i], i, 0);
			
			buttons[i].addEventHandler(MouseEvent.MOUSE_ENTERED, 
					new EventHandler<MouseEvent>() {
				 @Override
				public void handle(MouseEvent e){
					highlightColumn(j, circ);
					
				}
			});
			
			buttons[i].addEventHandler(MouseEvent.MOUSE_EXITED, 
					new EventHandler<MouseEvent>() {
				 @Override
				public void handle(MouseEvent e){
					 unHighlightColumn(j, circ);
					
				}
			});
			
			buttons[i].setText("Here");
			
		}
		
	
	
		
		Scene scene = new Scene(grid, 600, 500);


		window.setTitle("Connect four");
		window.setScene(scene);
		window.show();

	}
	
	private static void highlightColumn(int col,Circle[][] circ){
		for(int j = 0 ; j < 6 ; j++){
			
			
			circ[j][col].setOpacity(1);
		}
	}
	
	private static void unHighlightColumn(int col,Circle[][] circ){
		for(int j = 0 ; j < 6 ; j++){
			
			
			circ[j][col].setOpacity(0.6);
		}
	}
	
	

	
}
