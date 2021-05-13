package restaurant;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

public class MinigameButtonHandler implements ActionListener {

    private ArrayList<JButton> buttons;

    public MinigameButtonHandler (ArrayList<JButton> buttons) {
        this.buttons = buttons;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttons.get(0)) {
            System.out.println(buttons.get(0).getName());
        }

        
    }
    
}
