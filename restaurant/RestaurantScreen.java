package restaurant;

public class RestaurantScreen {

    //private or public?
    private String pictureLocation;
    public Customer currentCustomer;

    public Food getPlayerFood(){

        //selects a food from the player's inventory of food

        //to implement
        return new Food(0, 0, "name", "pictureLocation");

    }

    private Customer createNewCustomer(){

        //returns customer
        return new Customer();
    }



    
}
