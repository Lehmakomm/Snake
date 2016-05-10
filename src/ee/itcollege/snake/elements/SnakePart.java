package ee.itcollege.snake.elements;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SnakePart extends Rectangle {

	public static final int SIZE = 20;

	public SnakePart(int x, int y) {
		super(x, y, SIZE - 1, SIZE - 1);
		setFill(Color.BLACK);
	}

}
