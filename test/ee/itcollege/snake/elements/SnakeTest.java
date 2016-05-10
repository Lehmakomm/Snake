package ee.itcollege.snake.elements;

import static org.junit.Assert.*;

import org.junit.Test;

import ee.itcollege.snake.lib.Direction;

public class SnakeTest {

	@Test
	public void testInitialDirection() {
		Snake s = new Snake();
		assertEquals(Direction.RIGHT, s.getDirection());
	}
	
	@Test
	public void testOppositeTurn() {
		Snake s = new Snake();
		s.setDirection(Direction.LEFT);
		assertEquals(Direction.RIGHT, s.getDirection());
		s.move();
		assertEquals(Direction.RIGHT, s.getDirection());
		
		s = new Snake();
		s.setDirection(Direction.UP);
		assertEquals(Direction.RIGHT, s.getDirection());
		s.move();
		assertEquals(Direction.UP, s.getDirection());
		
		s = new Snake();
		s.setDirection(Direction.DOWN);
		s.setDirection(Direction.LEFT);
		assertEquals(Direction.RIGHT, s.getDirection());
		s.move();
		assertEquals(Direction.DOWN, s.getDirection());
		
		s = new Snake();
		s.setDirection(Direction.DOWN);
		s.move();
		assertEquals(Direction.DOWN, s.getDirection());
		s.setDirection(Direction.LEFT);
		assertEquals(Direction.DOWN, s.getDirection());
		s.move();
		assertEquals(Direction.LEFT, s.getDirection());
		
		s = new Snake();
		s.setDirection(Direction.UP);
		s.setDirection(Direction.LEFT);
		s.setDirection(Direction.DOWN);
		assertEquals(Direction.RIGHT, s.getDirection());
		s.move();
		assertEquals(Direction.UP, s.getDirection());
		s.move();
		assertEquals(Direction.LEFT, s.getDirection());
		s.move();
		assertEquals(Direction.DOWN, s.getDirection());
		
		
		s = new Snake();
		s.setDirection(Direction.LEFT);
		s.setDirection(Direction.DOWN);
		s.setDirection(Direction.DOWN);
		s.setDirection(Direction.UP);
		s.setDirection(Direction.LEFT);
		assertEquals(Direction.RIGHT, s.getDirection());
		s.move();
		assertEquals(Direction.DOWN, s.getDirection());
		s.move();
		assertEquals(Direction.LEFT, s.getDirection());
		s.move();
		assertEquals(Direction.LEFT, s.getDirection());
		s.move();
		assertEquals(Direction.LEFT, s.getDirection());
	}
	
	@Test
	public void testOppositeTurnComplex() {
		Snake s = new Snake();
		s.setDirection(Direction.UP);
		s.move();
		assertEquals(Direction.UP, s.getDirection());
		
		s.setDirection(Direction.DOWN);
		assertEquals(Direction.UP, s.getDirection());
		s.move();
		assertEquals(Direction.UP, s.getDirection());

		s.setDirection(Direction.LEFT);
		s.move();
		assertEquals(Direction.LEFT, s.getDirection());

		s.setDirection(Direction.RIGHT);
		s.move();
		assertEquals(Direction.LEFT, s.getDirection());
		
		s.setDirection(Direction.UP);
		assertEquals(Direction.LEFT, s.getDirection());
		s.move();
		assertEquals(Direction.UP, s.getDirection());
	}

}
