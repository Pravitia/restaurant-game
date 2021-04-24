package restaurant;

public class Food implements Consumables{

    private double Price;
    private String Rarity;
    private String Name;
    private String pictureLocation;
    public Food(double price, String rarity, String name, String pictureLocation)
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

    public String getRarity()
    {
        return Rarity;
    }

    public String getPictureLocation()
    {
        return pictureLocation;
    }







}