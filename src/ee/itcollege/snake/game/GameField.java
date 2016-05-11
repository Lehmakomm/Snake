package ee.itcollege.snake.game;

import java.util.Timer;
import java.util.TimerTask;

import ee.itcollege.snake.elements.Apple;
import ee.itcollege.snake.elements.Snake;
import ee.itcollege.snake.lib.CollisionDetector;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * The main game object that holds the gamefield
 */
public class GameField extends Pane {

	private Snake snake = new Snake();
	private Apple apple;
	private GameBorder gameBorder;
	private Timer timer = new Timer();
	private Label pointsLabel = new Label("punktid siia!");
	
	public GameField() {
		getChildren().add(snake);
		
		pointsLabel.setLayoutX(100);
		pointsLabel.setLayoutY(100);
		getChildren().add(pointsLabel);
	}
	
	// starts the game
	public void windowReady() {
		gameBorder = new GameBorder(getWidth(), getHeight());
		getChildren().add(gameBorder);
		createAppleAtRandomPlace();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				tick();
			}
		}, 100, 100);
	}
	
	public void createAppleAtRandomPlace() {
		apple = new Apple(Math.random() * getWidth(), Math.random() * getHeight());
		getChildren().add(apple);
	}
	
	public void tick() {
		snake.move();
		
		if (CollisionDetector.collide(snake.getHead(), apple)) {
			Platform.runLater(() -> {
				snake.eat(apple);
				getChildren().remove(apple);
				createAppleAtRandomPlace();
			});
		}
		
		if (snake.collidesItself() || !CollisionDetector.collide(snake.getHead(), gameBorder)) {
			gameOver();
		}
	}

	public Snake getSnake() {
		return snake;
	}
	
	public void gameOver() {
		timer.cancel();
	}
}
