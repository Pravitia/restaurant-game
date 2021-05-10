package restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.awt.Image.*;


public class MinigameFrame extends JFrame{
    BlockingQueue<Message> queue;
    private ArrayList<Food> playerFood = new ArrayList<Food>();
    private ArrayList<Food> secondList;
    private ArrayList<ImageIcon> iconList = new ArrayList<ImageIcon>();
    private ArrayList<JButton> buttonList = new ArrayList<JButton>();

    final int FRAME_WIDTH = 1500;
    final int FRAME_HEIGHT = 1000;
    MinigameComponent minigame = new MinigameComponent();

    ImageIcon burgerIcon, cupNoodleIcon, friesIcon, hotdogIcon, milkshakeIcon,
                pizzaIcon, ramenIcon, chickenIcon, sodaIcon, steakIcon, cakeIcon,
                sushiIcon, tacoIcon, sandwichIcon;
    JButton burgerButton, cupNoodleButton, friesButton, hotdogButton, milkshakeButton,
                pizzaButton, ramenButton, chickenButton, sodaButton, steakButton, cakeButton,
                sushiButton, tacoButton, sandwichButton;

    public MinigameFrame(BlockingQueue<Message> queue)
    {
        this.queue = queue;
        

        //playerFood.add(new Food(15, 4, "Burger", "restaurant/images/transparentBurgerNew.png"));
        //playerFood.add(new Food(12, 4, "Pepperoni Pizza", "restaurant/images/transparentPepperoniPizzaNew.png"));
        //playerFood.add(new Food(10, 3, "Turkey Sandwich", "restaurant/images/transparentTurkeySandwichNew.png"));
        //Food icons
        /*
        burgerIcon = new ImageIcon(new ImageIcon("restaurant/images/transparentBurgerNew.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        cupNoodleIcon = new ImageIcon(new ImageIcon("restaurant/images/transparentCupNoodleNew.png").getImage().getScaledInstance(70, 100, Image.SCALE_DEFAULT));
        friesIcon = new ImageIcon(new ImageIcon("restaurant/images/transparentFriesNew.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        hotdogIcon = new ImageIcon(new ImageIcon("restaurant/images/transparentHotdogNew.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        milkshakeIcon = new ImageIcon(new ImageIcon("restaurant/images/transparentMilkshakeNew.png").getImage().getScaledInstance(50, 100, Image.SCALE_DEFAULT));
        pizzaIcon = new ImageIcon(new ImageIcon("restaurant/images/transparentPepperoniPizzaNew.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        ramenIcon = new ImageIcon(new ImageIcon("restaurant/images/transparentRamenNew.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        chickenIcon = new ImageIcon(new ImageIcon("restaurant/images/transparentRotisserieChickenNew.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        sodaIcon = new ImageIcon(new ImageIcon("restaurant/images/transparentSodaNew.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        steakIcon = new ImageIcon(new ImageIcon("restaurant/images/transparentSteakNew.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        cakeIcon = new ImageIcon(new ImageIcon("restaurant/images/transparentStrawberryCakeNew.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        sushiIcon = new ImageIcon(new ImageIcon("restaurant/images/transparentSushiNew.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        tacoIcon = new ImageIcon(new ImageIcon("restaurant/images/transparentTacoNew.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        sandwichIcon = new ImageIcon(new ImageIcon("restaurant/images/transparentTurkeySandwichNew.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        */
        System.out.println(playerFood.size());
        for(int i = 0; i < playerFood.size(); i++){
            System.out.println(i);
           iconList.add(new ImageIcon(new ImageIcon(playerFood.get(i).getPictureLocation()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
           System.out.println("test");
        }
        System.out.println("test");




        //Food buttons
        int xBounds = 0;
        for(int j = 0; j < iconList.size(); j++){
            buttonList.add(new JButton(iconList.get(j)));
            buttonList.get(j).setBounds(xBounds,850,100,100);
            this.add(buttonList.get(j));
            xBounds += 100;
        }
        /*

        burgerButton = new JButton(burgerIcon);
        burgerButton.setBounds(0, 850, 100, 100);
        cupNoodleButton = new JButton(cupNoodleIcon);
        cupNoodleButton.setBounds(100, 850, 100, 100);
        friesButton = new JButton(friesIcon);
        friesButton.setBounds(200, 850, 100, 100);
        hotdogButton = new JButton(hotdogIcon);
        hotdogButton.setBounds(300, 850, 100, 100);
        milkshakeButton = new JButton(milkshakeIcon);
        milkshakeButton.setBounds(400, 850, 100, 100);
        pizzaButton = new JButton(pizzaIcon);
        pizzaButton.setBounds(500, 850 ,100, 100);
        ramenButton = new JButton(ramenIcon);
        ramenButton.setBounds(600, 850, 100, 100);
        chickenButton = new JButton(chickenIcon);
        chickenButton.setBounds(700, 850, 100, 100);
        sodaButton = new JButton(sodaIcon);
        sodaButton.setBounds(800, 850, 100 ,100);
        steakButton = new JButton(steakIcon);
        steakButton.setBounds(900, 850, 100, 100);
        cakeButton = new JButton(cakeIcon);
        cakeButton.setBounds(1000, 850, 100, 100);
        sushiButton = new JButton(sushiIcon);
        sushiButton.setBounds(1100, 850, 100, 100);
        tacoButton = new JButton(tacoIcon);
        tacoButton.setBounds(1200, 850, 100, 100);
        sandwichButton = new JButton(sandwichIcon);
        sandwichButton.setBounds(1300, 850, 100, 100);



        this.add(burgerButton);
        this.add(cupNoodleButton);
        this.add(friesButton);
        this.add(hotdogButton);
        this.add(milkshakeButton);
        this.add(pizzaButton);
        this.add(ramenButton);
        this.add(chickenButton);
        this.add(sodaButton);
        this.add(steakButton);
        this.add(cakeButton);
        this.add(sushiButton);
        this.add(tacoButton);
        this.add(sandwichButton);
        */
        this.add(minigame);
        


        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void updatePlayerFood(ArrayList<Food> f){
        playerFood = f;
        updateFrame();
        
    }

    public void updateFrame(){
        
        for(int i = 0; i < playerFood.size(); i++){
            System.out.println(i);
           iconList.add(new ImageIcon(new ImageIcon(playerFood.get(i).getPictureLocation()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))); 
        }

        int xBounds = 0;
        for(int j = 0; j < iconList.size(); j++){
            buttonList.add(new JButton(iconList.get(j)));
            buttonList.get(j).setBounds(xBounds,850,100,100);
            this.add(buttonList.get(j));
            xBounds += 100;
        }

        this.add(minigame);

    }




}
