package restaurant;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;


public class Player {

    //private String Name;
    private HashSet<Food> Inventory;
    private double balance;
    public Player()
    {
        //this.Name = name;
        this.Inventory = new HashSet<Food>();
        this.balance = 500;
        Inventory.add(new Food(1.5,3,"Bread", "restaurant/images/transparentBreadNew.png"));
        Inventory.add(new Food(3, 3, "Onigiri", "restaurant/images/transparentOnigiriNew.png"));
        Inventory.add(new Food(1, 3, "Cup Noodle", "restaurant/images/transparentCupNoodleNew.png"));
    }
    public void addFood(Food f){
        Inventory.add(f);
    
    }

    public ArrayList<Food> getFood(){
        ArrayList<Food> Inventory2 = new ArrayList<Food>(Inventory);
        return Inventory2;
    }

    public void addMoney(double moneyEarned){

        this.balance += moneyEarned;
    }

    public double getMoneyMade()
    {
        return balance;
    }

    public void subtractMoney() {
        balance -= 100;
    }
    




}
