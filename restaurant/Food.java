package restaurant;

import java.util.ArrayList;

public class Food implements Consumables{

    private double Price;
    private int Rarity;
    private String Name;
    private String pictureLocation;

    // Construct Food

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


    
}