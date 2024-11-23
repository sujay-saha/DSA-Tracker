import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    //Level Wise Traversal#BFS
    static void bfs(List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean vis[] = new boolean[adj.size() + 1];
        vis[1] = true;

        while (!q.isEmpty()) {
            Integer val = q.poll();
            System.out.println(val);

            for (int i = 0; i < adj.get(val).size(); i++) {
                int index = adj.get(val).get(i);
                if (!vis[index]) {
                    q.add(index);
                    vis[index] = true;
                }
            }
        }
    }

    static void dfs(int node, List<List<Integer>> adj, boolean vis[], List<Integer> dfsList) {

        vis[node] = true;
        dfsList.add(node);
        
        for (Integer val : adj.get(node)) {
            if (!vis[val]) {
                dfs(val, adj, vis, dfsList);
            }
        }

    }

    public static void main(String[] args) {
        int n = 9, m = 3;
        List<List<Integer>> adj = new ArrayList<>();

        //n+1 elements
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        /*addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 2, 5);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);*/
       /* //bfs
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 6);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 6, 7);
        addEdge(adj, 6, 8);
        addEdge(adj, 4, 5);
        addEdge(adj, 7, 5);*/

        //DFS LIST
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 5);
        addEdge(adj, 2, 6);
        addEdge(adj, 3, 4);
        addEdge(adj, 3, 7);
        addEdge(adj, 4, 8);
        addEdge(adj, 7, 8);

        //bfs(adj);

        boolean vis[] = new boolean[adj.size()];
        vis[1] = true;
        List<Integer> dfsTraversalList = new ArrayList<>();
        dfs(1, adj, vis, dfsTraversalList);
        System.out.println("DFS Traversal:");
        for (Integer val : dfsTraversalList) {
            System.out.print(val + " ");
        }
        //printGraph(adj, n);
    }

}
