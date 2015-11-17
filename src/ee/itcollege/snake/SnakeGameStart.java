package ee.itcollege.snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import ee.itcollege.snake.elements.Snake;
import ee.itcollege.snake.game.GameField;
import ee.itcollege.snake.game.GameKeyListener;
import ee.itcollege.snake.lib.Direction;

public class SnakeGameStart implements Runnable {

	GameField game = new GameField();
	JFrame window = new JFrame("Uss!!");
	
	@Override
	public void run() {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				Document document;
				try {
					document = Jsoup.connect("http://postimees.ee").get();
					String title = document.select("h1.frontHeading").first().text();
					window.setTitle(title);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}).start();

		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(game);
		window.pack();
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
					case KeyEvent.VK_ESCAPE:
						System.exit(0);
						break;
					case KeyEvent.VK_S:
						saveGame();
						break;
					case KeyEvent.VK_L:
						loadGame();
						break;
				}
				if (null != direction) {
					snake.setDirection(direction);
				}
			}
		});
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				game.tick();
			}
		}, 1500, 1500);
	}
	
	public void saveGame() {
		try {
			ObjectOutputStream saver = new ObjectOutputStream(
			new FileOutputStream(new File("gameData.txt")));
			saver.writeObject(game);
			saver.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void loadGame() {
		try {
			ObjectInputStream loader = new ObjectInputStream(
			new FileInputStream(new File("gameData.txt")));
			GameField oldGame = (GameField) loader.readObject();
			loader.close();
			
			this.game = oldGame;
			this.window.setContentPane(oldGame);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new SnakeGameStart());
	}
}
