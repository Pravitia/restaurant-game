package restaurant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Food> loot = new ArrayList<>();
        loot.add(new Food(25, 5, "Steak", "images/steakPicture"));
        loot.add(new Food(18, 4, "Rotisserie Chicken", "chickenPicture"));
        loot.add(new Food(1.50, 3, "Hotdog", "hotdogPicture"));
        loot.add(new Food(15, 4, "Burger", "burgerPicture"));
        loot.add(new Food(12, 4, "Pepperoni Pizza", "pizzaPicture"));
        loot.add(new Food(10, 3, "Turkey Sandwich", "sandwichPicture"));
        loot.add(new Food(3.5, 3, "Fries", "friesPicture"));
        loot.add(new Food(14, 4, "Ramen", "ramenPicture"));
        loot.add(new Food(16, 4, "Sushi", "sushiPicture"));
        loot.add(new Food(35, 5, "Strawberry Cake", "cakePicture"));
        loot.add(new Food(1, 3, "Cup Noodle", "noodlePicture"));
        loot.add(new Food(13, 4, "Tacos", "tacoPicture"));
        loot.add(new Food(2, 3, "Soda", "sodaPicture"));
        loot.add(new Food(7, 3, "Milkshake", "milkshakePicture"));



        //main menu testing will start here
        final int FRAME_WIDTH = 1500;
        final int FRAME_HEIGHT = 1000;

        JFrame frame = new JFrame("game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //buttons and stuff   //for some reason closing 1 frame closes them all
        JButton playButton = new JButton("Play");
        playButton.setBounds(700,800,100,30);

        //actionlistener needs to repaint jframe with new window instead of make new frame in future
        playButton.addActionListener(new ActionListener() {
                                         public void actionPerformed(ActionEvent e) {
                                             JFrame click = new JFrame("click");
                                             click.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                             click.setSize(300, 300);
                                             click.setVisible(true);
                                         }
                                     });
        frame.add(playButton);

        JButton leaderboardButton = new JButton("Leaderboard");
        leaderboardButton.setBounds(100,800,200,30);
        leaderboardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame click = new JFrame("Leaderboard");
                click.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                click.setSize(300, 300);
                click.setVisible(true);
            }
        });
        frame.add(leaderboardButton);

        //frame.setBackground(Color.BLUE /*new Color(118,181,197)*/);
        frame.add(new MainMenuComponent());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);

        //main menu testing end here

        try {
            BufferedImage titleBurger = ImageIO.read(new File("restaurant/images/Burger.JPG"));
            System.out.println(titleBurger);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
