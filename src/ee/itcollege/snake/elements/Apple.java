package ee.itcollege.snake.elements;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Apple extends Circle implements Edible {

	private static final int APPLE_RADIUS = 20;

	public Apple(double x, double y) {
		super(x, y, APPLE_RADIUS, Color.RED);
	}

	@Override
	public int getCalories() {
		return 2;
	}
	
}
