import java.util.ArrayList;
/**
 * This player will always choose to follow the longest neighboring edge
 * unless an exit node is in its neighbor as well
 *
 * @author Shiho Numakura 
 * @version 1
 */
public class PlaysFarthest extends Player
{
    //whole graph of maze 
    Graph graph;
    public PlaysFarthest(Graph graph, Node start, ArrayList<Node> exits, int limit)
    {
        super(start, exits, limit);
        this.graph = graph;
    }

    //returns edge that player picks to move on to 
    //takes longest edge until it finds the exiting node within limit 
    public Edge pick(){
        //if theres only one edge directing out the node 
        if(node.getNeighbors().size() == 1)
            return node.getNeighbor(0);
        else{
            //temporary edge with max weight 
            Edge max = node.getNeighbor(0);
            //compares to all other edges for an edge with a greater weight 
            for(int i = 1; i<node.getNeighbors().size(); i++){
                if(max.getCost()< node.getNeighbor(i).getCost())
                    max = node.getNeighbor(i);
                }
            return max;
        }
    }
    
     //overrides method to use dijkstra's shortest path algorithm 
   //IF exiting node is within the limit 
    public boolean checkAround(ArrayList<Node> exits){
       //creates arraylist to store the shortest distance from current node 
       ArrayList<Integer> distance = new ArrayList<Integer>();
       distance = Dijkstra();
       //stores farthest exit node within limit 
       Node farthestExit = null;
       //initialize distance to farthest exit node to infinity 
       int max = Integer.MAX_VALUE;
       //finds the farthest exit node 
       for(int j = 0; j<exits.size();j++){
           //checks if exiting node is within limit 
          if(distance.get((exits.get(j).getN()-1)) <= limit){
              //if no other exit nodes and distance were found yet 
              if(farthestExit == null){
                  max = distance.get((exits.get(j).getN()-1));
                  farthestExit = exits.get(j);
              //updates with farther exiting nodes 
              }else if(distance.get((exits.get(j).getN()-1)) >max){
                  max = distance.get((exits.get(j).getN()-1));
                  farthestExit = exits.get(j);
              }
          }
       }
       //if there is no exiting nodes within limit 
       if(farthestExit == null){
           return false;
        }
        
       else{
           //traverse through the shortest path to the farthest exit node within limit 
           Node prev = farthestExit.getPrev();
           //tracks through shortest path until the current node 
           while(prev.getPrev() != null){
               prev = prev.getPrev();
           }
           //finds edge that is directing to the node it wants to go 
           for(int i =0; i < node.getNeighbors().size(); i++){
               if(node.getNeighbor(i).getDNode().equals(prev)){
                       edge = node.getNeighbor(i);
                       return true;
                   }
            }
           return false;
            }
   }

    //finds distances to all nodes from current node 
    private ArrayList<Integer> Dijkstra(){
       ArrayList<Integer> DijkstraD = new ArrayList<Integer>();
       //graph is initialized to peform Dijkstra's algorithm 
       graph.initialize();
       //initialize distance to all nodes to 
       for (int i =0; i<graph.getGraph().size(); i++){
           DijkstraD.add(Integer.MAX_VALUE);
           //set 0 distance to current node 
           if(i == node.getN()-1)
            DijkstraD.set(i, 0);
        }
        //goes through all nodes in graph 
       for(int i = 0; i<graph.getGraph().size(); i++){
           ////finds Node that is closes to current node
           Node v = minNode(DijkstraD);
           //no edges direct to the node 
           if(v == null)
                return DijkstraD;
           //set node that it is visited already 
           v.setVisited();
           //updates distance of the neighboring nodes if it finds a closer edge to reach the node 
           for(int j = 0; j<v.getNeighbors().size(); j++){
               //updates neighboring nodes 
               int w =  v.getNeighbor(j).getNodeD();
               //updates with closer distance 
               if(DijkstraD.get(w-1)>(DijkstraD.get(v.getN()-1) 
               + v.getNeighbor(j).getCost()) ){
                DijkstraD.set(w-1, DijkstraD.get(v.getN()-1) + v.getNeighbor(j).getCost());
                graph.getGraph(w-1).setPrev(v);
               }
            }
        }
       return DijkstraD;
    }
    
    //finds the node closest to current node that has not been visited 
    private Node minNode(ArrayList<Integer> D){
        //goes through all nodes' distance from current node 
        for(int i = 0; i<D.size(); i++){
            //takes first node that has not been visited yet 
            if(!graph.getGraph(i).getVisited()){
                //store itemporary min distanced node 
                int min = i; 
                //goes through nodes to find closer nodes that are not visited yet 
                for(int j = i; j<D.size(); j++){
                    if(D.get(min)>D.get(j) && !graph.getGraph(j).getVisited())
                        min = j;
                }
                //checks if node can be reacher by an edge 
                if(D.get(min) != Integer.MAX_VALUE){
                    return graph.getGraph(min);
                }
                break;
            }
        }
        return null;
    }
}
