class Tuple {
    int row;
    int col;

    Tuple(int r, int c) {
        this.row = r;
        this.col = c;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<Tuple> q = new ArrayDeque<>();

        int top = 0;
        int right = n - 1;

        for (int i = 0; i < n; i++) {
            if (grid[top][i] == 1) {
                grid[top][i] = 0;
                q.offer(new Tuple(top, i));
            }
        }
        ++top;

        for (int j = top; j < m; j++) {
            if (grid[j][right] == 1) {
                grid[j][right] = 0;
                q.offer(new Tuple(j, right));
            }
        }
        --right;

        for (int j = right; j >= 0; j--) {
            if (grid[m - 1][j] == 1) {
                grid[m - 1][j] = 0;
                q.offer(new Tuple(m - 1, j));
            }
        }
        for (int i = m - 2; i >= top; i--) {
            if (grid[i][0] == 1) {
                grid[i][0] = 0;
                q.offer(new Tuple(i, 0));
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            Tuple cur = q.poll();
            int row = cur.row;
            int col = cur.col;

            if (row > 0 && grid[row - 1][col] == 1) {
                grid[row - 1][col] = 0;
                q.offer(new Tuple(row - 1, col));
            }

            if (row + 1 < m && grid[row + 1][col] == 1) {
                grid[row + 1][col] = 0;
                q.offer(new Tuple(row + 1, col));
            }

            if (col > 0 && grid[row][col - 1] == 1) {
                grid[row][col - 1] = 0;
                q.offer(new Tuple(row, col - 1));
            }

            if (col + 1 < n && grid[row][col + 1] == 1) {
                grid[row][col + 1] = 0;
                q.offer(new Tuple(row, col + 1));
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1)
                count++;
            }
        }
        // System.out.println(Arrays.deepToString(grid));
        return count;
    }
}