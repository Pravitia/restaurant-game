package restaurant;

public class SellFoodMessage implements Message {
    private Food soldFood;

    public SellFoodMessage (Food f) {
        soldFood = f;
    }
}
