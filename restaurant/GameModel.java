package restaurant;

/**
 * Model for al the logic in the game
 */
public class GameModel {

    protected Player user;
    private GachaRoll roller;
    private Customer newCustomer;
    String filepath;

    /**
     * Constructor for the Game Model
     * Intialize the Player, GachaRoll, and first Customer
     */
    public GameModel() {
        this.user = new Player();
        this.roller = new GachaRoll();
        this.newCustomer = new Customer(getUser().getFood());
    }

    /**
     * Getter method for User
     * @return user Gets the user
     */
    public Player getUser()
    {
        return user;
    }

    /**
     * Getter method for GachaRoll
     * @return roller Get the roller Gacharoll
     */
    public GachaRoll getRoller(){
        return roller;
    }

    /**
     * Set method to set the filepath for the image to show
     * @param s filepath for picture
     */
    public void setPicture(String s){
        this.filepath = s;
    }

    /**
     * Getter method for the filepath
     * @return filepath of the picture of food
     */
    public String getDisplayFood()
    {
        return filepath;
    }

    /**
     * Instantiate a new Customer
     */
    public void makeCustomer(){
        newCustomer = new Customer(user.getFood());
    }

    /**
     * Getter method for Customer
     * @return newCustomer is a new customer for the Minigame
     */
    public Customer getCustomer(){
        return newCustomer;
    }

}
