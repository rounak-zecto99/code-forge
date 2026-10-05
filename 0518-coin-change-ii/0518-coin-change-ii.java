class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int bal = 0; bal <= amount; bal++) {
            if (bal % coins[0] == 0) {
                dp[0][bal] = 1;
            }
        }

        for (int index = 1; index < n; index++) {
            for (int coin = 0; coin <= amount; coin++) {
                dp[index][coin] = dp[index - 1][coin];

                if (coin >= coins[index])
                dp[index][coin] += dp[index][coin - coins[index]];
            }
        }
        return dp[n-1][amount];

        // return helper(coins, amount, coins.length - 1);
    }

    int helper(int[] coins, int balance, int index) {

        if (balance == 0)
            return 1;

        if (index == 0) {
            if (balance % coins[0] == 0)
                return 1;

            return 0;
        }
        int ways = 0;

        ways += helper(coins, balance, index - 1);

        if (balance >= coins[index])
            ways += helper(coins, balance - coins[index], index);

        return ways;
    }
}