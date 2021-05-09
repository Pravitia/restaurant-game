package restaurant;
import java.util.ArrayList;

public class SingleRollMessage implements Message{
    private Food foodRolled;
    private Food temp = new Food();
    private ArrayList<Food> foodList = temp.getLoot();
    private GachaRoll roll = new GachaRoll(foodList);

    public SingleRollMessage(){
        
        foodRolled = roll.getRandomFood();

    }

    public Food getFoodRolled(){
        return foodRolled;
    }



}
