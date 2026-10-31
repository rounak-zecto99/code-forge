class Solution {
    int[][][] dp;
    int MOD = 1000_000_007;

    public int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n][2];

        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        return  helper(grid, m - 1, n - 1, 1);
    }

    public int helper(int[][] grid, int m, int n, int last) {
        if (m < 0 || n < 0)
            return 0;

        if (m == 0 && n == 0)
            return 1;

        if (dp[m][n][last] != -1)
            return dp[m][n][last];

        if (grid[m][n] == 1) {
            return dp[m][n][last] = last == 1
                    ? helper(grid, m, n - 1, 0)
                    : helper(grid, m - 1, n, 1);
        }

        int ways = 0;

        if (m > 0) {
            ways += helper(grid, m - 1, n, 1);
        }

        if (n > 0) {
            ways += helper(grid, m, n - 1, 0);
        }

        return dp[m][n][last] = ways % MOD;
    }
}