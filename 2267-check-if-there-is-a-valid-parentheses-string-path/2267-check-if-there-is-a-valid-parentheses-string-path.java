class Solution {

    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // A valid parentheses string must have even length
        if (((m + n - 1) & 1) != 0)
            return false;

        // First character must be '('
        if (grid[0][0] == ')')
            return false;

        // Last character must be ')'
        if (grid[m - 1][n - 1] == '(')
            return false;

        Boolean[][][] dp = new Boolean[m][n][m + n];

        return dfs(grid, 0, 0, 0, dp);
    }

    private boolean dfs(
            char[][] grid,
            int r,
            int c,
            int balance,
            Boolean[][][] dp) {

        // Current cell
        if (grid[r][c] == '(')
            balance++;
        else
            balance--;

        // Invalid prefix
        if (balance < 0)
            return false;

        // Not enough cells remaining to close all '('
        int remaining =
                (grid.length - 1 - r) +
                (grid[0].length - 1 - c);

        if (balance > remaining)
            return false;

        // Reached destination
        if (r == grid.length - 1 &&
            c == grid[0].length - 1) {

            return balance == 0;
        }

        if (dp[r][c][balance] != null)
            return dp[r][c][balance];

        boolean ans = false;

        // Down
        if (r + 1 < grid.length) {
            ans |= dfs(grid, r + 1, c, balance, dp);
        }

        // Right
        if (!ans && c + 1 < grid[0].length) {
            ans |= dfs(grid, r, c + 1, balance, dp);
        }

        return dp[r][c][balance] = ans;
    }
}