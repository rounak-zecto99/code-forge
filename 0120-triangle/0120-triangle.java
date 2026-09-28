class Solution {
    int INF = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = triangle.get(row).get(col)
                        + Math.min(dp[col], dp[col + 1]);
            }
        }

        return dp[0];
    }

    // int helper(List<List<Integer>> triangle, int row, int col, int[][] dp) {

    //     if (row == triangle.size() - 1) {
    //         return triangle.get(row).get(col);
    //     }
    //     if (dp[row][col] != INF)
    //         return dp[row][col];

    //     int way1 = helper(triangle, row + 1, col,dp);
    //     int way2 = helper(triangle, row + 1, col + 1,dp);

    //     return dp[row][col] = triangle.get(row).get(col) + Math.min(way1,way2);

    // }
}