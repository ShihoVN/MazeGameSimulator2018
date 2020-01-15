
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlayersTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PlayersTest
{
    /**
     * Default constructor for test class PlayersTest
     */
    public PlayersTest()
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
    public void PlayersTest(){
        fileReader data = new fileReader("inputMazeTest.txt","inputNodesTest.txt");
        Graph graph = new Graph(data.getGraph());
        ArrayList<Node> exits = data.getExits();
        Node start = data.getStart();
        Dice dice = new Dice(123, 24);
        
        Players test = new Players(graph, 100, 5, start, exits, dice);
        assertEquals(5, test.getPlayers().size());
    }
    
    @Test
    public void aroundTest(){
        fileReader data = new fileReader("inputMazeTest.txt","inputNodesTest.txt");
        Graph graph = new Graph(data.getGraph());
        ArrayList<Node> exits = data.getExits();
        Node start = data.getStart();
        Dice dice = new Dice(123, 24);
        
        Players test = new Players(graph, 100, 5, start, exits, dice);
        test.around();
        for(Player player: test.getPlayers()){
            assertTrue(0<player.getStepsTaken());
        }
    }
}
