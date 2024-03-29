package restaurant;

import restaurant.message.Message;
import restaurant.message.SellFoodMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 * Make the logic behind Minigame
 */
public class MinigameFrame extends JFrame{
    BlockingQueue<Message> queue;
    private ArrayList<Food> playerFood = new ArrayList<>();
    private ArrayList<ImageIcon> iconList = new ArrayList<>();
    private ArrayList<JButton> buttonList = new ArrayList<>();
    private Customer currentCustomer;

    final int FRAME_WIDTH = 1500;
    final int FRAME_HEIGHT = 1000;

    String basepath = "restaurant/images/transparent.png";
    MinigameComponent minigame = new MinigameComponent(basepath);

    JTextField moneyBar;
    double money = 500;

    /**
     * Constructor for MinigameFrame
     * @param queue Push the quueue into MinigrameFrame
     */
    public MinigameFrame(BlockingQueue<Message> queue)
    {
        this.queue = queue;

        Font font = new Font("Arial", Font.BOLD, 30);
        this.moneyBar = new JTextField(String.format("$%.2f", money));
        moneyBar.setFont(font);
        moneyBar.setBounds(1300, 10, 150, 30);
        moneyBar.setEditable(false);

        this.add(moneyBar);
        this.add(minigame);

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Updates the Player Food ArrayList and update frame
     * @param f Food ArrayList
     */
    public void updatePlayerFood(ArrayList<Food> f){
        playerFood = f;
        updateFrame();
        
    }

    /**
     * Updates the customer with a new random customer
     * @param c New customer
     */
    public void updateCustomer(Customer c){
        currentCustomer = c;

    }

    /**
     * Updates the Frame for the User
     */
    public void updateFrame(){

        for(JButton button : buttonList)
        {
            button.setVisible(false);
        }

        iconList = new ArrayList<>();
        buttonList = new ArrayList<>();

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

    /**
     * Make the button Handler for the Minigame
     */
    private class ButtonHandler implements ActionListener {

        private ArrayList<JButton> buttons;
        private ArrayList<Food> inventory;

        /**
         * Constructor for the ButtonHandler
         * @param buttons List of buttons
         * @param inventory List of inventory to add to buttons
         */
        public ButtonHandler (ArrayList<JButton> buttons, ArrayList<Food> inventory) {
            this.buttons = buttons;
            this.inventory = inventory;
        }

        /**
         * Actionperformed for each button
         * @param e The action event to attach to the buttons
         */
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
