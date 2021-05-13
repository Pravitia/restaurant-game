package restaurant;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;


/**
 * View Class for the Restaurant Game
 * @author Anson, Aaron, Harrison, Jordan
 */
public class GameView extends JFrame {

    BlockingQueue<Message> queue;

    GameStartFrame gameStartScreen;
    GachaFrame gachaScreen;
    MinigameFrame restaurantScreen;


    final int FRAME_WIDTH = 1500;
    final int FRAME_HEIGHT = 1000;

    MainMenuComponent mainMenu = new MainMenuComponent();

    String basepath = "restaurant/images/transparent.png";
    GachaComponent gachaComp = new GachaComponent(basepath);
    MinigameComponent minigameComp = new MinigameComponent(basepath);

    JButton playButton;
            //leaderboardButton;

    /**
     * Initial Game View Part of the MVC
     *
     * Creates the view with all the other screens: gameStart, gachaSreen, and restaurantScreen
     * @param queue
     */
    public GameView(BlockingQueue<Message> queue)
    {
        this.queue = queue;
        this.gameStartScreen = new GameStartFrame(queue);
        this.gachaScreen = new GachaFrame(queue);
        this.restaurantScreen = new MinigameFrame(queue);

        this.playButton = new JButton("Play");
        playButton.setBounds(700,800,100,30);
        //this.leaderboardButton = new JButton("Leaderboard");
        //leaderboardButton.setBounds(100,800,200,30);

        playButton.addActionListener(e -> {
            try {
                Message msg = new StartGameMessage();
                queue.put(msg);
            } catch (InterruptedException error) {
                // do nothing
            }
        });

        this.add(playButton);
        //this.add(leaderboardButton);
        this.add(mainMenu);


        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Methods for Main screen GameView

    /**
     * Changes view from GameView to GameStartFrame
     * @return Goes back to GameStartFrame
     */
    public void updateToGameStart() {
        gameStartScreen.setVisible(true);
        this.dispose();
    }

    // Methods for GameStartFrame

    // Changes view from GameStartFrame to GachaFrame
    public void updateToGachaFrame() {
        gachaScreen.setVisible(true);
        gameStartScreen.setVisible(false);
    }

    /**
     * Updates the Gacha Display
     * @param s which acts the address to what food to print
     */
    public void updateGachaDisplay(String s){
        System.out.println(s);
        gachaScreen.remove(gachaComp);
        gachaComp = new GachaComponent(s);
        gachaScreen.add(gachaComp);
        gachaScreen.setVisible(false);
        gachaScreen.setVisible(true);

    }

    /**
     * Updates the Display food display
     * @param s which acts as the address to what food to print
     */
    public void updateGameDisplay(String s){
        restaurantScreen.remove(minigameComp);
        minigameComp = new MinigameComponent(s);
        restaurantScreen.add(minigameComp);
        restaurantScreen.setVisible(false);
        restaurantScreen.setVisible(true);

    }

    public void updateMoney(double money){
        restaurantScreen.moneyBar.setText(String.format("$%.2f", money));

    }

    /**
    public void updateGachaDisplayDuplicate(String s){
        System.out.println(s);
        System.out.println("Got a Duplicate");
        gachaScreen.remove(gachaComp);
        gachaComp = new GachaComponent(s);
        gachaScreen.add(gachaComp);
        gachaScreen.setVisible(false);
        gachaScreen.setVisible(true);
    }
     **/

    /**
     * Changes view from GameStartFrame to RestaurantFrame
     * When it clicks play it goes from GameStartFrame to RestaurantFrame
     * Then it will stay there for 60 seconds, and finally close after that time
     */
    public void updateToRestaurantFrame() {
        restaurantScreen.setVisible(true);
        gameStartScreen.setVisible(false);
        final int Delay = 10000;
        Timer t = new Timer(Delay, e -> {
            restaurantScreen.setVisible(false);
            gameStartScreen.setVisible(true);
        });
        t.setRepeats(false);
        t.start();
    }

    // Methods for GachaFrame

    /**
     * Changes view from GachaFrame to GameStartFrame
     * Switches Screen
     */
    public void returnToGameStart() {
        gameStartScreen.setVisible(true);
        gachaScreen.setVisible(false);
    }



}
