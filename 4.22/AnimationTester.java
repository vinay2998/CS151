

import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

/**
   This program implements an animation that moves
   a car shape.
*/
public class AnimationTester
{
   public static void main(String[] args) throws InterruptedException
   {
      JFrame frame = new JFrame();
      MoveableShape shape = new CarShape(0, 0, CAR_WIDTH);


      ShapeIcon icon = new ShapeIcon(shape,
            ICON_WIDTH, ICON_HEIGHT);

      JLabel label = new JLabel(icon);
      frame.setLayout(new FlowLayout());
      frame.add(label);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      final int DELAY = 10;
      
      // Milliseconds between timer ticks
      Timer t = new Timer(DELAY, event ->
         {
            shape.move();
            label.repaint();
         });
      t.start();
   }
   


   private static final int ICON_WIDTH = 400;
   private static final int ICON_HEIGHT = 100;
   private static final int CAR_WIDTH = 100;
}
