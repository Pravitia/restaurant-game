package restaurant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Class to draw the Title Screen
 */
public class GameStartComponent extends JComponent{

    /**
     * Paint the Title Box
     * @param g To draw Rectangle
     */
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        try {
            loadImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(background, 0, 0, 1500, 1000, null);

    //Title box
        Rectangle2D.Double titleBox = new Rectangle2D.Double(500, 20, 500, 75);
    }


    private static BufferedImage background;

    /**
     * Loads the Title Burger
     * @throws IOException
     */
    private static void loadImage() throws IOException{
        background = ImageIO.read(new File("restaurant/images/mainMenuBackground.png"));
    }

}
