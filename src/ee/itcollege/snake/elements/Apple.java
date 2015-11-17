package ee.itcollege.snake.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import ee.itcollege.snake.lib.IDrawable;
import ee.itcollege.snake.lib.IEdible;

public class Apple implements IDrawable, IEdible {
	
	private int x;
	private int y;
	
	public Apple(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public Area getCollisionArea() {
		int size = 30;
		return new Area(new Ellipse2D.Double(x, y, size, size));
	}

	@Override
	public void drawItself(Graphics2D g) {
		g.setColor(Color.red);
		g.fill(getCollisionArea());
	}

	@Override
	public int getCalories() {
		return 2;
	}

}
