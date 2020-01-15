import java.util.ArrayList;
/**
 * A Node in Maze graph.  
 * Each Node will be assigned with a node number to distinguish them
 * 
 * @author Shiho Numakura
 * @version 1
 */
public class Node
{
    //instance variables
    //node number 
    private int nodeN;
    //all edges directing out from this node 
    private ArrayList<Edge> neighbors;
    //used in Dijkstra's algorithm to keep in track of shortest path
    private  Node prev;
    //whether dijkstra's algorithm has visited this node 
    private boolean visited;
    
    public Node()
    {
        neighbors = new ArrayList<Edge>();
    }
    
    //creates node of n 
    public Node(int n){
        neighbors = new ArrayList<Edge>();
        nodeN = n;
    }
    
    //sets that the node has been visited 
    public void setVisited(){
        visited = true;
        return;
    }
    //initialize all nodes unvisited and pointer to prev Node in shortest path
    public void initializeDijkstra(){
        visited = false;
        prev = null;
        return;
    }
    //sets the previous node in shortest path
    public void setPrev(Node node){
        prev = node;
        return;
    }
    //return prev node 
    public Node getPrev(){
        return prev;
    }
    //return whether node has been visited 
    public boolean getVisited(){
        return visited;
    }
    
    //return node number 
    public int getN(){
        return nodeN;
    }
    //return an ArrayList of all edges directing out 
    public ArrayList<Edge> getNeighbors(){
        return neighbors;
    }
    //return edge of index i in neighbors 
    public Edge getNeighbor(int i){
        if(i<neighbors.size())
            return neighbors.get(i);
        return null;
    }
    //prints node number with its edges directing out 
    public void printNode(){
        System.out.print(nodeN + ":");
        for(Edge edge : neighbors){
            System.out.print(" " + edge.toString());
        }
        System.out.println("");
    }
    
    //add given edge that is directed from the node as neighbor
    public boolean addEdge(Edge newEdge){
        //check for exisiting edge directing to the same node 
        for(Edge edge : neighbors){
            //if edge directing to the same node exists, it will replace the weight 
            if(edge.getNodeD() == newEdge.getNodeD()){
                edge.setCost(newEdge.getCost());
                return false;
            }
        }
        //add edge if no other edge direct to the same node 
        neighbors.add(newEdge);
        return true ;
        }
        
}
    
    

    

