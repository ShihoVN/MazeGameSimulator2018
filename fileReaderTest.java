import java.util.Scanner;
import java.io.FileReader;
import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class fileReaderTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class fileReaderTest
{
    /**
     * Default constructor for test class fileReaderTest
     */
    public fileReaderTest()
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
    public void fileReaderTest(){
        fileReader test = new fileReader("inputMazeTest.txt","inputNodesTest.txt");
        Graph graph = new Graph(test.getGraph());
        ArrayList<Node> exits = test.getExits();
        Node start = test.getStart();
        
        assertEquals(1, start.getN());
        assertEquals(5, exits.get(0).getN());
        assertEquals(6, exits.get(1).getN());
        
        for(int i = 0; i<7; i++){
            assertEquals(i+1, graph.getGraph(i).getN());
        }
        assertEquals(7, graph.getGraph().size());
        assertEquals(2, graph.getGraph(6).getNeighbors().size());
        
        
        
    }
    
}
