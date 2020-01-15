import java.util.ArrayList;
import java.util.Scanner;
/**
 * Acts as my ExperimentController class.
 * The maze and the players are all controlled through here by user input
 *
 * @author Shiho Numakura
 * @version 1
 */
public class Game
{


    
    public Game()
    {
        
    }
    
    //main()
    public static void main(String[] args){
        //reads file in and create appropriate graph
        fileReader file = new fileReader(args[3], args[4]);
        //store data taken from input files through fileReader 
        Node start = file.getStart();
        ArrayList<Node> exits = file.getExits();
        Graph graph = file.getGraph();
        //create dice for the game 
        Dice dice = new Dice(123, Integer.parseInt(args[2]));
        
        //create players for the game 
        Players players = new Players(graph, Integer.parseInt(args[0]), 
        Integer.parseInt(args[1]), start, exits, dice);
        //number of rounds the game has played 
        int round = 0;
        
        //whether there is a winner in game 
        boolean game = false;
        //user input 
        String answer;
        //scans user input 
        Scanner scanner = new Scanner(System.in);
        //prompt user 
        System.out.println("What would you like to do?");
        //as long as there is no winner and user inputs a prompt, the game will run
        while(!game && scanner.hasNext()){
            //user input 
            answer = scanner.nextLine();
            //exits game 
            if(answer.equals("x"))
                System.exit(0);
            //plays the game until there is a winner 
            else if(answer.equals("c")){
                //loops while there is no winner 
                while(!game){
                    game = players.around();
                    round++;
                    players.printPosition();
                }
                break;
            }
            //print players positions
            else if(answer.equals("p")){
                players.printPosition();
            }
            //plays one turn of all player 
            else if(answer.equals("i")){
                game = players.around();
                round++;
            }
            System.out.println("What would you like to do?");
        }
        //when there is a winner 
        //tells user the winner and the number of rounds the game has played 
        System.out.println("Congradulations! player "+ players.getWinner()+" has won on its "+ (round+1)+ "th turn!");
        //prints final position of all players 
        players.printPlayers();
        
    }
    
    

}
