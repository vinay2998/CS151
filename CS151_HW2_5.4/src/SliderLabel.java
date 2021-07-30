import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderLabel extends JLabel implements ChangeListener{
	
	public SliderLabel(CarShape image) {
		super(image);
	}
	
	@Override
	public void stateChanged(ChangeEvent arg0) {
		repaint();
	}

}