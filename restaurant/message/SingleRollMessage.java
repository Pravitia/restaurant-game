package restaurant.message;
import restaurant.Food;
import restaurant.GachaRoll;

public class SingleRollMessage implements Message {
    private Food foodRolled;
    private GachaRoll roll = new GachaRoll();

    public SingleRollMessage() {
        foodRolled = roll.getRandomFood();

    }

    public Food getFoodRolled(){
        return foodRolled;
    }



}
