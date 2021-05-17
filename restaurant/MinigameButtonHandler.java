package restaurant;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 * Handles the display of all the buttons for the Minigame
 */
public class MinigameButtonHandler implements ActionListener {

    private ArrayList<JButton> buttons;
    private ArrayList<Food> inventory;

    /**
     * Constructor for MinigameButtonHandler
     * @param buttons the list of buttons
     * @param inventory the list of food in inventory
     */
    public MinigameButtonHandler (ArrayList<JButton> buttons, ArrayList<Food> inventory) {
        this.buttons = buttons;
        this.inventory = inventory;
    }

    /**
     * Action performed method to check the minigame buttons
     * @param e The action event to click the button
     */
    public void actionPerformed(ActionEvent e) {

        
        for(int i = 0 ; i < buttons.size(); i ++){
            if (e.getSource() == buttons.get(i)) {
            System.out.println(inventory.get(i).getName());
        }
    }

    }
    
}
