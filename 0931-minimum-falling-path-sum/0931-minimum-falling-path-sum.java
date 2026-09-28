class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        int ans = Integer.MAX_VALUE;

        for (int col = 0; col < n; col++) {
            ans = Math.min(ans, helper(matrix, n - 1, col, dp));
        }

        return ans;
    }

    private int helper(int[][] matrix, int row, int col, int[][] dp) {
        if (row == 0)
            return matrix[0][col];

        if (dp[row][col] != Integer.MAX_VALUE)
            return dp[row][col];

        int min = helper(matrix, row - 1, col, dp);

        if (col > 0)
            min = Math.min(min, helper(matrix, row - 1, col - 1, dp));

        if (col < matrix.length - 1)
            min = Math.min(min, helper(matrix, row - 1, col + 1, dp));

        return dp[row][col] = matrix[row][col] + min;
    }
}