package restaurant;

import java.util.ArrayList;
import java.util.Random;

public class Customer {


    //connect this with Player inventory
    private Random rand;
    private ArrayList<Food> orderList;
    private Food Order;

    public Customer(ArrayList<Food> foodList)
    {
        orderList = foodList;
        rand = new Random();
        Order = foodList.get(rand.nextInt(foodList.size()));
    }

    public Food getOrder(){

        //default change later
        return Order;
    }

    public boolean isCorrect(Food f){
        //default false for now
        return false;
    }

    public double getMoney(){
        //returns food price
        return Order.getPrice();
    }


    
}
