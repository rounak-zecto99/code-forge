class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {

            for (int prev = i - 1; prev >= -1; prev--) {

                // Skip current element
                int skip = dp[i + 1][prev + 1];

                // Take current element
                int take = 0;

                if (prev == -1 || nums[i] % nums[prev] == 0) {
                    take = 1 + dp[i + 1][i + 1];
                }

                dp[i][prev + 1] = Math.max(skip, take);
            }
        }

        // Reconstruct the answer
        List<Integer> ans = new ArrayList<>();

        int prev = -1;

        for (int i = 0; i < n; i++) {

            int skip = dp[i + 1][prev + 1];

            int take = 0;

            if (prev == -1 || nums[i] % nums[prev] == 0) {
                take = 1 + dp[i + 1][i + 1];
            }

            if (take >= skip && take > 0) {
                ans.add(nums[i]);
                prev = i;
            }
        }

        return ans;
    }
}