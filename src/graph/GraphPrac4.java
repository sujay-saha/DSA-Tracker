package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphPrac4 {

    public static void main(String[] args) {

    }

    //Course Schedule I
    public boolean canFinishUsingDFS(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        boolean vis[]= new boolean[numCourses];
        List<List<Integer>> adj= new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                boolean inRecursion[]= new boolean[numCourses];
                if(!dfs(i,vis,adj,inRecursion)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int node, boolean vis[],List<List<Integer>> adj,boolean inRecursion[] ){
        vis[node]=true;
        inRecursion[node]=true;
        for(int neighbour:adj.get(node)){
            if(inRecursion[neighbour]){
                return false;
            }
            if(!vis[neighbour]){
                if(!dfs(neighbour,vis,adj,inRecursion)){
                    return false;
                }
            }
        }
        inRecursion[node]=false;

        return true;
    }



}
