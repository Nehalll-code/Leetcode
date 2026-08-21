class Solution {
    public void dfs(int i,int j,boolean[][]vis,char[][]board,int n,int m){
        if(i>=n||j>=m||i<0||j<0||board[i][j]=='X' || vis[i][j]){
            return;
        }
        vis[i][j] = true;
        dfs(i-1,j,vis,board,n,m); //top
        dfs(i,j+1,vis,board,n,m); //right
        dfs(i+1,j,vis,board,n,m); //bottom
        dfs(i,j-1,vis,board,n,m); //left
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];
        // Top and bottom rows
        for(int j = 0; j < m; j++) {

            if(board[0][j] == 'O') {
                dfs(0, j, vis, board, n, m);
            }

            if(board[n-1][j] == 'O') {
                dfs(n-1, j, vis, board, n, m);
            }
        }
        // Left and right columns
        for(int i = 0; i < n; i++) {

            if(board[i][0] == 'O') {
                dfs(i, 0, vis, board, n, m);
            }

            if(board[i][m-1] == 'O') {
                dfs(i, m-1, vis, board, n, m);
            }
        }
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O' && !vis[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
}