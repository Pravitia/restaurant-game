package restaurant;

import java.util.ArrayList;

public class Customer {


    //connect this with Player inventory
    private ArrayList<Food> orderList;
    private Food Order;

    public Food getOrder(){

        //default change later
        return new Food(0, 0, "name", "pictureLocation");



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
