import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * Code modified from textbook code
 */
public class ShapeIcon implements Icon {
	
	public ShapeIcon(CompositeShape shape, int width, int height) {
		this.shape = shape;
		this.width = width;
		this.height = height;
	}

	public int getIconWidth() {
		return width;
	}

	public int getIconHeight() {
		return height;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {

		Graphics2D g2 = (Graphics2D) g;
		shape.draw(g2);

	}
	
	private CompositeShape shape;
	private int width;
	private int height;


}
