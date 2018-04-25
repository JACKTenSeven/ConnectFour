

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
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		Button button1 = new Button();
		Button button2 = new Button();
		Button button3 = new Button();
		Button button4 = new Button();
		Button button5 = new Button();
		Button button6 = new Button();
		Button button7 = new Button();
		Circle slot0 = new Circle();
		
		
		grid.add(button1, 0,0);
		grid.add(button2,1,0);
		grid.add(button3, 2,0);
		grid.add(button4,3,0);
		grid.add(button5, 4,0);
		grid.add(button6,5,0);
		grid.add(button7, 6,0);
		
		vbox.getChildren().add(slot0);
		grid.add(vbox, 4, 5);
		
		
		
		button1.setText("Place 1");
		button2.setText("Place 2");
		button3.setText("Place 3");
		button4.setText("Place 4");
		button5.setText("Place 5");
		button6.setText("Place 6");
		button7.setText("Place 7");
		
		
	
		
		Scene scene = new Scene(grid, 600, 200);
		
		button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Button button3 = new Button();
            
            	
            }
        });
		
		button2.addEventHandler(MouseEvent.MOUSE_ENTERED, 
				new EventHandler<MouseEvent>() {
			 @Override
			public void handle(MouseEvent e){
				button2.setText("yes");
			}
		});
		
		button2.addEventHandler(MouseEvent.MOUSE_EXITED, 
				new EventHandler<MouseEvent>() {
			 @Override
			public void handle(MouseEvent e){
				button2.setText("Place 2");
			}
		});


		window.setTitle("My JavaFX Application");
		window.setScene(scene);
		window.show();

	}
	
	

	
}
