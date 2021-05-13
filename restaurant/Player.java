package restaurant;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;


public class Player {

    //private String Name;
    private HashSet<Food> Inventory;
    private double Balance;
    private double moneyMade;
    public Player()
    {
        //this.Name = name;
        this.Inventory = new HashSet<Food>();
        this.Balance = 0;
        this.moneyMade = 0;
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

        this.moneyMade += moneyEarned;
    }

    public double getMoneyMade()
    {
        return moneyMade;
    }


    public double getBalance()
    {
        return Balance;
    }

    




}
