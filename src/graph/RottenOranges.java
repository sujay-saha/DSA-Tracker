package graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int vis[][] = new int[n][m];
        int freshOranges = 0;
        Queue<Pair> queue = new LinkedList<Pair>();
        for(int i = 0; i< n;i++){
            for(int j = 0; j< m;j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1){
                    ++freshOranges;
                }
            }
        }
        int time = 0, counter=0;
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        while(!queue.isEmpty()){
            Integer row = queue.peek().row;
            Integer col = queue.peek().column;
            Integer t = queue.peek().time;
            time = Integer.max(t,time);
            queue.poll();
            for(int i=0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow >=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]!=2 && grid[nrow][ncol]==1){
                    queue.add(new Pair(nrow,ncol,time+1));
                    vis[nrow][ncol]=2;
                    ++counter;
                }
            }

        }
        if(counter != freshOranges){
            return -1;
        }
        return time;
    }

}

class Pair {
    int row, column, time;

    Pair(int row, int column, int time) {
        this.row = row;
        this.column = column;
        this.time = time;
    }
}
