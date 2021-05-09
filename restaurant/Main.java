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


        //MVC testing
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
        GameModel model = new GameModel();
        //GameView view = new GameView(queue);
        MainMenuFrame view1 = new MainMenuFrame(queue);
        GameStartFrame view2 = new GameStartFrame(queue);
        GachaFrame view3 = new GachaFrame(queue);
        GameController controller = new GameController(queue, model, view1, view2, view3);

        controller.mainLoop();



        /*
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

        //frame.setBackground(Color.BLUE);  //shit don't work
        BlockingQueue tempq = null;
        frame.add(new GameView(tempq));
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);

        */



        //main menu testing end here
    }

}
