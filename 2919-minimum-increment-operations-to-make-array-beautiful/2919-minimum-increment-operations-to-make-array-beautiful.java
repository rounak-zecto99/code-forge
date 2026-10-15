class Solution {
    int n;
    long[] dp;

    long solve(int ind, int[] nums, int k) {
        if (ind > n - 3) {
            return 0;
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        long op1 = Math.max(0, k - nums[ind]) + solve(ind + 1, nums, k);

        long op2 = Math.max(0, k - nums[ind + 1]) + solve(ind + 2, nums, k);

        long op3 = Math.max(0, k - nums[ind + 2]) + solve(ind + 3, nums, k);

        return dp[ind] = Math.min(op1, Math.min(op2, op3));
    }

    public long minIncrementOperations(int[] nums, int k) {
        n = nums.length;
        dp = new long[n];
        Arrays.fill(dp, -1);

        return solve(0, nums, k);
    }
}