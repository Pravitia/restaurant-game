package restaurant;

import java.util.ArrayList;
import java.util.Random;

public class GachaRoll {
    private ArrayList<Food> foodPool;
    private Random rand;
    public GachaRoll(ArrayList<Food> foodList)
    {
        foodPool = foodList;
        rand = new Random();

    }

    public Food getRandomFood()
    {
        return foodPool.get(rand.nextInt(foodPool.size()));
    }
}
