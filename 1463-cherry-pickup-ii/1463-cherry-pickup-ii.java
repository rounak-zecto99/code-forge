class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][][] dp = new int[rows][cols][cols];

        for (int[][] a : dp) {
            for (int[] ar : a) {
                Arrays.fill(ar, -1);
            }
        }

        return helper(grid, 0, 0, cols - 1, dp);
    }

    int helper(int[][] grid, int rows, int cols1, int cols2, int[][][] dp) {

        if (cols1 < 0 || cols2 < 0 || cols1 >= grid[0].length || cols2 >= grid[0].length)
            return 0;

        if (rows == grid.length - 1) {
            if (cols1 == cols2)
                return grid[rows][cols1];

            return grid[rows][cols1] + grid[rows][cols2];
        }
        int best = 0;

        if (dp[rows][cols1][cols2] != -1)
            return dp[rows][cols1][cols2];

        for (int move1 = -1; move1 < 2; move1++) {
            for (int move2 = -1; move2 < 2; move2++) {

                int newCol1 = cols1 + move1;
                int newCol2 = cols2 + move2;

                best = Math.max(best, helper(grid, rows + 1, newCol1, newCol2, dp));
            }
        }
        if (cols1 == cols2)
            return dp[rows][cols1][cols2] = grid[rows][cols1] + best;

        return dp[rows][cols1][cols2] = grid[rows][cols1] + grid[rows][cols2] + best;

    }
}