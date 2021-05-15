package restaurant.message;

import restaurant.Food;

public class SellFoodMessage implements Message {
    private Food soldFood;

    public SellFoodMessage (Food f) {
        soldFood = f;
    }

    public Food getSoldFood() {
        return soldFood;
    }
}
