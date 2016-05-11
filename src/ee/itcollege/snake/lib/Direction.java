package ee.itcollege.snake.lib;

public enum Direction {
	LEFT, RIGHT, UP, DOWN;

	public boolean isOpposite(Direction other) {
		switch (this) {
			case DOWN:
				return UP.equals(other);
			case LEFT:
				return RIGHT.equals(other);
			case RIGHT:
				return LEFT.equals(other);
			case UP:
				return DOWN.equals(other);
		}
		throw new IllegalStateException("Direction " + this + " not implemented!!!");
	}
}
