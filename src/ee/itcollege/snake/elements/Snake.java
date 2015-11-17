package ee.itcollege.snake.elements;

import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.LinkedList;

import ee.itcollege.snake.lib.CollisionDetector;
import ee.itcollege.snake.lib.Direction;
import ee.itcollege.snake.lib.IDrawable;
import ee.itcollege.snake.lib.IEdible;

public class Snake implements IDrawable {

	private ArrayList<SnakePart> parts = new ArrayList<SnakePart>();
	private LinkedList<Direction> directionOrders = new LinkedList<>();

	private Direction direction = Direction.RIGHT;

	public Snake() {
		for (int i = 0; i < 10; i++) {
			SnakePart part = new SnakePart(100, 100 + i * SnakePart.SIZE);
			parts.add(part);
		}
	}

	@Override
	public void drawItself(Graphics2D g) {
		for (SnakePart part : parts) {
			part.drawItself(g);
		}
	}

	@Override
	public Area getCollisionArea() {
		return getHead().getCollisionArea();
	}
	
	public void eat(IEdible food) {
		for (int i = 0; i < food.getCalories(); i++) {
			parts.add(new SnakePart(-100, -100));
		}
	}
	
	public boolean collidesItself() {
		SnakePart head = getHead();
		for (int i = 4; i < parts.size(); i++) {
			if (CollisionDetector.collide(head, parts.get(i))) {
				return true;
			}
		}
		return false;
	}

	public void move() {
		if (!directionOrders.isEmpty()) {
			this.direction = directionOrders.removeFirst();
		}
		
		// move all the parts but the head
		for (int i = parts.size() - 1; i >= 1; i--) {
			SnakePart part = parts.get(i);
			part.x = parts.get(i - 1).x;
			part.y = parts.get(i - 1).y;
		}

		// move the head
		SnakePart head = getHead();
		switch (direction) {
			case RIGHT:
				head.x += SnakePart.SIZE;
				break;
			case LEFT:
				head.x -= SnakePart.SIZE;
				break;
			case UP:
				head.y -= SnakePart.SIZE;
				break;
			case DOWN:
				head.y += SnakePart.SIZE;
				break;
		}
		
	}

	public SnakePart getHead() {
		return parts.get(0);
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		
		Direction last;
		if (directionOrders.isEmpty()) {
			last = this.direction;
		}
		else {
			last = directionOrders.getLast();
		}
		
		if (!last.isOpposite(direction) && !last.equals(direction)) {
			directionOrders.add(direction);
		}
	}

}














