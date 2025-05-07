package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {

    public static void dfs(int src, List<List<Integer>> adj, int vis[], ArrayList<Integer> topoSorted){

        vis[src]=1;

        for(int adjNode: adj.get(src)){
            if(vis[adjNode]==0){
                dfs(adjNode,adj,vis,topoSorted);
            }
        }
        topoSorted.add(0,src);

    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> topoSorted = new ArrayList<>();
        for(int i=0;i<V;i++){
            System.out.println(i);
            adj.add(new ArrayList<Integer>());
        }
        int vis[]=new int[V];
        for(int i=0;i<V;i++){
            vis[i]=0;
        }
        for(int i=0;i<edges.length;i++){
            System.out.println("::"+edges[i][0]);
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        for(int i=0;i<adj.size();i++){
            if(vis[i]==0){
                dfs(i,adj,vis,topoSorted);
            }
        }
        return topoSorted;
    }

    public static ArrayList<Integer> topoSortKahnAlgo(int V, int[][] edges) {
        // code here
        int inDegree[] = new int[V];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[] : edges){
            adj.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            Integer val = queue.poll();
            list.add(val);
            for(int adjNode : adj.get(val)){
                --inDegree[adjNode];
                if(inDegree[adjNode]==0){
                    queue.add(adjNode);
                }
            }
        }
        return list;


    }

    public static void main(String[] args) {

        int arr[][]={{1, 3}, {2, 3}, {4, 1}, {4, 0}, {5, 0}, {5,2}};
        ArrayList<Integer> topoSorted = topoSort(6,arr);

        for(Integer topVal : topoSorted){
            System.out.println(topVal);
        }
    }
}
