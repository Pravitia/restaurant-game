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
//        Inventory.add(new Food(15, 4, "Burger", "restaurant/images/transparentBurgerNew.png"));
//        Inventory.add(new Food(12, 4, "Pepperoni Pizza", "restaurant/images/transparentPepperoniPizzaNew.png"));
//        Inventory.add(new Food(10, 3, "Turkey Sandwich", "restaurant/images/transparentTurkeySandwichNew.png"));
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
