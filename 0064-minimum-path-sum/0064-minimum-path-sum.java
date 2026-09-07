class Solution {
    public int minPathSum(int[][] grid) {
        int [][] dp = new int[grid.length][grid[0].length];
        for(int[]ar:dp)
        Arrays.fill(ar,-1);

        return helper(grid, grid.length - 1, grid[0].length - 1,dp);
    }

    public int helper(int[][] grid, int m, int n, int [][] dp) {

        if (m == 0 && n == 0) {
            return grid[0][0];
        }
        if(dp[m][n]!=-1)
        return dp[m][n];

        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;

        if (m > 0) {
            up = helper(grid, m - 1, n,dp);
        }

        if (n > 0) {
            left = helper(grid, m, n - 1,dp);
        }

        return dp[m][n] = grid[m][n] + Math.min(up, left);
    }
}