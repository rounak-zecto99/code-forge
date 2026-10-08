class Solution {
    static final int MOD = 1_000_000_007;

    public int countPartitions(int[] nums, int k) {
        long total = 0;

        for (int x : nums) {
            total += x;
        }

        if (total < 2L * k) {
            return 0;
        }

        // dp[s] = number of subsets with sum s
        long[] dp = new long[k];
        dp[0] = 1;

        for (int x : nums) {
            for (int s = k - 1; s >= x; s--) {
                dp[s] = (dp[s] + dp[s - x]) % MOD;
            }
        }

        // Number of subsets having sum < k
        long invalid = 0;

        for (int s = 0; s < k; s++) {
            invalid = (invalid + dp[s]) % MOD;
        }

        // Total ways to assign each element to either group
        long totalWays = 1;

        for (int i = 0; i < nums.length; i++) {
            totalWays = totalWays * 2 % MOD;
        }

        // Remove cases where either group has sum < k
        long answer = (totalWays - 2 * invalid) % MOD;

        if (answer < 0) {
            answer += MOD;
        }

        return (int) answer;
    }
}