class Solution {

    public int cherryPickup(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][][] dp = new int[rows][cols][cols];

        // Base case: last row
        for (int col1 = 0; col1 < cols; col1++) {
            for (int col2 = 0; col2 < cols; col2++) {

                if (col1 == col2) {
                    dp[rows - 1][col1][col2] = grid[rows - 1][col1];
                } else {
                    dp[rows - 1][col1][col2] =
                            grid[rows - 1][col1] +
                            grid[rows - 1][col2];
                }
            }
        }

        // Build upwards
        for (int row = rows - 2; row >= 0; row--) {

            for (int col1 = 0; col1 < cols; col1++) {

                for (int col2 = 0; col2 < cols; col2++) {

                    int best = 0;

                    // 9 combinations
                    for (int move1 = -1; move1 <= 1; move1++) {
                        for (int move2 = -1; move2 <= 1; move2++) {

                            int newCol1 = col1 + move1;
                            int newCol2 = col2 + move2;

                            if (newCol1 >= 0 && newCol1 < cols &&
                                newCol2 >= 0 && newCol2 < cols) {

                                best = Math.max(
                                    best,
                                    dp[row + 1][newCol1][newCol2]
                                );
                            }
                        }
                    }

                    // Current row's cherries
                    if (col1 == col2) {
                        dp[row][col1][col2] =
                                grid[row][col1] + best;
                    } else {
                        dp[row][col1][col2] =
                                grid[row][col1] +
                                grid[row][col2] +
                                best;
                    }
                }
            }
        }

        return dp[0][0][cols - 1];
    }
}