class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        int[][] dp = new int[n + 1][n + 1];
        boolean[][] take = new boolean[n][n + 1];

        // Bottom-up calculation
        for (int i = n - 1; i >= 0; i--) {

            for (int prev = -1; prev < i; prev++) {

                int skip = dp[i + 1][prev + 1];

                int pick = 0;

                if (prev == -1 || nums[i] % nums[prev] == 0) {
                    pick = 1 + dp[i + 1][i + 1];
                }

                if (pick > skip) {
                    dp[i][prev + 1] = pick;
                    take[i][prev + 1] = true;
                } else {
                    dp[i][prev + 1] = skip;
                }
            }
        }

        // Reconstruct the subset
        List<Integer> ans = new ArrayList<>();

        int prev = -1;

        for (int i = 0; i < n; i++) {

            if (take[i][prev + 1]) {
                ans.add(nums[i]);
                prev = i;
            }
        }

        return ans;
    }
}