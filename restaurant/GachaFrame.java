package restaurant;

import javax.swing.*;
import java.awt.*;

public class GachaFrame extends JFrame{
    final int FRAME_WIDTH = 1500;
    final int FRAME_HEIGHT = 1000;
    GachaComponent gacha = new GachaComponent();

    JButton backButton, oneRollButton, tenRollButton;

    public GachaFrame()
    {
        Font font = new Font("Arial", Font.BOLD, 30);
        this.backButton = new JButton("Back");
        backButton.setBounds(10, 900, 90, 40);
        this.oneRollButton = new JButton("1 Roll");
        oneRollButton.setBounds(400,700, 200, 70);
        oneRollButton.setFont(font);
        this.tenRollButton = new JButton("10 Roll");
        tenRollButton.setBounds(900, 700, 200, 70);
        tenRollButton.setFont(font);


        this.add(backButton);
        this.add(oneRollButton);
        this.add(tenRollButton);
        this.add(gacha);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }




}

