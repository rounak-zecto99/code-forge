class Solution {
    public int climbStairs(int n, int[] costs) {

        int inf = (int) 1e9;

        int prev1 = 0;   // dp[i-1]
        int prev2 = inf; // dp[i-2]
        int prev3 = inf; // dp[i-3]

        for (int i = 1; i <= n; i++) {

            int cur = costs[i - 1] + Math.min(
                prev1 + 1,
                Math.min(prev2 + 4, prev3 + 9)
            );

            prev3 = prev2;
            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }
}