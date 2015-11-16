package ee.itcollege.snake.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import ee.itcollege.snake.elements.Snake;

/**
 * The main game object that draws the gamefield
 */
public class GameField extends JPanel {

	private Snake snake = new Snake();
	private Image buffer;

	private Image getBuffer() {
		if (null == buffer) {
			// if there is no buffer object, create a new Image
			buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		}
		// fill the image with white
		Graphics g = buffer.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());

		return buffer;
	}

	@Override
	public void paintComponent(Graphics g) {
		Image buffer = getBuffer();
		Graphics2D g2 = (Graphics2D) buffer.getGraphics();

		snake.drawItself(g2);

		g.drawImage(buffer, 0, 0, null);
	}

	public Snake getSnake() {
		return snake;
	}
}
