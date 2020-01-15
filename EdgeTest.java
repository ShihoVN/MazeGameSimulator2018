

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EdgeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EdgeTest
{
    /**
     * Default constructor for test class EdgeTest
     */
    public EdgeTest()
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
    public void edgeTest(){
        Node node1 = new Node(1);;
        Edge test = new Edge(node1, 3);
        assertEquals(test.getNodeD(), 1);
        assertEquals(test.getDNode(), node1);
        assertEquals(test.getCost(), 3);
        
        test.setCost(5);
        assertEquals(test.getCost(), 5);
        
        assertEquals(test.toString(), "5");
    }
}
