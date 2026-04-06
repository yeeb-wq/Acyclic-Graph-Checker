//  A.K.E.M.Perera -20240017 -w2120037
import java.util.*;

public class Main {
//entry point of the program
    public static void main(String[] args) {
        //main method that program start executing
        int[] sizes = {40, 80, 160, 320, 640, 1280, 2560, 5120, 10240}; //sizes array defines different graph size

        System.out.println("===== ACYCLIC TESTS =====");
        //acyclic loop - loop through each graph size
        for (int size : sizes) {
            String filePath = "input/acyclic/a_" + size + "_0.txt";

            Graph g = GraphParser.parseFile(filePath); //read the files and create the graph

            long start = System.nanoTime(); //record start time
            boolean result = CycleDetector.isAcyclic(g.copy()); //run Algorithm
            long end = System.nanoTime(); //records end time

            System.out.println("Size: " + size +
                    " | Result: " + result +
                    " | Time: " + (end - start) + " ns");
        }

        System.out.println("\n===== CYCLIC TESTS =====");
        //cyclic loop
        for (int size : sizes) {
            String filePath = "input/cyclic/c_" + size + "_0.txt";

            Graph g = GraphParser.parseFile(filePath); //load graph from file

            long start = System.nanoTime();
            boolean result = CycleDetector.isAcyclic(g.copy());
            long end = System.nanoTime();
            // measuring time
            System.out.println("Size: " + size +
                    " | Result: " + result +
                    " | Time: " + (end - start) + " ns");


            if (!result) { //if result is false graph is a cycle
                CycleFinder finder = new CycleFinder(g); //prepare dfs base cycle detection
                List<Integer> cycle = finder.findCycle(); //finding the cycle - returns list of nodes forming cycles

                if (cycle != null) {
                    Collections.reverse(cycle); //fix order
                    System.out.print("Cycle found: ");
                    for (int i = 0; i < cycle.size(); i++) {   //print each node
                        System.out.print(cycle.get(i));
                        if (i < cycle.size() - 1) {
                            System.out.print(" → "); //add arrows between nodes
                        }
                    }
                    System.out.println();
                }
            }
        }
    }
}