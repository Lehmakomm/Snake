package ee.itcollege.snake.lib;

import javafx.scene.shape.Shape;
/**
 * Checking the presence of collisions of shapes
 * 
 * @author Mikk Mangus
 */
public class CollisionDetector {

	/**
	 * Check if there is a collision between two shapes
	 * @param s1
	 * @param s2
	 * @return true, if there is a collision
	 */
	public static boolean collide(Shape s1, Shape s2) {
		return s1.getBoundsInParent().intersects(s2.getBoundsInParent());
	}

}
