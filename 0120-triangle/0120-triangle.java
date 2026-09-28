class Solution {
    int INF = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int lastRow = triangle.get(n - 1).size();
        int[][] dp = new int[n][lastRow];

        for (int[] ar : dp)
            Arrays.fill(ar, INF);

        return helper(triangle, 0, 0, dp);
    }

    int helper(List<List<Integer>> triangle, int row, int col, int[][] dp) {
        
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        if (dp[row][col] != INF)
            return dp[row][col];

        int way1 = helper(triangle, row + 1, col,dp);
        int way2 = helper(triangle, row + 1, col + 1,dp);

        return dp[row][col] = triangle.get(row).get(col) + Math.min(way1,way2);

    }
}