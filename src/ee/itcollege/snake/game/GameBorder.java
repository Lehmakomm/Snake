package ee.itcollege.snake.game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class GameBorder extends Polygon {
	
	private static double BORDER = 20;

	public GameBorder(double width, double height) {
		super(new double[] {
				0, 0,
				width, 0,
				width, height,
				0, height,
				0, 0,
				BORDER, 0,
				BORDER, height - BORDER,
				width - BORDER, height - BORDER,
				width - BORDER, BORDER,
				0, BORDER
		});
		setFill(Color.GRAY);
	}
	
}
