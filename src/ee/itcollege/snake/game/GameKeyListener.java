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

	

}
