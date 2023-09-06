import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphTester {
    public static void main(String[] args) {
        BreadthFirstTraversal gbfs;
        DepthFirstTraversal gdfs;
        DijkstraShortestPath dsp;
        PrintedMenus ptm = new PrintedMenus();
        Scanner sc = new Scanner(System.in);
        Scanner sc2;
        File file;
        int opt = 0, startV = 0;
        int noNodes = 0, noEdges = 0, s = 0, d = 0, weight = 0;
        String line = "";
        ptm.showIntroduction();
        ptm.menu();
        int myChoice;
        do {
            myChoice = enterChoice(1,6);
            switch (myChoice) {
                case 1:
                    try {
                        file = new File("src/loadfile.txt");
                        sc2 = new Scanner(file);
                        System.out.println();
                        System.out.println("Contents of the Loadfile: ");
                        System.out.println("____________________________");
                        while (sc2.hasNext()) {
                            System.out.println(sc2.nextLine());
                        }
                        sc2.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    System.out.println("Input the starting vertex");
                    startV = sc.nextInt();
                    sc.nextLine();
                    try {
                        file = new File("src/loadfile.txt");
                        sc2 = new Scanner(file);

                        line = sc2.nextLine();
                        line = line.replaceAll("[^0-9]","");
                        line = line.replaceAll("\\s","");
                        noNodes = Integer.parseInt(line);
                        gbfs = new BreadthFirstTraversal(noNodes);

                        line = sc2.nextLine();
                        line = line.replaceAll("[^0-9]","");
                        line = line.replaceAll("\\s","");
                        noEdges = Integer.parseInt(line);

                        for (int i = 0; i < noEdges; i++) {
                            line = sc2.nextLine();
                            line = line.replaceAll("[a-zA-Z]","");
                            line = line.replaceAll("\\s","");
                            s = Integer.parseInt(line.substring(0,1));
                            d = Integer.parseInt(line.substring(1,2));
                            gbfs.addEdge(s,d);
                        }
                        sc2.close();
                        System.out.println("Following is Breadth First Traversal (starting from vertex " + startV + ")");
                        gbfs.BFS(startV);
                        System.out.println();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.println("Input the starting vertex");
                    startV = sc.nextInt();
                    sc.nextLine();
                    try {
                        file = new File("src/loadfile.txt");
                        sc2 = new Scanner(file);

                        line = sc2.nextLine();
                        line = line.replaceAll("[^0-9]","");
                        line = line.replaceAll("\\s","");
                        noNodes = Integer.parseInt(line);
                        gdfs = new DepthFirstTraversal(noNodes);

                        line = sc2.nextLine();
                        line = line.replaceAll("[^0-9]","");
                        line = line.replaceAll("\\s","");
                        noEdges = Integer.parseInt(line);

                        for (int i = 0; i < noEdges; i++) {
                            line = sc2.nextLine();
                            line = line.replaceAll("[a-zA-Z]","");
                            line = line.replaceAll("\\s","");
                            s = Integer.parseInt(line.substring(0,1));
                            d = Integer.parseInt(line.substring(1,2));
                            gdfs.addEdge(s,d);
                        }
                        sc2.close();
                        System.out.println("Following is Depth First Traversal (starting from vertex " + startV + ")");
                        gdfs.DFS(startV);
                        System.out.println();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 4:
                    System.out.println("Input the starting vertex");
                    startV = sc.nextInt();
                    sc.nextLine();
                    List<List<Node>> adjacent = new ArrayList<List<Node> >();
                    try {
                        file = new File("src/loadfile.txt");
                        sc2 = new Scanner(file);

                        line = sc2.nextLine();
                        line = line.replaceAll("[^0-9]","");
                        line = line.replaceAll("\\s","");
                        noNodes = Integer.parseInt(line);
                        gdfs = new DepthFirstTraversal(noNodes);

                        line = sc2.nextLine();
                        line = line.replaceAll("[^0-9]","");
                        line = line.replaceAll("\\s","");
                        noEdges = Integer.parseInt(line);

                        for (int i = 0; i < noNodes; i++) {
                            List<Node> itm = new ArrayList<Node>();
                            adjacent.add(itm);
                        }
                        for (int i = 0; i < noEdges; i++) {
                            line = sc2.nextLine();
                            line = line.replaceAll("[^0-9]","");
                            line = line.replaceAll("\\s","");
                            s = Integer.parseInt(line.substring(0,1));
                            d = Integer.parseInt(line.substring(1,2));
                            weight = Integer.parseInt(line.substring(2));
                            adjacent.get(s).add(new Node(d,weight));
                        }
                        sc2.close();
                        dsp = new DijkstraShortestPath(noNodes);
                        dsp.dijkstra(adjacent,startV);
                        System.out.println("Following is the shortest path (starting from vertex " + startV + ")");
                        for (int j = 0; j < dsp.distance.length; j++) {
                            System.out.println(startV + " to " + j + " is " + dsp.distance[j]);
                        }
                        System.out.println();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 5: ptm.menu();
                    break;
            }
        } while (myChoice != 6);
        System.out.println("Thank you for using this program");
        
    }
    public static int enterChoice(int min, int max) {
        Scanner keyboard = new Scanner(System.in);
        int choice = 0;
        try {
            do {
                System.out.println();
                System.out.println("Option:");
                choice = keyboard.nextInt();
                if (choice < min || choice > max)
                    System.out.println("Invalid Choice please only enter a number from " + min + " to " + max);

            } while (choice < min || choice > max);
            return (choice);
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
        return choice;
    }
    
    
}
