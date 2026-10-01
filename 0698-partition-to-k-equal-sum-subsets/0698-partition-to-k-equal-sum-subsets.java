class Solution {
    int[] nums;
    int n;
    int target;
    Boolean[] dp;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        n = nums.length;

        int total = 0;

        for (int x : nums) {
            total += x;
        }

        if (total % k != 0) {
            return false;
        }

        target = total / k;

        dp = new Boolean[1 << n];

        return helper(0, 0);
    }

    boolean helper(int mask, int currSum) {

        if (mask == (1 << n) - 1) {
            return true;
        }

        if (dp[mask] != null) {
            return dp[mask];
        }

        if (currSum == target) {
            return dp[mask] = helper(mask, 0);
        }

        for (int i = 0; i < n; i++) {

            if ((mask & (1 << i)) != 0) {
                continue;
            }

            int newSum = currSum + nums[i];

            if (newSum > target) {
                continue;
            }

            int newMask = mask | (1 << i);

            if (helper(newMask, newSum)) {
                return dp[mask] = true;
            }
        }

        return dp[mask] = false;
    }
}