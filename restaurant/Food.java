package restaurant;

/**
 * Food Class
 * Used to build the food object to sell to customers
 */
public class Food{

    private double Price;
    private int Rarity;
    private String Name;
    private String pictureLocation;

    /**
     * Food Constructor
     * @param price price of food
     * @param rarity rarity of food
     * @param name name of the food
     * @param pictureLocation address location for the picture
     */
    public Food(double price, int rarity, String name, String pictureLocation)
    {
        this.Price = price;
        this.Rarity = rarity;
        this.Name = name;
        this.pictureLocation = pictureLocation;

    }

    /**
     * Getter method for price
     * @return Price
     */
    public double getPrice() {
        
        return this.Price;
    }

    /**
     * Getter method for name
     * @return Name
     */
    public String getName() {
        
        return this.Name;
    }

    /**
     * Getter Method for Rarity
     * @return Rarity
     */
    public int getRarity()
    {
        return Rarity;
    }

    /**
     * Get the hashcode of Food
     * @return hashcode of the Food
     */
    public int hashCode() {
        return (int) this.getPrice() + this.getRarity() + this.getName().hashCode() + this.getPictureLocation().hashCode();
    }

    /**
     * Food equal method
     * @param o Get another object
     * @return boolean if it is equal or not
     */
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