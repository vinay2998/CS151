import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DataModel {
	private int iconWidth;
	ArrayList<ChangeListener> listeners;
	
	public DataModel(int width) {
		iconWidth = width;
		listeners = new ArrayList<ChangeListener>();
	}
	
	/**
	    Attach a listener to the Model
	    @param c the listener
	 */
	 public void attach(ChangeListener c)
	 {
	    listeners.add(c);
	 }
	 
	 public int getIconWidth() {
		 return iconWidth;
	 }
	 
	 public ChangeListener changeListener() {
		 return listeners.get(0);
	 }
	 
	 public void update(int width) {
		 iconWidth = width;
		 for (int i = 0; i < listeners.size(); i++)
	      {
	         listeners.get(i).stateChanged(new ChangeEvent(this));
	      }
	 }
}