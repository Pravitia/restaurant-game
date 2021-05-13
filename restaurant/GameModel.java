package restaurant;

//Model class
public class GameModel {

    protected Player user;
    protected Customer newCustomer;
    String filepath;

    public GameModel() {
        this.user = new Player();
    }

    public Player getUser()
    {
        return user;
    }

    //for updating food picture in gacha
    public void setPicture(String s){
        this.filepath = s;
    }

    public String getDisplayFood()
    {
        return filepath;
    }

    public Customer makeCustomer(){

        return new Customer(user.getFood());
    }

}
