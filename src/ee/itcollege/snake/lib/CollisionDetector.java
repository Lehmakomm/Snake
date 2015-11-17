package ee.itcollege.snake.lib;

import java.awt.geom.Area;
/**
 * Checking the presence of collisions of {@link IDrawable} objects
 * 
 * @author Mikk Mangus
 */
public class CollisionDetector {

	/**
	 * Check if there is a collision between two {@link IDrawable} bojects
	 * @param o1
	 * @param o2
	 * @return true, if there is a collision
	 */
	public static boolean collide(IDrawable o1, IDrawable o2) {
		Area thisArea = o1.getCollisionArea();
		Area substracted = new Area(thisArea);

		substracted.subtract(o2.getCollisionArea());
		
		// if the substraction of areas changes the area, there is a collision
		return !thisArea.equals(substracted);
	}

}
