

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NodeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NodeTest
{
    /**
     * Default constructor for test class NodeTest
     */
    public NodeTest()
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
    public void testNode(){
        Node test = new Node(3);
        assertEquals(test.getN(), 3);
        assertTrue(test.getNeighbors().size() == 0);
    }
    
    @Test
    public void addEdgeTest(){
        Node test = new Node(1);
        
        Node node = new Node(2);
        Edge edge1 = new Edge(node, 4);
        Edge edge2 = new Edge(new Node(3), 9);
        Edge edge3 = new Edge(node, 3);
        
        test.addEdge(edge1);
        assertTrue(test.getNeighbors().size() == 1);
        assertTrue(test.getNeighbors().contains(edge1));
        test.addEdge(edge2);
        assertTrue(test.getNeighbors().contains(edge2));
        
        
        test.addEdge(edge3);
        assertTrue(test.getNeighbors().contains(edge1));
        assertEquals(test.getNeighbor(0).getCost(), 3);
    }
    
    @Test
    public void neighborTest(){
        Node test = new Node(1);
        
        Edge edge1 = new Edge(new Node(2), 2);
        Edge edge2 = new Edge(new Node(3), 3);
        Edge edge3 = new Edge(new Node(4), 7);
        
        test.addEdge(edge1);
        test.addEdge(edge2);
        test.addEdge(edge3);
        
        assertTrue(test.getNeighbors().size() == 3);
        assertEquals(test.getNeighbor(0), edge1);
        assertEquals(test.getNeighbor(2), edge3);
        assertEquals(test.getNeighbor(4), null);
        
    }
    
    @Test
    public void visitedTest(){
        Node test = new Node(1);
        assertFalse(test.getVisited());
        test.setVisited();
        assertTrue(test.getVisited());
    }
    
    @Test
    public void DijkstraTest(){
        Node test = new Node(1);
        test.initializeDijkstra();
        assertFalse(test.getVisited());
        assertEquals(test.getPrev(), null);
        
        Node prev = new Node(2);
        test.setPrev(prev);
        assertEquals(prev, test.getPrev());
    }
    
        
        
}
