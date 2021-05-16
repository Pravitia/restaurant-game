package restaurant;

import java.util.ArrayList;
import java.util.Random;

/**
 * Customer to give the Player an objective
 */
public class Customer {

    private Random rand;
    private ArrayList<Food> orderList;
    private ArrayList<String> pictureLocationList;
    private String picture;
    private Food Order;

    /**
     * Constructor for Customer
     * Intializes the orderlist and Order
     * @param foodList the food the Player has
     */
    public Customer(ArrayList<Food> foodList)
    {
        orderList = foodList;
        rand = new Random();
        Order = foodList.get(rand.nextInt(foodList.size()));
        
    }

    /**
     * Getter method for Order
     * @return Order the random food that is selected
     */
    public Food getOrder(){
        return Order;
    }

    /**
     * Getter method of the Picture of Customer
     * @return picture of Customer
     */
    public String getPicture(){
        pictureLocationList.add("restaurant/images/customer1.png");
        pictureLocationList.add("restaurant/images/customer2.png");
        picture = pictureLocationList.get(rand.nextInt(pictureLocationList.size()));
        return picture;
    }


    
}
