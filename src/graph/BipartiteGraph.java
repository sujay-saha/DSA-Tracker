package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraph {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        int m = edges.length;
        int color[] = new int[V];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            color[i] = -1;
        }
        for(int i = 0;i<=m;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        color[0]=0;

        while(!queue.isEmpty()){
            int node = queue.peek();

            queue.poll();

            for(int adjNode:adj.get(node)){
                if(color[adjNode]==-1){
                    color[adjNode]=1-color[node];
                    queue.add(adjNode);
                }
                else if(color[adjNode]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}
