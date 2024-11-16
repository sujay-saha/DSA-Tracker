import java.util.ArrayList;
import java.util.List;

public class Graph {

    static void addEdge(List<List<Integer>> adj, int src, int des) {
        adj.get(src).add(des);
        adj.get(des).add(src);
    }

    static void printGraph(List<List<Integer>> adj, int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + "->");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5, m = 3;
        List<List<Integer>> adj = new ArrayList<>();

        //n+1 elements
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 2, 5);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);

        printGraph(adj, n);
    }

}
