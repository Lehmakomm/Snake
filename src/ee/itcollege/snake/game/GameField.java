package ee.itcollege.snake.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import ee.itcollege.snake.elements.Apple;
import ee.itcollege.snake.elements.Snake;
import ee.itcollege.snake.lib.CollisionDetector;

/**
 * The main game object that draws the gamefield
 */
public class GameField extends JPanel {

	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	
	private Snake snake = new Snake();
	private GameFrame frame = new GameFrame();
	private ArrayList<Apple> apples = new ArrayList<>();
	
	public void tick() {
		snake.move();
		
		if (CollisionDetector.collide(snake, frame)) {
			System.out.println("Hit the wall!");
			System.exit(0);
		}
		
		if (snake.collidesItself()) {
			System.out.println("Snake hit itself!");
			System.exit(0);
		}
		
		// create apples
		while (apples.size() < 3) {
			apples.add(new Apple(
					(int)(Math.random() * getWidth()), 
					(int)(Math.random() * getHeight())
					));
		}
		
		for (int i = 0; i < apples.size(); i++) {
			Apple apple = apples.get(i);
			if (CollisionDetector.collide(snake, apple)) {
				snake.eat(apples.remove(i--));
			}			
		}
		
		
		repaint();
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH, HEIGHT);
	}


	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		frame.drawItself(g2);
		
		for (Apple apple : apples) {
			apple.drawItself(g2);		
		}
		snake.drawItself(g2);
	}

	public Snake getSnake() {
		return snake;
	}
}
