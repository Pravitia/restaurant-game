import java.util.ArrayList;

public class Player {

    private String Name;
    private ArrayList<Food> Inventory;
    private double Balance = 50.00;
    private double moneyMade;

    private void addFood(Food f){


    }


    public ArrayList<Food> getFood(){

        return Inventory;
    }

    public void addMoney(double moneyEarned){

        this.moneyMade += moneyEarned;
    }


    


    
}
