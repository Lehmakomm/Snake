package ee.itcollege.snake;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import ee.itcollege.snake.game.GameAnimator;
import ee.itcollege.snake.game.GameField;
import ee.itcollege.snake.game.GameKeyListener;

public class SnakeGameStart implements Runnable {

	GameField game = new GameField();
	JFrame window = new JFrame("Uss!!");
	
	@Override
	public void run() {
		window.setSize(500, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(game);
		window.setVisible(true);
		window.addKeyListener(new GameKeyListener(game));
		
		Timer timer = new Timer(100, new GameAnimator(game));
		timer.start();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new SnakeGameStart());
	}
}
