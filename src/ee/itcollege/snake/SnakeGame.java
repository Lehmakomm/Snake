package ee.itcollege.snake;

import ee.itcollege.snake.elements.Snake;
import ee.itcollege.snake.game.GameField;
import ee.itcollege.snake.lib.Direction;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
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
		
		window.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				Snake snake = gameField.getSnake();
				switch (event.getCode()) {
					case UP:
						snake.setDirection(Direction.UP);
						break;
					case DOWN:
						snake.setDirection(Direction.DOWN);
						break;
					case LEFT:
						snake.setDirection(Direction.LEFT);
						break;
					case RIGHT:
						snake.setDirection(Direction.RIGHT);
						break;
					case ESCAPE:
						System.exit(0);
				}
			}
		});
		
		window.setResizable(false);
		window.setTitle("Snake!");
		window.show();
		window.setOnCloseRequest(e -> System.exit(0));
		Platform.runLater(() -> {
			gameField.windowReady();
		});
		
//		PerspectiveCamera camera = new PerspectiveCamera(false);
//		camera.setFieldOfView(50);
//		camera.setNearClip(.1);
//		camera.setFarClip(1000);
//		camera.getTransforms().add(new Translate(0, 100, -250));
//		camera.getTransforms().add(new Rotate(60, Rotate.X_AXIS));
//		scene.setCamera(camera);
	}
	
	public static void main(String[] args) {
		launch(args);
	}


}
