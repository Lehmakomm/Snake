package ee.itcollege.snake.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameAnimator implements ActionListener {
	
	private GameField game;
	
	public GameAnimator(GameField game) {
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		game.getSnake().move();
		game.repaint();
	}
}