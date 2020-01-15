import java.util.Random;
import java.util.ArrayList;
/**
 * This player will choose an edge randomly every round 
 *
 * @author Shiho Numakura 
 * @version 1
 */
public class PlaysRandom extends Player
{
    //random class to pick direction randomly 
    Random random;

    public PlaysRandom(Node start, ArrayList<Node> exits, int limit)
    {
        super(start, exits, limit);
        random = new Random(111);
    }
    
    //returns edge player moves on to 
    public Edge pick(){
        //if there is only one edge directing out the node 
        if(node.getNeighbors().size() == 1)
            return node.getNeighbor(0);
            
        else{
            //picks a random edge 
            Edge potential = node.getNeighbor(random.nextInt(node.getNeighbors().size()));
            //makes sure player didn't come from the node that its trying to move to
            while(potential.equals(prev)){
                //finds a different edge to move on 
                potential = node.getNeighbor(random.nextInt(node.getNeighbors().size()));
            }
            return potential;
        }
    }
    
    



}
