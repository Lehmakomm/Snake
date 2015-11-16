package ee.itcollege.snake.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;

import ee.itcollege.snake.lib.IDrawable;

public class SnakePart implements IDrawable {

	int x;
	int y;
	int size = 10;

	public SnakePart(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void drawItself(Graphics2D g) {
		g.setColor(Color.black);
		g.fill(getArea());
	}

	@Override
	public Area getArea() {
		return new Area(new Rectangle(x, y, size, size));
	}

}
