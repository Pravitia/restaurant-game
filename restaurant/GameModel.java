package restaurant;

/**
 * Model for al the logic in the game
 */
public class GameModel {

    protected Player user;
    private GachaRoll roller;
    private Customer newCustomer;
    String filepath;

    public GameModel() {
        this.user = new Player();
        this.roller = new GachaRoll();
        this.newCustomer = new Customer(getUser().getFood());
    }

    public Player getUser()
    {
        return user;
    }

    public GachaRoll getRoller(){
        return roller;
    }

    //for updating food picture in gacha
    public void setPicture(String s){
        this.filepath = s;
    }

    public String getDisplayFood()
    {
        return filepath;
    }

    public void makeCustomer(){
        newCustomer = new Customer(user.getFood());
    }

    public Customer getCustomer(){
        return newCustomer;
    }

}
