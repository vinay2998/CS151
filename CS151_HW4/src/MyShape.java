
//Code borrowed from CarShape which was borrowed from textbook

import java.awt.*;
import java.awt.geom.*;

/**
 * Borrowed from textbook
 */
public class MyShape implements CompositeShape {
	/**
	 * Constructs a snowman item.
	 * 
	 * @param x     the left of the bounding rectangle
	 * @param y     the top of the bounding rectangle
	 * @param width the width of the bounding rectangle
	 */
	public MyShape(int x, int y, int width) {
		this.x = x;
		this.y = y;
		this.width = width;
	}

	public void translate(int dx, int dy) {
		x += dx;
		y += dy;
	}

	public void draw(Graphics2D g2) {
		Rectangle2D.Double body1 = new Rectangle2D.Double(x, y + width / 6, width - 1, width / 6);

		RoundRectangle2D.Double rand1 = new RoundRectangle2D.Double(x + 3, y + 3, width, 7, 8, 9);

		Arc2D.Double rand2 = new Arc2D.Double(body1, y + width / 6, width - 1, 2);

		Ellipse2D.Double frontTire1 = new Ellipse2D.Double(x + width / 6, y + width / 3, width / 6, width / 6);
		Ellipse2D.Double rearTire1 = new Ellipse2D.Double(x + width * 2 / 3, y + width / 3, width / 6, width / 6);

		Point2D.Double r3 = new Point2D.Double(x + width * 2 / 3, y);
		// The bottom of the rear windshield
		Point2D.Double r4 = new Point2D.Double(x + width * 5 / 6, y + width / 6);

		Line2D.Double rearWindshield = new Line2D.Double(r3, r4);

		g2.draw(body1);
		g2.draw(frontTire1);
		g2.draw(rearTire1);
		g2.draw(rand1);
		g2.draw(rand2);
		g2.draw(rearWindshield);

	}

	private int x;
	private int y;
	private int width;

}
