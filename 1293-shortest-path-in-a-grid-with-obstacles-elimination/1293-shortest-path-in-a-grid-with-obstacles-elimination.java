class Pair {
    int row;
    int col;
    int obstacles;

    Pair(int row, int col, int obstacles) {
        this.row = row;
        this.col = col;
        this.obstacles = obstacles;
    }
}

class Solution {

    int[] dr = { -1, 0, 1, 0 };
    int[] dc = { 0, 1, 0, -1 };

    public int shortestPath(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        if (k >= m + n - 3)
            return m + n - 2;

        int [][] vis = new int[m][n];

        // for(int [] ar : vis){
        //     Arrays.fill(ar,(int) 1e9);
        // }

        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(m - 1, n - 1, 0));
        vis[m - 1][n - 1] = 1;

        int dis = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {

                int cr = q.peek().row;
                int cc = q.peek().col;

                int obstacles = q.peek().obstacles;

                q.poll();

                if (obstacles > k)
                    continue;

                if (cr == 0 && cc == 0)
                    return dis;

                for (int l = 0; l < 4; l++) {

                    int nr = cr + dr[l];
                    int nc = cc + dc[l];


                    if (nr < 0 || nc < 0 || nr >= m || nc >= n) {
                        continue;
                    }

                    int nObs = obstacles + grid[nr][nc];
                    int encoded = nObs + 1;

                    if (encoded < vis[nr][nc] || vis[nr][nc] == 0) {
                        vis[nr][nc] = encoded;
                        q.offer(new Pair(nr, nc, nObs));
                    }
                }
            }
            dis++;
        }
        return -1;
    }
}

// 0	Never visited
// 1	Visited using 0 obstacles
// 2	Visited using 1 obstacle
// 3	Visited using 2 obstacles