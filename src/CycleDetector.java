//  A.K.E.M.Perera -20240017 -w2120037
import java.util.*;

public class CycleDetector {

    public static boolean isAcyclic(Graph graph) {

        int V = graph.getV(); //get number of vertices (total number of nodes)
        List<List<Integer>> adj = graph.getAdj(); //graph structure

        int[] outDegree = new int[V];//array to store number of outgoing edges per node

        for (int i = 0; i < V; i++) {
            outDegree[i] = adj.get(i).size();
        }

        Queue<Integer> queue = new LinkedList<>(); //find all sinks

        for (int i = 0; i < V; i++) { //add all nodes with outdegree = 0 => sink
            if (outDegree[i] == 0) {
                queue.add(i);
            }
        }

        int removed = 0; //remove sinks - count how many nodes removed

        while (!queue.isEmpty()) { //process until no sink left
            int node = queue.poll(); //remove sink from graph
            removed++;

            for (int i = 0; i < V; i++) { //remove incoming edges to node
                if (adj.get(i).contains(node)) {
                    adj.get(i).remove(Integer.valueOf(node)); //remove edge
                    outDegree[i]--; //decrease outgoing count

                    if (outDegree[i] == 0) { //check if new sink created
                        queue.add(i);
                    }
                }
            }
        }

        return removed == V; //if all nodes removed = no cycle
    }
}