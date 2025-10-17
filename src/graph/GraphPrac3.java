package graph;

import java.util.ArrayList;

public class GraphPrac3 {

    public static void main(String[] args) {

    }

    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n=isConnected.length;
        int c= isConnected[0].length;
        int total=n*c;

        boolean vis[] = new boolean[total];
        for(int k=0;k<n;k++){
            adj.add(new ArrayList());
        }

        for(int i =0;i<n;i++){
            for(int j =0;j<c;j++){
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i])
            {
                dfs(i,adj,vis);
                count++;
            }
        }
        return count;
    }

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[]){
        vis[node]=true;

        for(int neighbour : adj.get(node)){
            if(!vis[neighbour]){
                dfs(neighbour,adj,vis);
            }
        }
    }

}
