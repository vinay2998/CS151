import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShapeFrame extends JFrame{
	private JPanel btnPanel;
	private JPanel viewPanel;
	private int mode;
	
	public ShapeFrame() {
		int frameSize=500;
		setLayout(new BorderLayout());
		mode = 1;
		
		btnPanel = new JPanel();
		viewPanel = new JPanel();
		
		btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.X_AXIS));
		viewPanel.setLayout(new OverlayLayout(viewPanel));
		
		viewPanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (mode == 1) {
					
					CarShape car = new CarShape(e.getX(), e.getY(), 50);
					ShapeIcon icon = new ShapeIcon(car, frameSize, frameSize);
					JLabel label = new JLabel();
					
					label.setIcon(icon);
					viewPanel.add(label);
					
					viewPanel.revalidate();
					viewPanel.repaint();
					
				}else if (mode == 2) {
					
					SnowMan snow = new SnowMan(e.getX(), e.getY(), 50);
					ShapeIcon icon = new ShapeIcon(snow, frameSize, frameSize);
					JLabel label = new JLabel();
					
					label.setIcon(icon);
					viewPanel.add(label);
					
				    viewPanel.revalidate();
					viewPanel.repaint();
					
					} else if (mode == 3) {
					MyShape m = new MyShape(e.getX(),e.getY(), 50);
					ShapeIcon icon = new ShapeIcon(m, frameSize, frameSize);
					JLabel label = new JLabel();
					
					label.setIcon(icon);
					viewPanel.add(label);
					
					viewPanel.revalidate();
					viewPanel.repaint();
					}
			}
		});
		
		add(btnPanel, BorderLayout.NORTH);
		add(viewPanel, BorderLayout.CENTER);
		
	}
	
	public void addShape(final CompositeShape shape) {
		ShapeIcon icon = new ShapeIcon(shape, 30, 30);
		JButton btn = new JButton(icon);
		btnPanel.add(btn);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Class c = shape.getClass();
				if (c.getName().equals("SnowMan")) {
					mode = 2;
				} else if (c.getName().equals("CarShape")) {
					mode = 1;
				} else if (c.getName().equals("MyShape")) {
					mode = 3;
				}
			}
		});
	}
}
