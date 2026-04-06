//  A.K.E.M.Perera -20240017 -w2120037
import java.io.*; //for file reading
import java.util.*;

public class GraphParser {

    public static Graph parseFile(String filePath) { //method declaration
        Graph graph = null; //initialize graph

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath)); //file reading - opens file for reading line by line
            String line; // variable for storing each line

            int V = Integer.parseInt(br.readLine().trim()); //read numbers of vertices
            graph = new Graph(V);// initialise graph with v vertices

            while ((line = br.readLine()) != null) { //read edges, loop through remaining lines
                line = line.trim(); //removes extra spaces

                if (line.isEmpty()) continue; //skip empty lines

                String[] parts = line.split("\\s+");

                if (parts.length != 2) { //validate formats
                    System.out.println("SKIPPING INVALID LINE : " + line);
                    continue;
                }

                int u = Integer.parseInt(parts[0]); //converts strings to integer
                int v = Integer.parseInt(parts[1]);

                graph.addEdge(u, v); //add edges
            }

            br.close(); //close file after reading

        } catch (Exception e) {
            System.out.println("Error reading file: " + filePath); //error handling
        }

        return graph;
    }
}