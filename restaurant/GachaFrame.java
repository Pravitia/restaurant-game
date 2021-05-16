package restaurant;

import restaurant.message.BackToManageMessage;
import restaurant.message.Message;
import restaurant.message.SingleRollMessage;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

/**
 * View Frame for the Gacha Component
 */
public class GachaFrame extends JFrame{
    BlockingQueue<Message> queue;

    final int FRAME_WIDTH = 1500;
    final int FRAME_HEIGHT = 1000;

    String basepath = "restaurant/images/transparent.png";
    GachaComponent gacha = new GachaComponent(basepath);

    JButton backButton, oneRollButton, displayIconButton;
    JTextField moneyBar;
    double money = 500;


    /**
     * Constructor for Gacha Frame
     * @param queue Bring the queue into Gacha Frame
     */
    public GachaFrame(BlockingQueue<Message> queue)
    {
        this.queue = queue;

        Font font = new Font("Arial", Font.BOLD, 30);
        this.moneyBar = new JTextField(String.format("$%.2f", money));
        moneyBar.setFont(font);
        moneyBar.setBounds(1300, 10, 200, 30);
        moneyBar.setEditable(false);

        this.backButton = new JButton("Back");
        backButton.setBounds(10, 900, 90, 40);
        this.oneRollButton = new JButton("1 Roll");
        oneRollButton.setBounds(650,700, 150, 70);
        oneRollButton.setFont(font);

        oneRollButton.addActionListener(e -> {
            try {
                Message msg = new SingleRollMessage();
                queue.put(msg);
            } catch (InterruptedException error) {
                // do nothing
            }
        });

        backButton.addActionListener(e -> {
            try {
                Message msg = new BackToManageMessage();
                queue.put(msg);
            } catch (InterruptedException error) {
                // do nothing
            }
        });

        this.add(moneyBar);
        this.add(backButton);
        this.add(oneRollButton);
        this.add(gacha);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

