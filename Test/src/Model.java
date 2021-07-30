import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Model implements ChangeListener {

	public ArrayList<String> input;
	public ArrayList<ChangeListener> listeners;

	public Model() {
		input = new ArrayList<String>();
		listeners = new ArrayList<ChangeListener>();
	}

	public void add(String text) {

		input.add(text);

		ChangeEvent listener = new ChangeEvent(this);

		for (ChangeListener l : listeners) {
			l.stateChanged(listener);
		}
	}

	public void addChangeListener(ChangeListener c) {
		listeners.add(c);
	}


	public String toString(Model data) {
		String result = "";
		for (int i = 0; i != data.input.size() - 1; i++) {
			result += data.input.get(i).toString();
		}
		return result;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

}