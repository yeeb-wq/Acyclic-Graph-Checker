//  A.K.E.M.Perera -20240017 -w2120037
import java.util.*;

public class Graph {
//represents directed graphs
    private int V; //No of vertices (nodes)
    private List<List<Integer>> adj;
    //variables

    //constructor called when creating graph
    public Graph(int V) {
        this.V = V; //store number of vertices
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) { //create empty list for each vertex
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public int getV() {
        return V;
    } //get no of nodes

    public List<List<Integer>> getAdj() {
        return adj;
    } //Gives access to graph structure

    //creates a duplicate graph
    public Graph copy() {
        Graph newGraph = new Graph(V); //create new graph
        for (int i = 0; i < V; i++) {
            newGraph.adj.get(i).addAll(adj.get(i));
        } //copy all edges
        return newGraph;
    }
}