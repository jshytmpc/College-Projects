import Interfaces.DFT;
import java.io.*;
import java.util.*;

class DepthFirstTraversal implements DFT {
    private int V;
    private LinkedList<Integer> adj[];

    DepthFirstTraversal(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void DFSUtil(int v, boolean visited[]) {

        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v) {

        boolean visited[] = new boolean[V];

        DFSUtil(v, visited);
    }



    public static void main(String args[]) {
        int noNodes = 0, s = 0, d = 0, noEdges = 0;
        String line = "";
        try {
            File file = new File("src/loadfile.txt");
            Scanner sc = new Scanner(file);
            line = sc.nextLine();
            line = line.replaceAll("[^0-9]","");
            line = line.replaceAll("\\s","");
            noNodes = Integer.parseInt(line);
            line = sc.nextLine();
            line = line.replaceAll("[^0-9]","");
            line = line.replaceAll("\\s","");
            noEdges = Integer.parseInt(line);
            DepthFirstTraversal g = new DepthFirstTraversal(noNodes);
            for (int i = 0; i < noEdges; i++) {
                line = sc.nextLine();
                line = line.replaceAll("[a-zA-Z]","");
                line = line.replaceAll("\\s","");
                s = Integer.parseInt(line.substring(0,1));
                d = Integer.parseInt(line.substring(1));
                g.addEdge(s,d);
            }
            sc.close();
            System.out.println("Following is Depth First Traversal (starting from vertex 2)");
            g.DFS(2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}