import java.util.Scanner;
import java.io.FileReader;
import java.util.ArrayList;
/**
 * This will go through the input files given and absorb the appropriate information
 *
 * @author Shiho Numakura
 * @version 1
 */
public class fileReader
{
    //instance variables 
    //graph created from input file 
    private Graph graph;
    //node to start the game 
    private Node start;
    //exit nodes to win the game 
    private ArrayList<Node> exits;
    
    public fileReader(String fileName1, String fileName2)
    {
        //initialize array 
        exits = new ArrayList<Node>();
        
        //reads through the input files
        read1(fileName1);
        read2(fileName2);
    }
    //reads through first file to create graph 
    private void read1(String fileName){
        try{
            Scanner scanner = new Scanner(new FileReader(fileName));
            //max node number given in file 
            int max = 0;
            //looks for the max node number by going through the entire file 
            while(scanner.hasNextLine()){
                String[] line = scanner.nextLine().split(" ");
                if(Integer.parseInt(line[0]) > max)
                    max = Integer.parseInt(line[0]);
                if(Integer.parseInt(line[2]) > max)
                    max = Integer.parseInt(line[2]);   
            }
            //creates graph using the max node number given
            graph = new Graph(max);
            //reset scanner
            scanner = new Scanner(new FileReader(fileName));
            //adds given edges in graph 
            while(scanner.hasNextLine()){
                String[] line = scanner.nextLine().split(" ");
                graph.addEdge(Integer.parseInt(line[0]), 
                Integer.parseInt(line[2]), Integer.parseInt(line[3]));
            }
            
            return;
            
        }
        catch(Exception e){
           System.out.println(e); 
        }
    }
    
    //reads through the seconf input file and finds the starting and exiting nodes 
    private void read2(String fileName){
        try{  
            //scanner to go through the file 
            Scanner scanner = new Scanner(new FileReader(fileName));
            //starting node number 
            String[] line1 = scanner.nextLine().split(" ");
            //find starting node in graph 
            start = graph.getGraph().get(Integer.parseInt(line1[1])-1);
            //exiting node numbers 
            String[] line2 = scanner.nextLine().split(" ");
            //finds exiting nodes in graph and stores in ArrayList 
            for(int i = 1; i<line2.length; i++){
                exits.add(graph.getGraph().get(Integer.parseInt(line2[i])-1));
            }

          }
        catch(Exception e){
           System.out.println("second" + e); 
        }
    }  
    
    //return graph 
    public Graph getGraph(){
        return graph;
    }
    //return exiting nodes 
    public ArrayList<Node> getExits(){
        return exits;
    }
    //return starting nodes 
    public Node getStart(){
        return start;
    }
    
            

    
}
