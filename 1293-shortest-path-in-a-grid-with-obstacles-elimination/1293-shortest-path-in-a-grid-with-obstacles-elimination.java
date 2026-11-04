class Solution {

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public int shortestPath(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        if (k >= m + n - 3)
            return m + n - 2;

        int[][] vis = new int[m][n];

        Queue<Integer> q = new ArrayDeque<>();

        // Encode (row, col, obstacles)
        q.offer(((0 << 12) | ((m - 1) << 6) | (n - 1)));

        vis[m - 1][n - 1] = 1;

        int dis = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int state = q.poll();

                int obstacles = state >> 12;
                int cr = (state >> 6) & 63;
                int cc = state & 63;

                if (cr == 0 && cc == 0)
                    return dis;

                for (int l = 0; l < 4; l++) {

                    int nr = cr + dr[l];
                    int nc = cc + dc[l];

                    if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                        continue;

                    int nObs = obstacles + grid[nr][nc];

                    if (nObs > k)
                        continue;

                    int encoded = nObs + 1;

                    if (vis[nr][nc] == 0 || encoded < vis[nr][nc]) {

                        vis[nr][nc] = encoded;

                        int nextState =
                                (nObs << 12) | (nr << 6) | nc;

                        q.offer(nextState);
                    }
                }
            }

            dis++;
        }

        return -1;
    }
}