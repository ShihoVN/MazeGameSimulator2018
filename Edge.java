
/**
 * Acts as a bridge from a Node to another Node.  
 * Each node will have a weight which will be the number of steps 
 * required to reach the destination node
 *
 * @author Shiho Numakura   
 * @version 1
 */
public class Edge
{
    //instance variable 
    //node that this edge directs to 
    private Node nodeD;
    //weight of the node 
    private int cost;
    
    public Edge()
    {
       
    }
    
    //creates an edge directing to given node with given weight
    public Edge(Node nodeD, int weight){
        this.nodeD = nodeD;
        cost = weight;
    }
    
    //returns directing node number 
    public int getNodeD(){
        return nodeD.getN();
    }
    //returns directing node 
    public Node getDNode(){
        return nodeD;
    }
    //sets the weight of node
    public void setCost(int weight){
        cost = weight;
    }
    //returns the wegith of node  
    public int getCost(){
        return cost;
    }
    //return string representation of the edge's weight  
    public String toString(){
        return Integer.toString(cost);
    }
    
    

    
}
