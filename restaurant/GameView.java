package restaurant;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;

//View class
public class GameView extends JFrame {

    BlockingQueue<Message> queue;

    GameStartFrame gameStartScreen;
    GachaFrame gachaScreen;
    MinigameFrame restaurantScreen;

    final int FRAME_WIDTH = 1500;
    final int FRAME_HEIGHT = 1000;

    MainMenuComponent mainMenu = new MainMenuComponent();
    JButton playButton, leaderboardButton;

    public GameView(BlockingQueue<Message> queue)
    {
        this.queue = queue;

        this.gameStartScreen = new GameStartFrame(queue);
        this.gachaScreen = new GachaFrame(queue);
        this.restaurantScreen = new MinigameFrame(queue);

        this.playButton = new JButton("Play");
        playButton.setBounds(700,800,100,30);
        this.leaderboardButton = new JButton("Leaderboard");
        leaderboardButton.setBounds(100,800,200,30);

        playButton.addActionListener(e -> {
            try {
                Message msg = new StartGameMessage();
                queue.put(msg);
            } catch (InterruptedException error) {
                // do nothing
            }
        });

        this.add(playButton);
        this.add(leaderboardButton);
        this.add(mainMenu);


        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Methods for Main screen GameView

    // Changes view from GameView to GameStartFrame
    public void updateToGameStart() {
        gameStartScreen.setVisible(true);
        this.dispose();
    }

    // Methods for GameStartFrame

    // Changes view from GameStartFrame to GachaFrame
    public void updateToGachaFrame() {
        gachaScreen.setVisible(true);
        gameStartScreen.dispose();
    }

    // Changes view from GameStartFrame to RestaurantFrame
    public void updateToRestaurantFrame() {
        restaurantScreen.setVisible(true);
        gameStartScreen.dispose();
    }

    // Methods for GachaFrame

    // Changes view from GachaFrame to GameStartFrame
    public void returnToGameStart() {
        gameStartScreen.setVisible(true);
        gachaScreen.dispose();
    }



}
