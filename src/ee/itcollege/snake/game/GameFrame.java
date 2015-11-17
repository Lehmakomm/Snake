package ee.itcollege.snake.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

import ee.itcollege.snake.lib.IDrawable;

public class GameFrame implements IDrawable {
	
	
	public GameFrame() {
	}

	@Override
	public Area getCollisionArea() {
		Area area = new Area();
		// top
		area.add(new Area(new Rectangle2D.Double(0, 0, GameField.WIDTH, 20)));
		// left
		area.add(new Area(new Rectangle2D.Double(0, 0, 20, GameField.HEIGHT)));
		// bottom
		area.add(new Area(new Rectangle2D.Double(0, GameField.HEIGHT - 20, GameField.WIDTH, 20)));
		// right
		area.add(new Area(new Rectangle2D.Double(GameField.WIDTH - 20, 0, 20, GameField.HEIGHT)));
		return area;
	}

	@Override
	public void drawItself(Graphics2D g) {
		g.setColor(Color.gray);
		g.fill(getCollisionArea());
	}

}
