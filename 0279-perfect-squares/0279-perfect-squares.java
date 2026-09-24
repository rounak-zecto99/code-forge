class Solution {

    static int INF = 1_000_000_000;

    public int numSquares(int n) {

        int max = (int)Math.sqrt(n);

        int[] squares = new int[max];

        for (int i = 1; i <= max; i++) {
            squares[i - 1] = i * i;
        }

        int[][] dp = new int[max][n + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return helper(n, max - 1, squares, dp);
    }

    public int helper(int n, int index, int[] squares, int[][] dp) {

        if (index == 0)
            return n;

        if (dp[index][n] != -1)
            return dp[index][n];

        int notTake = helper(n, index - 1, squares, dp);

        int take = INF;

        if (squares[index] <= n) {
            take = 1 + helper(n - squares[index], index, squares, dp);
        }

        return dp[index][n] = Math.min(take, notTake);
    }
}