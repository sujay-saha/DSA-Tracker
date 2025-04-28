package graph;

public class SurroundedRegions {
    /*0 0-5
0-5 0
5 0-5
0-5 5*/
    void findConnectedZeroes(int row, int col, char[][] board,int[][] vis){

        vis[row][col]= 1;
        int m = board.length;
        int n = board[0].length;

        int dRow[]={-1,0,1,0};
        int dCol[]={0,1,0,-1};

        for(int i = 0; i<dRow.length;i++){
            int nRow = row+dRow[i];
            int nCol = col+dCol[i];

            if(nRow>=0 && nRow <m && nCol>=0 && nCol<n && vis[nRow][nCol]==0 && board[nRow][nCol]=='O'){
                findConnectedZeroes(nRow,nCol,board,vis);
            }
        }
    }

    public void solve(char[][] board) {

        char[][] boardCopy = board;
        int m = boardCopy.length;
        int n = boardCopy[0].length;
        int vis[][] = new int[m][n];

        for(int i =0;i<m;i++){
            for(int j = 0; j<n; j++){
                vis[i][j]=0;
            }
        }

        int dBoundary[] ={0,5};

        for(int i =0;i<n;i++)//row
        {
            if(vis[0][i]==0 && boardCopy[0][i]=='O'){
                findConnectedZeroes(0, i, boardCopy,vis);
            }

            if(vis[m-1][i]==0 && boardCopy[m-1][i]=='O'){
                findConnectedZeroes(m-1, i, boardCopy,vis);
            }
        }

        for(int i =0;i<m;i++)//col
        {
            if(vis[i][0]==0 && boardCopy[i][0]=='O'){
                findConnectedZeroes(i, 0, boardCopy,vis);
            }

            if(vis[i][n-1]==0 && boardCopy[i][n-1]=='O'){
                findConnectedZeroes(i, n-1, boardCopy,vis);
            }
        }

        for(int i =1;i<m-1;i++){
            for(int j = 1; j<n-1; j++){
                if(boardCopy[i][j] == 'O' && vis[i][j]==0){
                    boardCopy[i][j]='X';
                    vis[i][j]=1;
                }
            }
        }
        board = boardCopy;

    }
}
