package ee.itcollege.snake.elements;

import java.util.ArrayList;

import ee.itcollege.snake.lib.CollisionDetector;
import ee.itcollege.snake.lib.Direction;
import javafx.application.Platform;
import javafx.scene.Group;

public class Snake extends Group {

	private Direction direction = Direction.RIGHT;
	private ArrayList<SnakePart> parts = new ArrayList<SnakePart>();

	public Snake() {
		for (int i = 0; i < 10; i++) {
			SnakePart part = new SnakePart(100, 100 + i * SnakePart.SIZE);
			addPart(part);
		}
	}
	
	private void addPart(SnakePart part) {
		getChildren().add(part);
		parts.add(part);
	}
	

	public void move() {
		// move all the parts but the head
		for (int i = parts.size() - 1; i >= 1; i--) {
			SnakePart part = (SnakePart) parts.get(i);
			SnakePart previousPart = (SnakePart) parts.get(i - 1);
			part.setX(previousPart.getX());
			part.setY(previousPart.getY());
		}

		// move the head
		SnakePart head = getHead();
		switch (direction) {
			case RIGHT:
				head.setX(head.getX() + SnakePart.SIZE);
				break;
			case LEFT:
				head.setX(head.getX() - SnakePart.SIZE);
				break;
			case UP:
				head.setY(head.getY() - SnakePart.SIZE);
				break;
			case DOWN:
				head.setY(head.getY() + SnakePart.SIZE);
				break;
		}
		
	}
	
	public boolean collidesItself() {
		SnakePart head = getHead();
		// check if head collides with any part starting from the fifth
		for (int i = 4; i < parts.size(); i++) {
			if (CollisionDetector.collide(head, parts.get(i))) {
				return true;
			}
		}
		return false;
	}

	public SnakePart getHead() {
		return parts.get(0);
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		if (!this.direction.isOpposite(direction)) {
			this.direction = direction;
		}
	}

	public void eat(Edible food) {
		for (int i = 0; i < food.getCalories(); i++) {
			Platform.runLater(() -> addPart(new SnakePart(-1000, 0)));
		}
	}

}














