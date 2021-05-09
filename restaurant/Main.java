package restaurant;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        Food food = new Food();
        ArrayList<Food> loot = food.getLoot();

        /*
        //test loot list
        for(int i = 0; i < loot.size(); i++) {
            System.out.print(loot.get(i).getName());
        }*/


        //testing of frames
        JFrame test = new JFrame();
        MinigameFrame minigame = new MinigameFrame();
        test.add(minigame);
        test.setSize(1500, 1000);
        test.setVisible(true);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //MVC testing
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
        GameModel model = new GameModel();
        //GameView view = new GameView(queue);
        MainMenuFrame view1 = new MainMenuFrame(queue);
        GameStartFrame view2 = new GameStartFrame(queue);
        GachaFrame view3 = new GachaFrame(queue);
        //MinigameFrame view4 = new MinigameFrame(queue);
        GameController controller = new GameController(queue, model, view1, view2, view3);

        controller.mainLoop();






    }

}
