package restaurant;

import java.util.ArrayList;

public class Food{

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

    public double getPrice() {
        
        return this.Price;
    }
    public String getName() {
        
        return this.Name;
    }

    public int getRarity()
    {
        return Rarity;
    }

    public int hashCode() {
        return (int) this.getPrice() + this.getRarity() + this.getName().hashCode() + this.getPictureLocation().hashCode();
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Food)) return false;
        if (o == this) return true;
        Food other = (Food) o;
        return this.getName().equals(other.getName()) && this.getRarity() == other.getRarity() && this.getPrice() == other.getPrice() && this.getPictureLocation().equals(other.getPictureLocation());
    }

    /**
     * Returns the picture address in the game
     * @return pictureLocation
     */
    public String getPictureLocation()
    {
        return pictureLocation;
    }

}