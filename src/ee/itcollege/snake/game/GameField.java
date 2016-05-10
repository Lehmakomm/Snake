package ee.itcollege.snake.game;

import ee.itcollege.snake.elements.Snake;
import javafx.scene.layout.Pane;

/**
 * The main game object that holds the gamefield
 */
public class GameField extends Pane {

	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	
	private Snake snake = new Snake();
	
	public GameField() {
		getChildren().add(snake);
	}
	
	public void tick() {
		snake.move();
	}

	public Snake getSnake() {
		return snake;
	}
}
