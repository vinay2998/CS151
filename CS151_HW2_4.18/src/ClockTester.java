
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class ClockTester {
	public static void main(String args[]) {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:a");
		GregorianCalendar cal = new GregorianCalendar();
		
		final ClockIcon clock = new ClockIcon(dateFormat.format(cal.getTime()));
		final JLabel iconLabel = new JLabel(clock);
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
	    frame.add(iconLabel);
		
		
		
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				DateFormat curDateFormat = new SimpleDateFormat("HH:mm:ss:a");
				GregorianCalendar curCal = new GregorianCalendar();
				clock.timeStringToDouble(curDateFormat.format(curCal.getTime()));
				iconLabel.repaint();
			}
		};
		
		javax.swing.Timer t = new javax.swing.Timer(1000, listener);
		t.start();
		
		

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
		
	}

}