package graph;

import java.util.LinkedList;
import java.util.Queue;

public class NearestCellHaving1 {
    public int[][] nearest(int[][] grid) {
        // Code here
        int gridC[][] = grid;

        int m= grid.length;
        int n = grid[0].length;
        int nearest[][] = new int[m][n];
        int vis[][] = new int[m][n];
        Queue<Pair2> queue = new LinkedList<>();

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){

                if(gridC[i][j]==1){
                    queue.add(new Pair2(i,j,0));
                    vis[i][j]=1;
                    nearest[i][j]=0;
                }
                else{
                    vis[i][j]=0;
                    nearest[i][j]=-1;
                }
            }
        }

        while(!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            int count = queue.peek().count;
            queue.poll();

            nearest[r][c]=count;

            int dRow[] = {-1,0,1,0};
            int dCol[] = {0,1,0,-1};

            for(int i=0;i<dRow.length;i++){
                int nRow = r + dRow[i];
                int nCol = c + dCol[i];

                if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && vis[nRow][nCol]==0 )
                {
                    if(grid[nRow][nCol] == 0)
                    {
                        vis[nRow][nCol]=1;
                        queue.add(new Pair2(nRow,nCol,count+1));

                    }
                }

            }
        }
        return nearest;

    }
}

class Pair2{
    int row;
    int col;
    int count;

    Pair2(int row, int col, int count){
        this.row = row;
        this.col = col;
        this.count = count;
    }
}
