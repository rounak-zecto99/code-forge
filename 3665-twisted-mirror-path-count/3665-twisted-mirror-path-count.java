class Solution {
    int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Stores dp[i-1][j][1]
        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {

            // Stores dp[i][j-1][0]
            int left = 0;

            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    prev[j] = 1;
                    left = 1;
                    continue;
                }

                int up = prev[j];

                if (grid[i][j] == 1) {
                    // Mirror: direction changes
                    int downState = left;
                    int rightState = up;

                    prev[j] = downState;
                    left = rightState;

                } else {
                    // Empty cell: both directions have same ways
                    int ways = (up + left) % MOD;

                    prev[j] = ways;
                    left = ways;
                }
            }
        }

        return prev[n - 1];
    }
}