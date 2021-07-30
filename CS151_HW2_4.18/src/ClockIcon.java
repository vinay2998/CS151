import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.*;


public class ClockIcon implements Icon{
	
	
	int HOUR_HAND_LENGTH=50;
	int MIN_HAND_LENGTH=100;
	int SEC_HAND_LENGTH=110;
	
	double hour, min, sec;
	
	public ClockIcon(String currentTime) {
		String[] time = currentTime.split(":");
		hour = Double.parseDouble(time[0]);
		min = Double.parseDouble(time[1]);
		sec = Double.parseDouble(time[2]);
	}
	
/*
 * Parameters:
 * c a Component to get properties useful for painting
 * g the graphics context
 * x the X coordinate of the icon's top-left corner
 * y the Y coordinate of the icon's top-left corner
 */
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double circle = new Ellipse2D.Double();
		circle.setFrameFromCenter(250, 250, 400, 400);
		g2.draw(circle);
		
		//Format: Double(double x1, double y1, double x2, double y2)
		Line2D.Double hourDisp = new Line2D.Double(
				250, 250, 250 + HOUR_HAND_LENGTH * Math.sin(Math.PI * hour / 6), 250 - HOUR_HAND_LENGTH * Math.cos(Math.PI *  hour / 6)
				);
		Line2D.Double minDisp = new Line2D.Double(
				250, 250, 250 + MIN_HAND_LENGTH * Math.sin(Math.PI *  min / 30), 250 - MIN_HAND_LENGTH * Math.cos(Math.PI *  min / 30)
				);
		Line2D.Double secDisp = new Line2D.Double(
				250, 250, 250 + SEC_HAND_LENGTH * Math.sin(Math.PI *  sec / 30), 250 - SEC_HAND_LENGTH * Math.cos(Math.PI *  sec / 30)
				);
		g2.draw(hourDisp);
		g2.draw(minDisp);
		g2.draw(secDisp);
	}
	
	
	//Converting string of time to double
	public void timeStringToDouble(String currentTime) {
		String[] time = currentTime.split(":");
		hour = Double.parseDouble(time[0]);
		min = Double.parseDouble(time[1]);
		sec = Double.parseDouble(time[2]);
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
}