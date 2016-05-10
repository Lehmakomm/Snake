package ee.itcollege.snake;

import ee.itcollege.snake.game.GameField;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

@SuppressWarnings("incomplete-switch")
public class SnakeGame extends Application {

	GameField gameField = new GameField();
	
	@Override
	public void start(Stage window) throws Exception {
		
		Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
		Scene scene = new Scene(gameField, screenSize.getWidth() / 2, screenSize.getHeight() / 2, false, SceneAntialiasing.BALANCED);
		window.setScene(scene);
		window.setTitle("Snake!");
		window.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
			switch (event.getCode()) {
				case UP:
					System.out.println("tere!");
					break;
			}
		});
		window.show();
		window.setOnCloseRequest(e -> System.exit(0));
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}


}
