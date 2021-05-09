package restaurant;

import java.util.ArrayList;

public class Food implements Consumables{

    private double Price;
    private int Rarity;
    private String Name;
    private String pictureLocation;
    public ArrayList<Food> loot = new ArrayList<Food>();

    public Food() {
        loot.add(new Food(25, 5, "Steak", "images/steakPicture"));
        loot.add(new Food(18, 4, "Rotisserie Chicken", "images/chickenPicture"));
        loot.add(new Food(1.50, 3, "Hotdog", "images/hotdogPicture"));
        loot.add(new Food(15, 4, "Burger", "images/burgerPicture"));
        loot.add(new Food(12, 4, "Pepperoni Pizza", "pizzaPicture"));
        loot.add(new Food(10, 3, "Turkey Sandwich", "sandwichPicture"));
        loot.add(new Food(3.5, 3, "Fries", "friesPicture"));
        loot.add(new Food(14, 4, "Ramen", "ramenPicture"));
        loot.add(new Food(16, 4, "Sushi", "sushiPicture"));
        loot.add(new Food(35, 5, "Strawberry Cake", "cakePicture"));
        loot.add(new Food(1, 3, "Cup Noodle", "noodlePicture"));
        loot.add(new Food(13, 4, "Tacos", "tacoPicture"));
        loot.add(new Food(2, 3, "Soda", "sodaPicture"));
        loot.add(new Food(7, 3, "Milkshake", "milkshakePicture"));
    }

    public Food(double price, int rarity, String name, String pictureLocation)
    {
        this.Price = price;
        this.Rarity = rarity;
        this.Name = name;
        this.pictureLocation = pictureLocation;

    }
    @Override
    public double getPrice() {
        
        return this.Price;
    }
    @Override
    public String getName() {
        
        return this.Name;
    }

    public int getRarity()
    {
        return Rarity;
    }

    public String getPictureLocation()
    {
        return pictureLocation;
    }

    public ArrayList<Food> getLoot(){
        return loot;
    }

    
}