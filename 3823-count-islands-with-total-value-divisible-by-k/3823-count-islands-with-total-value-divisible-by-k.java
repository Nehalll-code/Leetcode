class Solution {
    public long dfs(int i,int j,int grid[][],int n,int m ){
        if(i>=n || j>=m || i<0||j<0 || grid[i][j] == 0){
            return 0;
        }
        long sum = grid[i][j];
        grid[i][j] = 0;

        //explore other directions
        sum+=dfs(i-1,j,grid,n,m); //top
        sum+=dfs(i,j+1,grid,n,m); //right
        sum+=dfs(i+1,j,grid,n,m); //bottom
        sum+=dfs(i,j-1,grid,n,m); //left

        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int count =0;

        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] > 0){
                    long sum = dfs(i,j,grid,n,m);

                    if(k>0 && sum%k == 0){
                        count++;
                    }
                }                
            }
        }
        return count;
    }
}