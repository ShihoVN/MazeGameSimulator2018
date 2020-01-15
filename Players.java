import java.util.ArrayList;
/**
 * Player Container class where all players of the game are stored 
 *
 * @author Shiho Numakura   
 * @version 1
 */
public class Players
{
    //all players playing the game 
    private ArrayList<Player> players;
    //dice for players to use 
    private Dice dice;
    //winner player 
    private Player winner;
    
    public Players(Graph graph, int limit, int Nplayers, Node start, ArrayList<Node> exits, Dice dice)
    {
        this.dice = dice;
        players = new ArrayList<Player>();
        //five different types of player creates one of each and added to container
        //until the number of players are created 
        for(int i = 0; i<Nplayers; i++){
            if(i%5 == 0){
                players.add((Player)new PlaysRandom(start, exits, limit));
            }
            else if(i%5 == 1){
                players.add((Player)new PlaysFirst(start, exits, limit));
            }
            else if(i%5 == 2){
                players.add((Player)new PlaysLast(start, exits, limit));
            }
            else if(i%5 == 3){
                players.add((Player)new PlaysShortest(graph, start, exits, limit));
            }
            else{
                players.add((Player)new PlaysFarthest(graph, start, exits, limit));
            }
        }
    }
    
    //each player will get a turn to play 
    public boolean around(){
        //goes through all players 
        for(int i = 0 ; i < players.size(); i++){
            //if player successfully reaches the exit node 
            if(players.get(i).play(dice.roll())){
                //assign winner 
                winner = players.get(i);
                return true;
            }
        }
        return false;
    }
    
    //print every player's current specific positions
    public void printPosition(){
        for(int i = 0; i< players.size(); i++){
            System.out.println("player " + (1+i) + ": " + players.get(i).getPosition());
        }
        return;
    }
    
    //print every player's current position and steps taken 
    public void printPlayers(){
        for(int i = 0; i< players.size(); i++){
            System.out.println("player " + (1+i) + ": " + players.get(i).getInfo());
        }
        return;
    }
    
    
    //return winner of the game 
    public int getWinner(){
        return players.indexOf(winner)+1;    
    }
    //returns all players in game 
    public ArrayList<Player> getPlayers(){
        return players;
    }


}
