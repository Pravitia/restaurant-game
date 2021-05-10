package restaurant;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;

public class GameStartFrame extends JFrame{
    BlockingQueue<Message> queue;
    final int FRAME_WIDTH = 1500;
    final int FRAME_HEIGHT = 1000;
    GameStartComponent gameStart = new GameStartComponent();

    JButton startGameButton, gachaButton;

    public GameStartFrame(BlockingQueue<Message> queue)
    {
        this.queue = queue;
        this.startGameButton = new JButton("Start Game");
        startGameButton.setBounds(650,600,200,100);
        this.gachaButton = new JButton("Gacha");
        gachaButton.setBounds(650,750,200,100);

        startGameButton.addActionListener(e -> {
            try {
                Message msg = new PlayGameMessage();
                queue.put(msg);
            } catch (InterruptedException error) {
                // do nothing
            }
        });

        // Action Listener for the Gacha Button
        gachaButton.addActionListener(e -> {
            try {
                Message msg = new StartGachaMessage();
                queue.put(msg);
            } catch (InterruptedException error) {
                // do nothing
            }
        });

        this.add(startGameButton);
        this.add(gachaButton);
        this.add(gameStart);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
