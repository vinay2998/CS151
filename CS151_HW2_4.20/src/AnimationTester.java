import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;


public class AnimationTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.setLayout(new GridLayout(5, 1));

      final MoveableShape shape
            = new CarShape(0, 0, CAR_WIDTH);
      
      ArrayList<ShapeIcon> icon = new ArrayList<ShapeIcon>();
      
      icon.add(new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT));
      icon.add(new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT));
      icon.add(new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT));
      icon.add(new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT));
      icon.add(new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT));
      
      final ArrayList<JLabel> label = new ArrayList<JLabel>();
      for (int i = 0; i < icon.size(); i++) {
    	  label.add(new JLabel(icon.get(i)));
    	  frame.add(label.get(i));
      }
      
      

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      final int DELAY = 100;
      // Milliseconds between timer ticks
      Timer t = new Timer(DELAY, new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               shape.translate(3, 0);
               for (JLabel l : label) {
            	   l.repaint();
               }
            }
         });
      t.start();
      
   }

   private static final int ICON_WIDTH = 400;
   private static final int ICON_HEIGHT = 100;
   private static final int CAR_WIDTH = 100;
}