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
    static void bfs(List<List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean vis[] = new boolean[adj.size()+1];
        vis[1]= true;

        while(!q.isEmpty()){
            Integer val = q.poll();
            System.out.println(val);

            for(int i =0;i<adj.get(val).size();i++){
                int index = adj.get(val).get(i);
                if(!vis[index])
                {
                    q.add(index);
                    vis[index]=true;
                }
            }
        }

    }

    public static void main(String[] args) {
        int n = 8, m = 3;
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

        addEdge(adj, 1, 2);
        addEdge(adj, 1, 6);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 6, 7);
        addEdge(adj, 6, 8);
        addEdge(adj, 4, 5);
        addEdge(adj, 7, 5);

        bfs(adj);
        //printGraph(adj, n);
    }

}
