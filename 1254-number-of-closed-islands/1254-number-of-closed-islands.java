class Solution {

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0 && bfs(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    boolean bfs(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        grid[row][col] = 1;

        q.offer(new int[] { row, col });

        int[] dr = { -1, 0, 0, 1 };
        int[] dc = { 0, -1, 1, 0 };

        boolean verdict = true;

        while (!q.isEmpty()) {

            int nr = q.peek()[0];
            int nc = q.peek()[1];

            q.poll();

            for (int i = 0; i < 4; i++) {
                int newR = nr + dr[i];
                int newC = nc + dc[i];

                if (grid[newR][newC] == 1)
                    continue;

                if (newR == 0 || newC == 0 || newR == m - 1 || newC == n - 1) {
                    verdict = false;
                    continue;
                }
                grid[newR][newC] = 1;
                q.offer(new int[] { newR, newC });
            }

        }
        return verdict;
    }
}