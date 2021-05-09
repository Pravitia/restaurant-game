package restaurant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class MinigameComponent extends JComponent{

    MinigameComponent() {}

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D.Double instructionBox = new Rectangle2D.Double(600, 20, 300, 50);
        Rectangle2D.Double displayBox = new Rectangle2D.Double(525,100,450, 450);

        g2.setFont(new Font("Arial", Font.BOLD, 20));




        g2.draw(instructionBox);
        g2.drawString("click the corresponding food", 610, 50);
        g2.draw(displayBox);

    }



}
