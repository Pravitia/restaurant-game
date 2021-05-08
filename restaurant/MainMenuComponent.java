package restaurant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainMenuComponent extends JComponent {

    public MainMenuComponent(){

    }


    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //Title box
        Rectangle2D.Double titleBox = new Rectangle2D.Double(500, 20, 500, 75);
        //Title string set font
        g2.setFont(new Font("Dialog", Font.BOLD, 40));      //decide on what font we want as a group later

        //image box
        Rectangle2D.Double imageBox = new Rectangle2D.Double(525,100,450, 450);


        //draw everything
        g2.draw(titleBox);
        g2.drawString("Restaurant game", 600 ,70);
        g2.draw(imageBox);
        try {
            loadImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(titleBurger, 530, 100, 450, 450, null);

    }

    //everything to do with images goes here
    private static BufferedImage titleBurger;
    private static void loadImage() throws IOException{
        titleBurger = ImageIO.read(new File("restaurant/images/transparentBurger.png"));
    }


}
