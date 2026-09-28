class Solution {
    int INF = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for(int j=0; j<n; j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for(int row = n-2; row >=0; row--){
            for(int col = row; col >=0; col--){
                int optionA = dp[row+1][col];
                int optionB = dp[row+1][col+1];

                dp[row][col] = triangle.get(row).get(col) + Math.min(optionA,optionB);
            }
        }
        return dp[0][0];
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