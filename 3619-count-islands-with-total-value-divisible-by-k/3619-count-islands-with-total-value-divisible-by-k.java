class Solution {
    int[] dr = { -1, 0, 1, 0 };
    int[] dc = { 0, -1, 0, 1 };

    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;
        long sum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    sum = dfs(grid, i, j);

                    // System.out.println(sum);

                    if (sum % k == 0)
                        ans++;
                }
            }
        }
        return ans;
    }

    long dfs(int[][] grid, int r, int c) {
        long sum = 0;

        sum += grid[r][c];
        grid[r][c] = 0;

        for(int i=0; i<4; i++){
            int nrow = r + dr[i];
            int ncol = c + dc[i];

            if(nrow >=0 && nrow < grid.length  && ncol >=0 &&
             ncol < grid[0].length && grid[nrow][ncol] != 0){
                sum += dfs(grid,nrow,ncol);
            }
        }
        return sum;
    }
}