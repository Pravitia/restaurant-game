package restaurant;

import javax.swing.*;
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
        final int FRAME_WIDTH = 400;
        final int FRAME_HEIGHT = 400;

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new MainMenuComponent());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);

        //main menu testing end here
    }

}
