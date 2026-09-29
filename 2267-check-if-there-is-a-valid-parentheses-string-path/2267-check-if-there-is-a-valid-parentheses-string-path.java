class Solution {
    public boolean hasValidPath(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        if (grid[row - 1][col - 1] == '(')
            return false;

         if (((row + col - 1) & 1) != 0)
            return false;

        Boolean [][][] dp = new Boolean[row][col][row+col-1];

        return helper(grid, 0, 0, 0, dp);

    }

    boolean helper(char[][] grid, int row, int col, int stack, Boolean [][][] dp) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            if (stack == 0)
                return false;

            --stack;

            return stack == 0;
        }

        char cur = grid[row][col];

        if (cur == ')') {
            if (stack == 0) {
                return dp[row][col][stack] = false;
            } else {
                --stack;
            }
        } else {
            ++stack;
        }

        if(dp[row][col][stack] != null)
        return dp[row][col][stack];

        if (row < grid.length - 1 && helper(grid, row + 1, col, stack,dp)) {
            return dp[row][col][stack] = true;
        }

        if (col < grid[0].length - 1 && helper(grid, row, col + 1, stack, dp)) {
            return dp[row][col][stack] = true;
        }

        return dp[row][col][stack] = false;
    }
}