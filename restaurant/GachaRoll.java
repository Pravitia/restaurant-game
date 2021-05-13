package restaurant;

import java.util.ArrayList;
import java.util.Random;

//gacha model class
public class GachaRoll {
    private Random rand;
    private ArrayList<Food> loot;

    public GachaRoll()
    {
        rand = new Random();
        loot = new ArrayList<>();
        loot.add(new Food(25, 5, "Steak", "restaurant/images/transparentSteakNew.png"));
        loot.add(new Food(18, 4, "Rotisserie Chicken", "restaurant/images/transparentRotisserieChickenNew.png"));
        loot.add(new Food(1.50, 3, "Hot Dog", "restaurant/images/transparentHotdogNew.png"));
        loot.add(new Food(15, 4, "Burger", "restaurant/images/transparentBurgerNew.png"));
        loot.add(new Food(12, 4, "Pepperoni Pizza", "restaurant/images/transparentPepperoniPizzaNew.png"));
        loot.add(new Food(10, 3, "Turkey Sandwich", "restaurant/images/transparentTurkeySandwichNew.png"));
        loot.add(new Food(3.5, 3, "Fries", "restaurant/images/transparentFriesNew.png"));
        loot.add(new Food(14, 4, "Ramen", "restaurant/images/transparentRamenNew.png"));
        loot.add(new Food(16, 4, "Sushi", "restaurant/images/transparentSushiNew.png"));
        loot.add(new Food(35, 5, "Strawberry Cake", "restaurant/images/transparentStrawberryCakeNew.png"));
        loot.add(new Food(5, 3, "Chicken Nuggets", "restaurant/images/transparentChickenNuggetsNew.png"));
        loot.add(new Food(13, 4, "Tacos", "restaurant/images/transparentTacoNew.png"));
        loot.add(new Food(2, 3, "Soda", "restaurant/images/transparentSodaNew.png"));
        loot.add(new Food(7, 3, "Milkshake", "restaurant/images/transparentMilkshakeNew.png"));
    }

    public Food getRandomFood()
    {
        return loot.get(rand.nextInt(loot.size()));
    }
}
