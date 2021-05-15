package restaurant;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Player Class
 * Keeps track of all the Food and Money the Player has
 */
public class Player {

    private HashSet<Food> Inventory;
    private double balance;

    /**
     * Constructor for Player
     * No need for input, only instantiating the player with some money and starting food
     */
    public Player()
    {
        this.Inventory = new HashSet<Food>();
        this.balance = 500;
        Inventory.add(new Food(1.5,3,"Bread", "restaurant/images/transparentBreadNew.png"));
        Inventory.add(new Food(3, 3, "Onigiri", "restaurant/images/transparentOnigiriNew.png"));
        Inventory.add(new Food(1, 3, "Cup Noodle", "restaurant/images/transparentCupNoodleNew.png"));
    }

    /**
     * Adds food to Player's Food Arraylist
     * @param f food
     */
    public void addFood(Food f){
        Inventory.add(f);
    
    }

    /**
     * Getter method of Food in Player
     * @return ArrayList of Food from Inventory
     */
    public ArrayList<Food> getFood(){
        ArrayList<Food> Inventory2 = new ArrayList<Food>(Inventory);
        return Inventory2;
    }

    /**
     * Adds money to the balance from food sale
     * @param moneyEarned
     */
    public void addMoney(double moneyEarned){

        this.balance += moneyEarned;
    }

    /**
     * Getter method for balance
     * @return balance
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     * When Gacha is rolled, Balance must go down by $100
     */
    public void subtractFromGachaRoll() {
        balance -= 100;
    }
    




}
