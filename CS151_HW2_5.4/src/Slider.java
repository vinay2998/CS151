import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Slider extends JSlider implements ChangeListener{
	private DataModel dataModel;
	private CarShape cs;
	
	public Slider(DataModel d) {
		dataModel = d;
		addChangeListener(this);
	}
	
	public Slider(CarShape cs) {
		this.cs=cs;
		addChangeListener(this);
	}
	
	
	@Override
	public void stateChanged(ChangeEvent e) {
//		System.out.println("The orientation is " + this.getValue());
		dataModel.update(this.getValue() * 2);
		cs.update(this.getValue() * 2);
		System.out.println("The orientation is " + cs.getWidth());
	}

}