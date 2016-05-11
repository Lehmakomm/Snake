package ee.itcollege.snake.elements;

public interface Edible {

	public int getCalories();
	
	public default boolean isPoison() {
		return false; // default abstract method only from Java 8
	}
}
