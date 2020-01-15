import java.util.ArrayList;
/**
 * This player will always choose to follow the first edge in option
 * unless an exit node is in its neighbor 
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlaysFirst extends Player
{
    
    public PlaysFirst(Node start, ArrayList<Node> exits, int limit)
    {
        super(start, exits, limit);
    }
    
    //returns an edge that player picked to move on
    public Edge pick(){
        //if there is only one edge directing out the node 
        if(node.getNeighbors().size() == 1)
            return node.getNeighbor(0);
        else{
            //picks the first option of edge 
            Edge potential = node.getNeighbor(0);
            //makes sure player didn't come from that node 
            if(potential.equals(prev)){
                    //if it is the node that player just came from, picks the second option 
                    potential = node.getNeighbor(1);
                }
            return potential;
            }
    }
    
    
    
    
    
    
    

}
