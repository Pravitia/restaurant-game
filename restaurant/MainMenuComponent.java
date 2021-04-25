package restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

public class MainMenuComponent extends JComponent {

    private MainMenuShape menu;
    public MainMenuComponent()
    {
        menu = new MainMenuShape();
    }




    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        //Title box
        Rectangle2D.Double titleBox = new Rectangle2D.Double(500, 20, 500, 75);


        //Title string set font
        g2.setFont(new Font("Dialog", Font.BOLD, 40));


        //image box
        Rectangle2D.Double imageBox = new Rectangle2D.Double(525,100,450, 500);

        //draw everything
        g2.draw(titleBox);
        g2.drawString("Restaurant game", 600 ,70);
        g2.draw(imageBox);
    }



}
