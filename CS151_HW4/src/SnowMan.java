
//Code borrowed from CarShape which was borrowed from textbook

import java.awt.*;
import java.awt.geom.*;

/**
   Borrowed from textbook
*/
public class SnowMan implements CompositeShape
{
   /**
      Constructs a snowman item.
      @param x the left of the bounding rectangle
      @param y the top of the bounding rectangle
      @param width the width of the bounding rectangle
   */
   public SnowMan(int x, int y, int width)
   {
      this.x = x;
      this.y = y;
      this.width = width;
   }

   public void translate(int dx, int dy)
   {
      x += dx;
      y += dy;
   }

   public void draw(Graphics2D g2)
   {
      
      Ellipse2D.Double frontTire
            = new Ellipse2D.Double(x, y , 
                  width / 6, width / 6);
      Ellipse2D.Double rearTire
            = new Ellipse2D.Double(x , y + width/6,
                  width / 6, width / 6);

     
      
      g2.draw(frontTire);
      g2.draw(rearTire);
      
   }
   
   private int x;
   private int y;
   private int width;

}
