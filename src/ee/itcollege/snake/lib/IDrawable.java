package ee.itcollege.snake.lib;

import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.io.Serializable;

/**
 * Interface for drawable and collidable objects
 *
 * @author Mikk Mangus
 */
public interface IDrawable extends Serializable {

	/**
	 * Area for collisions
	 * 
	 * @return
	 */
	public Area getCollisionArea();

	public void drawItself(Graphics2D g);

}