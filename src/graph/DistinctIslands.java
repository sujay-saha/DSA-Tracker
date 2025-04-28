package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DistinctIslands {

    void dfs(int row, int col, int[][] grid, int[][] vis, List<String> islands, int row0, int col0){
        vis[row][col]=1;
        islands.add(toString(row-row0,col-col0));
        int m= grid.length;
        int n = grid[0].length;

        int drow[]={0,1,0,-1};// right down left  up
        int dcol[]={1,0,-1,0};
        for(int i =0;i<drow.length;i++){
            int nrow = row+drow[i];
            int ncol = col+dcol[i];
            if(nrow>=0 && nrow <m && ncol>=0 && ncol<n && grid[nrow][ncol]==1){
                if(vis[nrow][ncol] == 0){
                    dfs(nrow,ncol,grid,vis,islands,row0,col0);
                }
            }
        }
    }

    String toString(int row, int col){
        return Integer.toString(row)+" "+Integer.toString(col);
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int m= grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];

        List<String> islands;
        HashSet<List<String>> distinctIslands = new HashSet<>();

        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                vis[i][j]=0;
            }
        }
        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    islands = new ArrayList<>();
                    dfs(i,j,grid,vis,islands,i,j);

                    distinctIslands.add(islands );
                }
            }
        }
        return distinctIslands.size();
    }

}
