package restaurant;

import javax.swing.*;

public class GameStartFrame extends JFrame{
    final int FRAME_WIDTH = 1500;
    final int FRAME_HEIGHT = 1000;
    GameStartComponent gameStart = new GameStartComponent();

    JButton startGameButton, gachaButton;

    public GameStartFrame()
    {

        this.startGameButton = new JButton("Start Game");
        startGameButton.setBounds(650,600,200,100);
        this.gachaButton = new JButton("Gacha");
        gachaButton.setBounds(650,750,200,100);

        this.add(startGameButton);
        this.add(gachaButton);
        this.add(gameStart);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
