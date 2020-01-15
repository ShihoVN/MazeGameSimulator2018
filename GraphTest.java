

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GraphTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GraphTest
{
    /**
     * Default constructor for test class GraphTest
     */
    public GraphTest()
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
    public void testGraph(){
        Graph test = new Graph(5);
        assertEquals(5, test.getGraph().size());
        for(int i = 0; i<5; i++){
            assertTrue(test.getGraph(i) != null);
        }
    }
    
    @Test
    public void addEdgeTest(){
        Graph test = new Graph(5);
        assertFalse(test.addEdge(6, 7, 9));
        
        test.addEdge(1, 3, 5);
        test.addEdge(2, 3, 5);
        test.addEdge(4, 3, 5);
        test.addEdge(4, 5, 5);
        
        assertEquals(3, test.getGraph(2).getNeighbors().size());
        assertEquals(4, test.getGraph(4).getNeighbor(0).getNodeD());
    }
    
    @Test
    public void initializeTest(){
        Graph test = new Graph(5);
        test.addEdge(1, 3, 5);
        test.addEdge(2, 3, 5);
        test.addEdge(4, 3, 5);
        test.addEdge(4, 5, 5);
        test.initialize();
        for (int i = 0; i<5; i++){
            assertFalse(test.getGraph(i).getVisited());
            assertTrue(test.getGraph(i).getPrev() == null);
        }
    }
}
