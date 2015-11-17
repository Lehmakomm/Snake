package ee.itcollege.snake.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import ee.itcollege.snake.elements.Snake;
import ee.itcollege.snake.lib.Direction;

public class GameKeyListener extends KeyAdapter {
	
	GameField game;
	
	public GameKeyListener(GameField game) {
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Snake snake = game.getSnake();
		Direction direction = null;
		switch (e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				direction = Direction.RIGHT;
				break;
			case KeyEvent.VK_LEFT:
				direction = Direction.LEFT;
				break;
			case KeyEvent.VK_DOWN:
				direction = Direction.DOWN;
				break;
			case KeyEvent.VK_UP:
				direction = Direction.UP;
				break;
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
				break;
		}
		if (null != direction) {
			snake.setDirection(direction);
		}
	}

}
