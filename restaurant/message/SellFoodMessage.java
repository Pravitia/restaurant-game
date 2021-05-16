package restaurant.message;

import restaurant.Food;

/**
 * Message to sell food tu customer in queue
 */
public class SellFoodMessage implements Message {
    private Food soldFood;

    public SellFoodMessage (Food f) {
        soldFood = f;
    }

    public Food getSoldFood() {
        return soldFood;
    }
}
