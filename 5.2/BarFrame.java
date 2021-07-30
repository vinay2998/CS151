import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;


public class BarFrame extends JFrame implements ChangeListener, MouseListener {

	double max;

	public BarFrame(DataModel dataModel) {
		this.dataModel = dataModel;
		a = dataModel.getData();

		setLocation(0, 200);
		setLayout(new BorderLayout());

		Icon barIcon = new Icon() {
			public int getIconWidth() {
				return ICON_WIDTH;
			}

			public int getIconHeight() {
				return ICON_HEIGHT;
			}

			public void paintIcon(Component c, Graphics g, int x, int y) {
				Graphics2D g2 = (Graphics2D) g;

				g2.setColor(Color.red);

				max = (a.get(0)).doubleValue();
				for (Double v : a) {
					double val = v.doubleValue();
					if (val > max)
						max = val;
				}

				double barHeight = getIconHeight() / a.size();

				int i = 0;
				for (Double v : a) {
					double value = v.doubleValue();

					double barLength = getIconWidth() * value / max;

					Rectangle2D.Double rectangle = new Rectangle2D.Double(0, barHeight * i, barLength, barHeight);
					i++;
					g2.fill(rectangle);
				}
			}
		};

		add(new JLabel(barIcon));
		addMouseListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	/**
	 * Called when the data in the model is changed.
	 * 
	 * @param e the event representing the change
	 */
	public void stateChanged(ChangeEvent e) {
		a = dataModel.getData();
		repaint();
	}

	private ArrayList<Double> a;
	private DataModel dataModel;

	private static final int ICON_WIDTH = 200;
	private static final int ICON_HEIGHT = 200;

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println(e.getY());
		//System.out.println(e.getX());
		int location = (e.getY() - 30) / (ICON_HEIGHT / a.size());
		double value = max * ((double) e.getX() / ICON_WIDTH);
		dataModel.update(location, value);
		
	}
	
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}