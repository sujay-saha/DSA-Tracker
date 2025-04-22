package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BasicTraversal {

    static void addEdge(List<List<Integer>> adj, int src, int des) {
        adj.get(src).add(des);
        adj.get(des).add(src);
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
        //bfs
        /*addEdge(adj, 1, 2);
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

        boolean vis[] = new boolean[adj.size()];
        //vis[1] = true;
        List<Integer> dfsTraversalList = new ArrayList<>();
        //dfs(1, adj, vis, dfsTraversalList);
        System.out.println("DFS Traversal:");
       /* for (Integer val : dfsTraversalList) {  //1 2 5 6 3 4 8 7
            System.out.print(val + " ");
        }*/


        //bfs(1,adj,vis,new LinkedList<Integer>());

        dfs(1, adj, vis, new LinkedList<Integer>());
    }

    public static void bfs(int startNode, List<List<Integer>> adj, boolean vis[], Queue<Integer> queue){
        queue.add(startNode);
        vis[startNode]=true;

        while(!queue.isEmpty()){
            Integer nodeVal = queue.poll();
            System.out.print(nodeVal+" ");

            for(Integer val: adj.get(nodeVal)){
                if(!vis[val]){
                    queue.add(val);
                    vis[val]=true;
                }
            }
        }
    }


    public static void dfs(int node,List<List<Integer>> adj,boolean vis[],Queue<Integer> queue){
        queue.add(node);
        System.out.print(node+" ");
        vis[node]=true;
        for(Integer val: adj.get(node)){
            if(!vis[val]){
                dfs(val,adj,vis,queue);
            }
        }
    }
}
