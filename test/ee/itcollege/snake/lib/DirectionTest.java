package ee.itcollege.snake.lib;

import static org.junit.Assert.*;

import org.junit.Test;

public class DirectionTest {

	@Test
	public void testSimpleOpposite() {
		assertTrue(Direction.DOWN.isOpposite(Direction.UP));
		assertTrue(Direction.RIGHT.isOpposite(Direction.LEFT));
		
		assertFalse(Direction.DOWN.isOpposite(Direction.RIGHT));
		assertFalse(Direction.UP.isOpposite(Direction.LEFT));
		
		assertEquals("The same values in different order should return the same", Direction.LEFT.isOpposite(Direction.DOWN),
				Direction.DOWN.isOpposite(Direction.LEFT));
	}
	
	@Test
	public void testExtremeOpposite() {
		assertFalse(Direction.DOWN.isOpposite(Direction.DOWN));
		
		assertFalse(Direction.RIGHT.isOpposite(Direction.RIGHT));
		
		assertTrue(Direction.LEFT.isOpposite(Direction.RIGHT));
		
		assertFalse(Direction.LEFT.isOpposite(null));
		assertFalse(Direction.RIGHT.isOpposite(null));
		assertFalse(Direction.UP.isOpposite(null));
	}

}
