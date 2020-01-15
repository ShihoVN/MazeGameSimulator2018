import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlaysFirstTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PlaysFirstTest
{
    /**
     * Default constructor for test class PlaysFirstTest
     */
    public PlaysFirstTest()
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
    public void playerTest(){
        fileReader data = new fileReader("inputMazeTest.txt","inputNodesTest.txt");
        Graph graph = new Graph(data.getGraph());
        ArrayList<Node> exits = data.getExits();
        Node start = data.getStart();
        
        Player test = new PlaysFirst(start, exits, 100);
        assertEquals(1, test.getCNode());
        assertEquals("1 on the Node", test.getPosition());
        test.setEdge(new Edge(new Node(3), 3));
        assertEquals("1 to 3", test.getPosition());

    }
    
    @Test
    public void checkAroundTest(){
       fileReader data = new fileReader("inputMazeTest.txt","inputNodesTest.txt");
        Graph graph = new Graph(data.getGraph());
        ArrayList<Node> exits = data.getExits(); 
        Node start = data.getStart();
        
       Player test = new PlaysFirst(start, exits, 100);
       assertFalse(test.checkAround(exits));
       test.setNode(graph.getGraph(6));
       assertTrue(test.checkAround(exits));
       assertEquals(1,test.getEdge().getCost());

    }
    
    @Test
    public void playTest(){
        fileReader data = new fileReader("inputMazeTest.txt","inputNodesTest.txt");
        Graph graph = new Graph(data.getGraph());
        ArrayList<Node> exits = data.getExits(); 
        Node start = data.getStart();
        
        Player test = new PlaysFirst(start, exits, 100);
        test.play(2);
        assertEquals(2, test.getStepsTaken());
        assertEquals(null,test.getNode());
        assertTrue(test.getEdge() != null);
        test.play(5);
        assertEquals(7, test.getStepsTaken());

    }
    
    @Test
    public void getCNodeTest(){
        fileReader data = new fileReader("inputMazeTest.txt","inputNodesTest.txt");
        Graph graph = new Graph(data.getGraph());
        ArrayList<Node> exits = data.getExits(); 
        Node start = data.getStart();
        
        Player test = new PlaysFirst(start, exits, 100);
        assertEquals(1, test.getCNode());
        test.play(1);
        assertEquals(1, test.getCNode());
    }
    
    @Test
    public void pickTest(){
        fileReader data = new fileReader("inputMazeTest.txt","inputNodesTest.txt");
        Graph graph = new Graph(data.getGraph());
        ArrayList<Node> exits = data.getExits(); 
        Node start = data.getStart();
        
        Player test = new PlaysFirst(start, exits, 100);
        assertEquals(test.getNode().getNeighbor(0), test.pick());
        
    }
}
