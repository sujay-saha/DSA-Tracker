package graph;

public class FloodFill {

        void dfs(int sr,int sc,int[][] image,int[][] vis, int origColor,int color){
            int m = image.length;
            int n = image[0].length;
            vis[sr][sc]=1;
            image[sr][sc]=color;
            int dRow[] = {-1,0,1,0};
            int dCol[] = {0,1,0,-1};
            for(int i =0;i<dRow.length;i++){
                int nRow = sr+dRow[i];
                int nCol = sc+dCol[i];

                if(nRow>=0 && nRow < m && nCol>=0 && nCol<n && vis[nRow][nCol]==0 && image[nRow][nCol]==origColor){
                    dfs(nRow,nCol,image,vis,origColor,color);
                }
            }
        }


        public int[][] floodFill(int[][] image, int sr, int sc, int color) {

            int m = image.length;
            int n = image[0].length;
            int vis[][] = new int[m][n];

            for(int i = 0; i<m;i++){
                for(int j=0;j<n;j++){
                    vis[i][j]=0;
                }
            }
            int[][] imageCopy = image;
            dfs(sr,sc,imageCopy,vis,image[sr][sc],color);
            return imageCopy;
        }

}
