

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DiceTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DiceTest
{
    /**
     * Default constructor for test class DiceTest
     */
    public DiceTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void diceRollTest(){
        Dice test = new Dice(123, 100);
        for(int i = 0; i<10; i++){
            int result = test.roll();
            assertTrue(result<100 && result>10);
            assertTrue(result != test.roll());
        }
    }
    
}
