package restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.BlockingQueue;


public class MinigameFrame extends JFrame{
    BlockingQueue<Message> queue;
    private ArrayList<Food> playerFood = new ArrayList<Food>();
    private ArrayList<ImageIcon> iconList = new ArrayList<ImageIcon>();
    private ArrayList<JButton> buttonList = new ArrayList<JButton>();
    private Customer currentCustomer;

    final int FRAME_WIDTH = 1500;
    final int FRAME_HEIGHT = 1000;

    String basepath = "restaurant/images/transparent.png";
    MinigameComponent minigame = new MinigameComponent(basepath);

    JTextField moneyBar;
    double money = 0;

    /*
    ImageIcon burgerIcon, cupNoodleIcon, friesIcon, hotdogIcon, milkshakeIcon,
                pizzaIcon, ramenIcon, chickenIcon, sodaIcon, steakIcon, cakeIcon,
                sushiIcon, tacoIcon, sandwichIcon;
    JButton burgerButton, cupNoodleButton, friesButton, hotdogButton, milkshakeButton,
                pizzaButton, ramenButton, chickenButton, sodaButton, steakButton, cakeButton,
                sushiButton, tacoButton, sandwichButton;
     */

    public MinigameFrame(BlockingQueue<Message> queue)
    {
        this.queue = queue;

        Font font = new Font("Arial", Font.BOLD, 30);
        this.moneyBar = new JTextField("$" + money);
        moneyBar.setFont(font);
        moneyBar.setBounds(1300, 10, 100, 30);
        moneyBar.setEditable(false);

        this.add(moneyBar);
        this.add(minigame);

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void updatePlayerFood(ArrayList<Food> f){
        playerFood = f;
        updateFrame();
        
    }

    public void updateCustomer(Customer c){
        currentCustomer = c;

    }

    public void updateMoney(double money){

    }

    public void updateFrame(){

        for(int l = 0 ; l < buttonList.size(); l++){
            buttonList.get(l).setVisible(false);

        }
        iconList = new ArrayList<ImageIcon>();
        buttonList = new ArrayList<JButton>();

        for(int i = 0; i < playerFood.size(); i++){
           iconList.add(new ImageIcon(new ImageIcon(playerFood.get(i).getPictureLocation()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))); 
        }

        int xBounds = 0;
        int secondXBounds = 0;
        int yBounds = 750;
        for(int j = 0; j < iconList.size(); j++){
            if(xBounds < 1500){
                buttonList.add(new JButton(iconList.get(j)));
                buttonList.get(j).setBounds(xBounds,yBounds,100,100);
                //this.add(buttonList.get(j));
                xBounds += 100;
            }
            else{
                buttonList.add(new JButton(iconList.get(j)));
                buttonList.get(j).setBounds(secondXBounds,yBounds+100,100,100);
                //this.add(buttonList.get(j));
                secondXBounds += 100;

            }
        }

        ButtonHandler handler = new ButtonHandler(buttonList, playerFood);
        for (JButton j : buttonList) {
            j.addActionListener(handler);
            this.add(j);
        }

        //this.add(new MinigameComponent(currentCustomer.getPicture()));
        this.add(minigame);

    }

    private class ButtonHandler implements ActionListener {

        private ArrayList<JButton> buttons;
        private ArrayList<Food> inventory;

        public ButtonHandler (ArrayList<JButton> buttons, ArrayList<Food> inventory) {
            this.buttons = buttons;
            this.inventory = inventory;
        }

        @Override
        public void actionPerformed(ActionEvent e) {


            for(int i = 0 ; i < buttons.size(); i ++){
                if (e.getSource() == buttons.get(i)) {
                    System.out.println(inventory.get(i).getName());
                    try {
                        Message msg = new SellFoodMessage(inventory.get(i));
                        queue.put(msg);
                    } catch (InterruptedException error) {
                        // do nothing
                    }
                }
            }
        }

    }


}
