class Solution {
    static int[] squares;
    static {
        squares = new int[100];

        for (int i = 1; i <= 100; i++) {
            squares[i - 1] = i * i;
        }
    }

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = helper(n,dp);

        if(ans == Integer.MAX_VALUE)
        return -1;

        return ans;
    }

    public int helper(int n, int[] dp) {
        if (n == 0)
            return 0;

        if (n < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[n] != -1)
            return dp[n];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 100; i++) {
            int res = helper(n - squares[i],dp);

            if (res != Integer.MAX_VALUE) {
                res = res + 1;
                min = Math.min(res, min);
            }
        }
        return dp[n] = min;
    }
}