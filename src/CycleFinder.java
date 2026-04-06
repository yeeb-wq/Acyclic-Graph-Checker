//  A.K.E.M.Perera -20240017 -w2120037
import java.util.*;

public class CycleFinder {

    private Graph graph; //stores the graph object
    private boolean[] visited; //track nodes currently in the recretion stacks
    private boolean[] stack; //keep track of nodes already visited
    private int[] parent; //store the parent of each node
    private List<Integer> cycle; //store actual cycle when found

    public CycleFinder(Graph graph) {
        this.graph = graph; //save the graph
        int V = graph.getV();
        visited = new boolean[V]; //initialise visited array
        stack = new boolean[V]; //initialise recursion stack array
        parent = new int[V]; //initialise parent array
        Arrays.fill(parent, -1); //set all parents to minus 1, means no parent yet
    }

    public List<Integer> findCycle() { //main function to detect a cycle
        for (int i = 0; i < graph.getV(); i++) { //loop through all nodes
            if (!visited[i]) { //run ds from that node if cycle found
                if (dfs(i)) {
                    return cycle;
                }
            }
        }
        return null; //if no cycle found return null
    }

    private boolean dfs(int node) {
        visited[node] = true; //mark node visited
        stack[node] = true; //add node to recursion stack

        for (int neighbor : graph.getAdj().get(node)) { //loop through all neighbours of current node

            if (!visited[neighbor]) { //set parent
                parent[neighbor] = node;
                if (dfs(neighbor)) return true;
            }
            else if (stack[neighbor]) { //if neighbor is in recursion cycle exits
                cycle = new ArrayList<>();
                int curr = node;

                cycle.add(neighbor); //add starting point of cycle

                while (curr != neighbor) { //go back until reaching cycle start
                    cycle.add(curr); // add node to cycle
                    curr = parent[curr]; //move to parent
                }

                cycle.add(neighbor); //add neighbor again to complete cycle
                return true; //cycle found
            }
        }

        stack[node] = false; // to stop the infinity cycle run (remove it from current dfs part)
        return false;
    }
}