package restaurant;

import java.util.ArrayList;

public class Food implements Consumables{

    private double Price;
    private int Rarity;
    private String Name;
    private String pictureLocation;
    public ArrayList<Food> loot = new ArrayList<>();

    public Food() {
        loot.add(new Food(25, 5, "Steak", "restaurant/images/transparentSteakNew.png"));
        loot.add(new Food(18, 4, "Rotisserie Chicken", "restaurant/images/transparentRotisserieChickenNew.png"));
        loot.add(new Food(1.50, 3, "Hotdog", "restaurant/images/transparentHotdogNew.png"));
        loot.add(new Food(15, 4, "Burger", "restaurant/images/transparentBurgerNew.png"));
        loot.add(new Food(12, 4, "Pepperoni Pizza", "restaurant/images/transparentPepperoniPizzaNew.png"));
        loot.add(new Food(10, 3, "Turkey Sandwich", "restaurant/images/transparentTurkeySandwichNew.png"));
        loot.add(new Food(3.5, 3, "Fries", "restaurant/images/transparentFriesNew.png"));
        loot.add(new Food(14, 4, "Ramen", "restaurant/images/transparentRamenNew.png"));
        loot.add(new Food(16, 4, "Sushi", "restaurant/images/transparentSushiNew.png"));
        loot.add(new Food(35, 5, "Strawberry Cake", "restaurant/images/transparentStrawberryCakeNew.png"));
        loot.add(new Food(1, 3, "Cup Noodle", "restaurant/images/transparentCupNoodleNew.png"));
        loot.add(new Food(13, 4, "Tacos", "restaurant/images/transparentTacoNew.png"));
        loot.add(new Food(2, 3, "Soda", "restaurant/images/transparentSodaNew.png"));
        loot.add(new Food(7, 3, "Milkshake", "restaurant/images/transparentMilkshakeNew.png"));
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