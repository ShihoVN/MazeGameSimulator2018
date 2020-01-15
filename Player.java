import java.util.ArrayList;
/**
 * Abstract class Player - abstract player objects to play the maze 
 *
 * @author Shiho Numakura
 * @version 1
 */
public abstract class Player
{
    //instance variables 
    protected ArrayList<Node> exits;
    //steps that this player has played
    protected int stepsTaken =0;
    //steps to take the turn
    protected int steps =0;
    //current node that player is placed 
    protected Node node;
    //previus node that player passed 
    protected Node prev;
    //current edge that player is placed 
    protected Edge edge;
    //current position on the edge 
    protected int position;
    //limit that a player can see 
    protected int limit;
    
    
    public Player(Node start, ArrayList<Node> exits, int limit){
        this.limit = limit;
        this.exits = exits;
        node = start;
        prev = start;
    }
    
    //gets the closes node that player was on
    public int getCNode(){
        if(node != null)
            return node.getN();
        else if(prev != null)
            return prev.getN();
        return 0;
    }
        
    //plays a turn 
    //takes in the number of steps to take at this turn
    public boolean play(int steps){
        //while player has steps to move 
        while(steps >0){
            //if player is on a node 
            if(node!= null){
                //checks whether it an exit node 
                for(Node n : exits){
                    if(n.equals(node))
                        return true;
                }
                ///checks for an exist node in neighboring nodes 
                if(!checkAround(exits)){
                    //player picks an edge to move 
                    edge = pick();
                }
                //initialize position on edge 
                position = 0;
                //set current node as previous node 
                prev = node;
                //player will no longer be on a node 
                node = null;
            }
            
            //if player has more steps on its current edge 
            if(edge!= null && position <edge.getCost()){
                position++;
            }
            //player will leave the edge 
            else if(edge != null && position == edge.getCost()){
                //gets to the destination node on the edge 
                node = edge.getDNode();
                edge = null;
            }
            //increment steps 
            steps--;
            stepsTaken++;
        }
        return false;
    }
    
    //each player will be assigned with different algorithms to pick their directions 
    abstract public Edge pick();
    
    //checks if there are any exit nodes in neighboring nodes 
    public boolean checkAround(ArrayList<Node> exits){
        for(int i = 0; i<node.getNeighbors().size(); i++){
            for(int j = 0; j<exits.size(); j++){
                //if edge is greater than player's limit, it will not be able to tell whether if its an exit node or not 
                //if there is an exit node in neighbor 
                if(node.getNeighbor(i).getCost() < limit &&
                node.getNeighbor(i).getDNode().equals(exits.get(j))){
                    //player will move on to the edge directing to the exit node
                    edge = node.getNeighbor(i);
                    //return true because it found an exit node 
                    return true;
                } 
            }
        }
        //returns false if player couldn't find an exit node in neighbor 
        return false;
    }
    
    //return node number that player has passed last and the steps that player took 
    public String getInfo(){
        return getCNode() +" " + stepsTaken + "steps taken";
    }
    
    //return player's position specifically  
    public String getPosition(){
        if(node != null)
            return node.getN() + " on the Node";
        else if(prev != null)
            return prev.getN() + " to "+ edge.getNodeD();
        return "lost";
    }
    
    //sets player to a specified node 
    //used in junit 
    public void setNode(Node node){
        edge = null;
        this.node = node;
    }
    
    ///sets player to a specified edge
    //used in junit 
    public void setEdge(Edge edge){
        prev = node;
        node = null;
        this.edge = edge;
    }
    
    //return edge where player is 
    public Edge getEdge(){
        return edge;
    }
    //rrturn the number of steps that player has taken
    public int getStepsTaken(){
        return stepsTaken;
    }
    //return Node that player is currently at 
    public Node getNode(){
        return node;
    }
    //return node that player has passed 
    public Node getPrev(){
        return prev;
    }
       
    
    
    
    
    
    
   
}
