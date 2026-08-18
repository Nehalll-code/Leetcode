class Solution {
    public int orangesRotting(int[][] grid) {
        int min = 0;
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];

        //{row,col,time}
        Queue<int[]> q = new LinkedList<>();

        //pushing all the rotten into the queue
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j,0}); //rotten already present at time 0 so i,j,0\
                    vis[i][j] = true;
                }
            }
        }
        int maxT= 0;
        while(!q.isEmpty()){
            int[] curr = q.poll();

            int i = curr[0];
            int j = curr[1];
            int time = curr[2];

            maxT = Math.max(maxT,time);

            //left
            if(j-1 >= 0 && !vis[i][j-1] && grid[i][j-1] == 1){
                q.add(new int[]{i,j-1,time+1});
                vis[i][j-1] = true;
            }
            //right
            if(j+1 <m && !vis[i][j+1] && grid[i][j+1] == 1){
                q.add(new int[]{i,j+1,time+1});
                vis[i][j+1] = true;
            }
            //up
            if(i-1 >= 0 && !vis[i-1][j] && grid[i-1][j] == 1){
                q.add(new int[]{i-1,j,time+1});
                vis[i-1][j] = true;
            }
            //down
            if(i+1 < n && !vis[i+1][j] && grid[i+1][j] == 1){
                q.add(new int[]{i+1,j,time+1});
                vis[i+1][j] = true;
            }
        }
        //if any fresh oranges are left
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    return -1;
                }
            }
        }
        return maxT;
    }
}