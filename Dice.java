import java.util.Random;
/**
 * This object will allow players to roll the dice 
 * to generate the steps to take at that turn
 *
 * @author Shiho Numakura
 * @version 1
 */
public class Dice
{
    //random class
    private Random dice;
    //max value that this dice will give 
    private int max;
    
    public Dice(int seed, int max)
    {
        this.max = max;
        //initialize random class with given seed 
        dice = new Random((int)System.nanoTime());
    }
    
    public int roll(){
        //minimum value this dice will give is 0
        //return value of dice roll 
        return dice.nextInt(max-10) +10;
    }

    
}
