package restaurant;

import java.util.ArrayList;

public class Player {

    //private String Name;
    private ArrayList<Food> Inventory;
    private double Balance;
    private double moneyMade;
    public Player()
    {
        //this.Name = name;
        this.Inventory = new ArrayList<Food>();
        this.Balance = 0;
        this.moneyMade = 0;
    }
    public void addFood(Food f){
        Inventory.add(f);

    }


    public ArrayList<Food> getFood(){

        return Inventory;
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
