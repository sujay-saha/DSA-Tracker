package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UndirectedGraphCycle {

        public boolean checkForCycle(int src, int V, List<List<Integer>> adj, int vis[]){
            Queue<Pair1> queue = new LinkedList<Pair1>();

            vis[src]=1;
            queue.add(new Pair1(src,-1));

            while(!queue.isEmpty()){
                int node = queue.peek().node;
                int parent = queue.peek().prevNode;
                queue.poll();
                for(int val:adj.get(node)){
                    if(vis[val]==0){
                        vis[val]=1;
                        queue.add(new Pair1(val,node));
                    }else if(parent != val){
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean isCycle(int V, int[][] edges) {
            // Code here
            int vis[] = new int[V];
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                vis[i] = 0;
                adj.add(new ArrayList<>());
            }

            for (int edge[] : edges) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }

            for (int i = 0; i < V; i++) {
                if (vis[i] == 0) {
                    if (checkForCycle(i, V, adj, vis)) {
                        return true;
                    }
                }
            }

            return false;
        }
}

 class Pair1{
    int node;
    int prevNode;
    Pair1(int node, int prevNode){
        this.node = node;
        this.prevNode = prevNode;
    }
}