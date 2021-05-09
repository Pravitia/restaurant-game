package restaurant;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

public class GachaFrame extends JFrame{
    BlockingQueue<Message> queue;

    final int FRAME_WIDTH = 1500;
    final int FRAME_HEIGHT = 1000;

    GachaComponent gacha = new GachaComponent();

    JButton backButton, oneRollButton;

    public GachaFrame(BlockingQueue<Message> queue)
    {
        this.queue = queue;
        Font font = new Font("Arial", Font.BOLD, 30);
        this.backButton = new JButton("Back");
        backButton.setBounds(10, 900, 90, 40);
        this.oneRollButton = new JButton("1 Roll");
        oneRollButton.setBounds(650,700, 200, 70);
        oneRollButton.setFont(font);
        /*
        this.tenRollButton = new JButton("10 Roll");
        tenRollButton.setBounds(900, 700, 200, 70);
        tenRollButton.setFont(font);
        */

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

        this.add(backButton);
        this.add(oneRollButton);
        //this.add(tenRollButton);
        this.add(gacha);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        //this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}

