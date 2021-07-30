import java.util.ArrayList;
import javax.swing.event.*;


public class DataModel
{

   public DataModel(ArrayList<Double> d)
   {
      data = d;
      listeners = new ArrayList<ChangeListener>();
   }


   public ArrayList<Double> getData()
   {
      return (ArrayList<Double>) (data.clone());
   }

 
   public void attach(ChangeListener c)
   {
      listeners.add(c);
   }

 
   public void update(int location, double value)
   {
      data.set(location, new Double(value));
      for (ChangeListener l : listeners)
      {
         l.stateChanged(new ChangeEvent(this));
      }
   }

   ArrayList<Double> data;
   ArrayList<ChangeListener> listeners;
}