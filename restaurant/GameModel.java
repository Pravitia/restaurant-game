package restaurant;

//Model class
public class GameModel {

    protected Player user;
    private GachaRoll roller;
    private Customer newCustomer= new Customer(user.getFood());
    String filepath;

    public GameModel() {
        this.user = new Player();
        this.roller = new GachaRoll();
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
