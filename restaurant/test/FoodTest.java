package restaurant.test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import restaurant.Food;

/**
 * Test Food Class
 */
public class FoodTest {
    /**
     * Test Initializing
     */
    @Test
    public void initializeFood()
    {
        Food test = new Food(1,1,"Test","TestLocation");
    }

    /**
     * Test Equality (Suppose to equal)
     */
    @Test
    public void testEquality1()
    {
        Food test = new Food(1,1,"Test","TestLocation");
        Food test2 = new Food(1,1,"Test","TestLocation");
        assertEquals(test,test2);
    }

    /**
     * Check if price is different
     */
    @Test
    public void testEquality2()
    {
        Food test = new Food(1,1,"Test","TestLocation");
        Food test2 = new Food(2,1,"Test","TestLocation");
        if(test.equals(test2))
        {
            fail("Not suppose to be equal");
        }
    }

    /**
     * Check if rarity is different
     */
    @Test
    public void testEquality3()
    {
        Food test = new Food(1,1,"Test","TestLocation");
        Food test2 = new Food(1,2,"Test","TestLocation");
        if(test.equals(test2))
        {
            fail("Not suppose to be equal");
        }
    }

    /**
     * Check if name is different
     */
    @Test
    public void testEquality4()
    {
        Food test = new Food(1,1,"Test","TestLocation");
        Food test2 = new Food(1,2,"","TestLocation");
        if(test.equals(test2))
        {
            fail("Not suppose to be equal");
        }
    }

    /**
     * Check if pictureLocation is different
     */
    @Test
    public void testEquality5()
    {
        Food test = new Food(1,1,"Test","TestLocation");
        Food test2 = new Food(1,2,"Test","Test");
        if(test.equals(test2))
        {
            fail("Not suppose to be equal");
        }
    }
}
