package restaurant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * View for the Minigame Component
 */
public class MinigameComponent extends JComponent{

    static String filepath;

    /**
     * Constructor of MinigameComponent
     * @param filepath Takes filepath for the transparent pictures for the frame
     */
    MinigameComponent(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Paint the view for the Minigame
     * @param g Paint the Text
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D.Double instructionBox = new Rectangle2D.Double(600, 20, 300, 50);
        Rectangle2D.Double displayBox = new Rectangle2D.Double(525,100,450, 450);

        g2.setFont(new Font("Arial", Font.BOLD, 20));




        g2.draw(instructionBox);
        g2.drawString("Click the food as they show up", 605, 50);
        g2.draw(displayBox);


        try {
            loadImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(background, 0, 0, 1500, 1000, null);
        g2.drawImage(customer, 100, 100, 300, 500, null);
        g2.drawImage(displayFood, 600, 200, 300,300, null);


    }


    private static BufferedImage customer, displayFood, background;

    /**
     * Load the images of the customer and background to the view
     * @throws IOException
     */
    private static void loadImage() throws IOException{
        customer = ImageIO.read(new File("restaurant/images/customer1.png"));
        background = ImageIO.read(new File("restaurant/images/restaurantBackground.png"));
        //customer = ImageIO.read(new File(filepath));
        displayFood = ImageIO.read(new File(filepath));
    }


}
