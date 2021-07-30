import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   A class for using buttons to change the size of an icon.
*/
public class ZoomTester
{
   /**
      Allows the user to change the size of a car icon by pressing a button
      @param args unused
   */
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();


      JButton zoomInButton = new JButton("Zoom In");

      zoomInButton.addActionListener(zoomInFunction());

      JButton zoomOutButton = new JButton("Zoom Out");

      zoomOutButton.addActionListener(zoomOutFunction());


      icon = new CarShape(0,0, 100);
      label = new JLabel(icon);

      frame.setLayout(new FlowLayout());

      frame.add(zoomInButton);
      frame.add(zoomOutButton);
      frame.add(label);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }

  
   public static ActionListener zoomInFunction() {
	   return new ActionListener() {
		   public void actionPerformed(ActionEvent event)
           {
              int newWidth = (int) (1.2 * icon.getIconWidth());
              icon.setWidth(newWidth);
              label.repaint();
           }
	   };
   }
   
   public static ActionListener zoomOutFunction() {
	   return new ActionListener() {
		   public void actionPerformed(ActionEvent event)
           {
              int newWidth = (int) (0.8 * icon.getIconWidth());
              icon.setWidth(newWidth);
              label.repaint();
           }
	   };
   }

   private static CarShape icon;
   private static JLabel label;

}