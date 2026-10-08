class Solution {

    int[][] dp;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return helper(nums, 0, -1);
    }

    int helper(int[] nums, int index, int prev) {

        if (index == nums.length)
            return 0;

        if (dp[index][prev + 1] != -1)
            return dp[index][prev + 1];


        int noTake = helper(nums, index + 1, prev);

        int take = 0;

        if (prev == -1 || nums[index] > nums[prev]) {
            take = 1 + helper(nums, index + 1, index);
        }

        return dp[index][prev + 1] = Math.max(noTake, take);
    }
}