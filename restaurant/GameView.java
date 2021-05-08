package restaurant;

import java.util.concurrent.BlockingQueue;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//View class
public class GameView extends JFrame {
    final int FRAME_WIDTH = 1500;
    final int FRAME_HEIGHT = 1000;
    MainMenuFrame mainMenu = new MainMenuFrame();
    GameStartFrame gameStart = new GameStartFrame();

    BlockingQueue<Message> queue;


    public GameView(BlockingQueue<Message> queue)
    {
        this.queue = queue;

        //this.add(mainMenu);
        this.add(gameStart);

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }




}
