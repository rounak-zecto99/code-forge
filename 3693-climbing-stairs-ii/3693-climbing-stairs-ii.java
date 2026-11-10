class Solution {
    int inf = (int) 1e9;
    int[] dp;

    public int climbStairs(int n, int[] costs) {
        dp = new int[costs.length + 1];
        Arrays.fill(dp, -1);

        return helper(costs, 0);
    }

    public int helper(int[] costs, int index) {

        if (index == costs.length) return 0;

        if (dp[index] != -1) return dp[index];

        int ans = inf;

        for (int i = 1; i <= 3; i++) {
            if (index + i <= costs.length) {
                ans = Math.min(ans,
                    costs[index + i - 1] + i * i
                    + helper(costs, index + i));
            }
        }

        return dp[index] = ans;
    }
}