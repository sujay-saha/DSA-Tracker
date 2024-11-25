public class NumberOfProvinces {
    /*547. Number of Provinces
Medium
Topics
Companies
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

Link: https://leetcode.com/problems/number-of-provinces/description/ Submitted on Leetcode*/
    public static void main(String[] args) {
        System.out.println("Number of Provinces: "+findCircleNum(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));
    }


    public static int findCircleNum(int[][] isConnected) {
        int count = 0;

        boolean vis[] = new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            if(!vis[i]){
                dfs(i,vis,isConnected);
                count++;
            }
        }
        return count;
    }

    static void dfs(int val, boolean vis[],int[][] isConnected){
        vis[val] = true;
        for(int i =0;i<isConnected[val].length;i++){
            int neighbour = isConnected[val][i];
            if(neighbour==1){
                if(!vis[i]){
                    dfs(i,vis,isConnected);
                }
            }
        }
    }
}
