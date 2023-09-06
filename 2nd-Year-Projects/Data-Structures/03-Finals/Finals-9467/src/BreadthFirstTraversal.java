import Interfaces.BFT;

import java.io.File;
import java.util.*;


class BreadthFirstTraversal implements BFT {
    private int V;
    private LinkedList<Integer> adj[];

    BreadthFirstTraversal(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }
    public void BFS(int s) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0) {

            s = queue.poll();
            System.out.print(s+" ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        int noNodes = 0, s = 0, d = 0;
        String line = "";
        try {
            File file = new File("src/loadfile.txt");
            Scanner sc = new Scanner(file);
            line = sc.nextLine();
            line = line.replaceAll("[^0-9]","");
            line = line.replaceAll("\\s","");
            noNodes = Integer.parseInt(line);
            BreadthFirstTraversal g = new BreadthFirstTraversal(noNodes);
            while(sc.hasNext()) {
                line = sc.nextLine();
                line = line.replaceAll("[a-zA-Z]","");
                line = line.replaceAll("\\s","");
                s = Integer.parseInt(line.substring(0,1));
                d = Integer.parseInt(line.substring(1));
                g.addEdge(s,d);
            }
            System.out.println("Following is Breadth First Traversal (starting from vertex 2)");
            g.BFS(2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}