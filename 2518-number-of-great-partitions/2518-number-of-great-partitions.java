class Solution {
    static final int MOD = 1_000_000_007;

    public int countPartitions(int[] nums, int k) {
        long totalSum = 0;
        long totalWays = 1;

        // dp[s] = number of subsets with sum exactly s,
        // only for s < k
        long[] dp = new long[k];
        dp[0] = 1;

        for (int x : nums) {
            totalSum += x;

            // 0/1 subset sum: iterate backwards
            for (int sum = k - 1 - x; sum >= 0; sum--) {
                dp[sum + x] = (dp[sum + x] + dp[sum]) % MOD;
            }

            // Every element can either belong to subset A or B
            totalWays = (totalWays * 2) % MOD;
        }

        // Remove invalid partitions
        for (int sum = 0; sum < k; sum++) {

            // If this subset has sum < k,
            // the other subset has sum >= k, assuming totalSum >= 2k.
            //
            // If the other subset also has sum < k,
            // this subset was counted from BOTH sides.
            if (totalSum - sum < k) {
                totalWays -= dp[sum];
            } else {
                totalWays -= 2 * dp[sum];
            }

            totalWays %= MOD;
        }

        if (totalWays < 0) {
            totalWays += MOD;
        }

        return (int) totalWays;
    }
}