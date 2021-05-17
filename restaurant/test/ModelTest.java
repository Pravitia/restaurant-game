package restaurant.test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import restaurant.Customer;
import restaurant.GameModel;

/**
 * Test the Model Itself
 */
public class ModelTest {
    /**
     * Test Initializing
     */
    @Test
    public void initializedGameModel()
    {
        GameModel test = new GameModel();
    }
    /**
     * Test the picture
     */
    @Test
    public void setPictureTestWithEmpty()
    {
        GameModel test = new GameModel();
        assertEquals("",test.getDisplayFood());
    }
    /**
     * Test the setPicture
     */
    @Test
    public void setPictureTest()
    {
        GameModel test = new GameModel();
        test.setPicture("test");
        assertEquals("test",test.getDisplayFood());
    }
    /**
     * Test the makeCustomer
     */
    @Test
    public void makeCustomer()
    {
        GameModel test = new GameModel();
        Customer firstCustomer = test.getCustomer();
        test.makeCustomer();
        Customer secondCustomer = test.getCustomer();
        if(firstCustomer.equals(secondCustomer))
            fail("Should not be equal");
    }

}
