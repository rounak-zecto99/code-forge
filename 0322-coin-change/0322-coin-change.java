class Solution {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        Arrays.fill(dp,-2);

        if (amount == 0)
            return 0;

        int ans = helper(coins, amount,dp);

        if (ans == Integer.MAX_VALUE)
            return -1;

        return ans;
    }

    public int helper(int[] coins, int amount,int []dp) {

        if (amount == 0)
            return 0;

        if (amount < 0)
            return Integer.MAX_VALUE;

        if(dp[amount]!=-2)
        return dp[amount];

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {

            int res = helper(coins, amount - coins[i],dp);

            if (res != Integer.MAX_VALUE) {
                res = res + 1;
                min = Math.min(res, min);
            }
        }

        return dp[amount] = min;
    }
}