package restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuComponent extends JComponent {

    private MainMenuShape menu;
    public MainMenuComponent()
    {
        menu = new MainMenuShape();
    }




    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        menu.draw(g2);
    }



}
