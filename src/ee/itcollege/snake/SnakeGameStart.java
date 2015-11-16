package ee.itcollege.snake;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import ee.itcollege.snake.lib.Direction;
import ee.itcollege.snake.parts.GameField;
import ee.itcollege.snake.parts.Snake;

public class SnakeGameStart implements Runnable {
	
	GameField game = new GameField();
	JFrame window = new JFrame("Uss!!");
	
	@Override
	public void run() {
        window.setSize(500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        window.add(game);
        window.setVisible(true);
        
        
        window.addKeyListener(new KeyAdapter() {
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
                }
                if (null != direction) {
                	snake.setDirection(direction);
                }
                snake.move();
                game.repaint();
            }
        });
		
	}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new SnakeGameStart());
    }
}
