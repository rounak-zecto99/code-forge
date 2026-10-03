class Solution {
    int INF = 1000_000_000;

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for (int coin = 0; coin <= amount; coin++) {
            if (coin % coins[0] == 0) {
                dp[0][coin] = coin / coins[0];
            } else {
                dp[0][coin] = INF;
            }
        }

        for (int index = 1; index < n; index++) {
            for (int coin = 0; coin <= amount; coin++) {
                int NoTake = dp[index - 1][coin];
                int Take = INF;

                if (coin >= coins[index])
                    Take = 1 + dp[index][coin - coins[index]];

                dp[index][coin] = Math.min(NoTake, Take);
            }
        }

        int max = dp[n - 1][amount];
        return max == INF ? -1 : max;
    }
}