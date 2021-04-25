package restaurant;

import java.awt.*;
import java.awt.geom.*;

public class MainMenuShape {

    public MainMenuShape(){
    }

    public void draw(Graphics2D g2)
    {
        Rectangle2D.Double title = new Rectangle2D.Double(10, 10, 10, 10);


        g2.draw(title);
    }



}
