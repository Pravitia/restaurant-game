package restaurant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GachaComponent extends JComponent{

    public GachaComponent() {}

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D.Double titleBox = new Rectangle2D.Double(650, 20, 200, 90);
        g2.setFont(new Font("Arial", Font.BOLD, 50));


        g2.draw(titleBox);
        g2.setColor(Color.ORANGE);
        g2.drawString("GACHA", 660 ,80);

        try {
            loadImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(burger, 250, 100, 300, 300, null);
        g2.drawImage(taco, 400, 200, 250, 250, null);
        g2.drawImage(hotdog, 250, 280, 300,300, null);
        g2.drawImage(sushi, 550, 350, 250, 250, null);
        g2.drawImage(soda, 600, 100, 200, 300, null);

    }

    private static BufferedImage burger, taco, hotdog, sushi, soda;
    private static void loadImage() throws IOException{
       burger = ImageIO.read(new File("restaurant/images/transparentBurgerNew.png"));
       taco = ImageIO.read(new File("restaurant/images/transparentTacoNew.png"));
       hotdog = ImageIO.read(new File("restaurant/images/transparentHotdogNew.png"));
       sushi = ImageIO.read(new File("restaurant/images/transparentSushiNew.png"));
       soda = ImageIO.read(new File("restaurant/images/transparentSodaNew.png"));
    }





}
