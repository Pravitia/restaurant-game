package restaurant;

import restaurant.message.Message;
import restaurant.message.StartGameMessage;
import javax.swing.*;
import java.util.concurrent.BlockingQueue;

/**
 * Build the View for the Main Menu
 */
public class MainMenuFrame extends JFrame {
    BlockingQueue<Message> queue;

    final int FRAME_WIDTH = 1500;
    final int FRAME_HEIGHT = 1000;
    MainMenuComponent mainMenu = new MainMenuComponent();

    JButton playButton;

    /**
     * Constructor for MainMenuFrame
     * @param queue Bring the queue into the Main Menu Frame
     */
    public MainMenuFrame(BlockingQueue<Message> queue)
    {
        this.queue = queue;
        this.playButton = new JButton("Play");
        playButton.setBounds(700,800,100,30);

        playButton.addActionListener(e -> {
            try {
                Message msg = new StartGameMessage();
                queue.put(msg);
            } catch (InterruptedException error) {
                // do nothing
            }
        });

        this.add(playButton);
        this.add(mainMenu);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Move from Title Screen to Game Screen
     * @param view Get the view to refresh
     */
    public void updateToGameStart(JFrame view) {
        view.setVisible(true);
        this.setVisible(false);
    }


}
