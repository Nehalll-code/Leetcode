class Solution {
    public int countBattleships(char[][] board) {

        int n = board.length;       // rows
        int m = board[0].length;    // columns
        int ships = 0;

        Queue<int[]> q = new LinkedList<>();

        if (n <= 0 || m <= 0) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 'X') {

                    ships++;

                    q.offer(new int[]{i, j});
                    board[i][j] = '.';

                    while (!q.isEmpty()) {

                        int[] curr = q.poll();

                        int r = curr[0];
                        int c = curr[1];

                        // DOWN
                        if (r + 1 < n && board[r + 1][c] == 'X') {
                            board[r + 1][c] = '.';
                            q.offer(new int[]{r + 1, c});
                        }

                        // UP
                        if (r - 1 >= 0 && board[r - 1][c] == 'X') {
                            board[r - 1][c] = '.';
                            q.offer(new int[]{r - 1, c});
                        }

                        // RIGHT
                        if (c + 1 < m && board[r][c + 1] == 'X') {
                            board[r][c + 1] = '.';
                            q.offer(new int[]{r, c + 1});
                        }

                        // LEFT
                        if (c - 1 >= 0 && board[r][c - 1] == 'X') {
                            board[r][c - 1] = '.';
                            q.offer(new int[]{r, c - 1});
                        }
                    }
                }
            }
        }

        return ships;
    }
}