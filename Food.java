
public class Food implements Consumables{

    private double Price;
    private String Rarity;
    private String Name;
    private String pictureLocation;

    @Override
    public double getPrice() {
        
        return this.Price;
    }
    @Override
    public String getName() {
        
        return this.Name;
    }







}