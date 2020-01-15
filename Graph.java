import java.util.ArrayList;

/**
 * The maze will be stored in a graph implemented in an ArrayList 
 *
 * @author Shiho Numakura 
 * @version 1
 */
public class Graph
{
    private ArrayList<Node> graph;

    
    //when there is an given graph 
    public Graph(Graph original)
    {
        graph = new ArrayList<Node>(original.getGraph());
    }
    
    //creates graph with n nodes 
    public Graph(int n){
        graph = new ArrayList<Node>();
        for(int i =0; i<n; i++){
            graph.add(i, new Node(i+1));
        }
    }
    
    //initialize all nodes in graph to perform Dijkstra's algorithm
    public void initialize(){
        //goes through all nodes in graph 
        for(int i = 0; i <graph.size(); i++){
            graph.get(i).initializeDijkstra();
        }
        return;
    }
    
    //return graph 
    public ArrayList<Node> getGraph(){
        return graph;
    }
    
    //return specific node in the graph
    public Node getGraph(int i){
        return graph.get(i);
    }
    
    //adds an edge 
    public boolean addEdge(int k1, int k2, int w){
        //if given node numbers don't exist in graph
        if(k1 > graph.size() || k2 > graph.size())
            return false;
        
        //creates directed edge for both ways between given nodes 
        boolean first = graph.get(k1-1).addEdge(new Edge(graph.get(k2-1), w));
        boolean second = graph.get(k2-1).addEdge(new Edge(graph.get(k1-1), w));  
        //if both edges were added sucessfully 
        if(first && second) 
            return true;
        //if either edges fails to add in graph
        return false;
    }
    
    //prints all nodes in graph 
    public void printGraph(){
        //goes through all nodes in graph 
        for(int i = 0; i<graph.size(); i++){
            graph.get(i).printNode();
        }
        return;
    }
    
    
    

    
}
