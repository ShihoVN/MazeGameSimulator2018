import java.util.ArrayList;
/**
 * This player will always choose to follow the last edge in option
 * unless an exit node is in its neighbor 
 *
 * @author Shiho Numakura
 * @version 1
 */
public class PlaysLast extends Player
{

    public PlaysLast(Node start, ArrayList<Node> exits, int limit)
    {
        super(start, exits, limit);
    }
    
    //returns edge that player picks to move on to 
    public Edge pick(){
        //if there's only one edge directing out the node 
        if(node.getNeighbors().size() == 1)
            return node.getNeighbor(0);
        else{
            //picks the last option of edges to take 
            Edge potential = node.getNeighbor(node.getNeighbors().size()-1);
            //makes sure player didn't come from the node that the edge is directing 
            if(potential.equals(prev)){
                //chooses second to last option 
                potential = node.getNeighbor(node.getNeighbors().size()-2);
            }
            return potential;
        }
    }

}
