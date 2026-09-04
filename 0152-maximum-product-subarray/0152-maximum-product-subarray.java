class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        // dp[i][0] = max product starting at i
        // dp[i][1] = min product starting at i
        int[][] dp = new int[n][2];

        // Base case: same as recursion
        dp[n - 1][0] = nums[n - 1];
        dp[n - 1][1] = nums[n - 1];

        int best = nums[n - 1];

        // Same as recursive calls returning backwards
        for (int i = n - 2; i >= 0; i--) {

            int a = nums[i];               // stop here
            int b = nums[i] * dp[i + 1][0]; // use next max
            int c = nums[i] * dp[i + 1][1]; // use next min

            dp[i][0] = Math.max(a, Math.max(b, c));
            dp[i][1] = Math.min(a, Math.min(b, c));

            best = Math.max(best, dp[i][0]);
        }

        return best;
    }
}