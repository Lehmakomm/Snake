package ee.itcollege.snake.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;

import ee.itcollege.snake.lib.IDrawable;

public class SnakePart implements IDrawable {

	public static final int SIZE = 20;
	
	int x;
	int y;
	Color color;

	public SnakePart(int x, int y) {
		this.x = x;
		this.y = y;
		color = new Color(randomTone(), randomTone(), randomTone());
	}
	
	private static int randomTone() {
		return (int)(Math.random() * 200);
	}

	@Override
	public void drawItself(Graphics2D g) {
		g.setColor(color);
		g.fill(getCollisionArea());
	}

	@Override
	public Area getCollisionArea() {
		return new Area(new Rectangle(x, y, SIZE, SIZE));
	}

}
