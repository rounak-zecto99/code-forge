class tuple {
    int row;
    int col;

    tuple(int r, int c) {
        this.row = r;
        this.col = c;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<tuple> q = new ArrayDeque<>();
        int fresh = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.offer(new tuple(i, j));
                }
            }
        }
        int time = 0;

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                tuple cur = q.poll();

                int row = cur.row;
                int col = cur.col;


                if (row > 0 && grid[row - 1][col] == 1){
                     grid[row - 1][col] = 2;
                    fresh--;
                    q.offer(new tuple(row - 1, col));
                }

                if (row + 1 < m && grid[row + 1][col] == 1){
                    grid[row + 1][col] = 2;
                    fresh--;
                    q.offer(new tuple(row + 1, col));
                }

                if (col > 0 && grid[row][col - 1] == 1){
                    grid[row][col-1] = 2;
                    fresh--;
                    q.offer(new tuple(row, col - 1));
                }

                if (col + 1 < n && grid[row][col + 1] == 1){
                    grid[row][col+1] = 2;
                    fresh--;
                    q.offer(new tuple(row, col + 1));
                }

            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}