class Solution {
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int index = 0; index < coins.length; index++) {

            for (int coin = coins[index]; coin <= amount; coin++) {

                dp[coin] += dp[coin - coins[index]];
            }
        }

        return dp[amount];
    }
}