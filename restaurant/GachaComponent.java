package restaurant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Build the view portion of the Gacha Frame
 */
public class GachaComponent extends JComponent{


    static String filepath;     // File path of the picture

    /**
     * The constructor of the GachaComponent
     * Handles the view and the scnery of the Gacha Screen
     * @param filepath the string of the filepath of the Picture
     */
    public GachaComponent(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Paint Component
     * Draw the background with GACHA button and other pictures
     * @param g the graphic to draw
     */
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        try {
            loadImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(background, 0, 0, 1500, 1000, null);

        Rectangle2D.Double displayBox = new Rectangle2D.Double(1000, 500, 300, 300);


        g2.draw(displayBox);

        g2.drawImage(display, 1000, 500, 300, 300, null);

    }

    private static BufferedImage display, background;

    /**
     * Load images into the variables
     * @throws IOException
     */
    private static void loadImage() throws IOException{
       background = ImageIO.read(new File("restaurant/images/gachaBackground.png"));
       display = ImageIO.read(new File(filepath));
    }





}
