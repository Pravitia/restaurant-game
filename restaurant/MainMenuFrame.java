package restaurant;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;

public class MainMenuFrame extends JFrame {
    final int FRAME_WIDTH = 1500;
    final int FRAME_HEIGHT = 1000;
    MainMenuComponent mainMenu = new MainMenuComponent();

    JButton playButton, leaderboardButton;

    public MainMenuFrame()
    {
        this.playButton = new JButton("Play");
        playButton.setBounds(700,800,100,30);
        this.leaderboardButton = new JButton("Leaderboard");
        leaderboardButton.setBounds(100,800,200,30);

        this.add(playButton);
        this.add(leaderboardButton);
        this.add(mainMenu);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



}
