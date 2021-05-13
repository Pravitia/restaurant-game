package restaurant;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

public class MinigameButtonHandler implements ActionListener {

    private ArrayList<JButton> buttons;
    private ArrayList<Food> inventory;

    public MinigameButtonHandler (ArrayList<JButton> buttons, ArrayList<Food> inventory) {
        this.buttons = buttons;
        this.inventory = inventory;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttons.get(0)) {
            System.out.println(inventory.get(0).getName());
        }

    }
    
}
