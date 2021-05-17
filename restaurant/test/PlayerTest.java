package restaurant.test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import restaurant.Food;
import restaurant.Player;

public class PlayerTest {
    /**
     * Check if it can initialize
     */
    @Test
    public void initializePlayer()
    {
        Player testPlayer = new Player();
    }

    /**
     * Test adding food
     */
    @Test
    public void testAddFood()
    {
        Player testPlayer = new Player();
        testPlayer.addFood(new Food(1,1,"Test",""));
        assertEquals(4,testPlayer.getFood().size());
    }
    /**
     * Test adding food with duplicate (Should still only add one)
     */
    @Test
    public void testAddFoodDuplicate()
    {
        Player testPlayer = new Player();
        testPlayer.addFood(new Food(1,1,"Test",""));
        testPlayer.addFood(new Food(1,1,"Test",""));
        assertEquals(4,testPlayer.getFood().size());
    }

    /**
     * Test adding money
     */
    @Test
    public void addMoney()
    {
        Player testPlayer = new Player();
        testPlayer.addMoney(10);
        assertEquals(510,testPlayer.getBalance());

    }

    /**
     * Test subtracting money
     */
    @Test
    public void subtractFromGacha()
    {
        Player testPlayer = new Player();
        testPlayer.subtractFromGachaRoll();
        assertEquals(400,testPlayer.getBalance());

    }

    /**
     * Test subtracting money until it reaches 0 (Testing to make sure it can't be negative)
     */
    @Test
    public void subtractFromGachaTestLimit()
    {
        Player testPlayer = new Player();
        testPlayer.subtractFromGachaRoll();
        testPlayer.subtractFromGachaRoll();
        testPlayer.subtractFromGachaRoll();
        testPlayer.subtractFromGachaRoll();
        testPlayer.subtractFromGachaRoll();
        testPlayer.subtractFromGachaRoll();
        assertEquals(0,testPlayer.getBalance());

    }
}
