class Solution {
    int INF = Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length - 1;
        int [][] dp = new int[n+1][n+1];

        for(int []ar : dp)
        Arrays.fill(ar,-2);

        int min = INF;

        for (int col = matrix.length - 1; col >= 0; col--) {
            min = Math.min(min, helper(matrix, n, col,dp));
        }
        return min;
    }

    public int helper(int[][] matrix, int row, int col,int[][]dp) {
        if (row == 0) {
            return matrix[row][col];
        }
        if(dp[row][col] != -2)
        return dp[row][col];

        int path1 = INF;
        int path2 = INF;
        int path3 = INF;

        if (col > 0) {
            path1 = helper(matrix, row - 1, col - 1,dp);
        }
        if (col < matrix.length - 1) {
            path2 = helper(matrix, row - 1, col + 1,dp);
        }
        path3 = helper(matrix, row - 1, col,dp);

        return dp[row][col] = matrix[row][col] + Math.min(path1, Math.min(path2, path3));
    }
}