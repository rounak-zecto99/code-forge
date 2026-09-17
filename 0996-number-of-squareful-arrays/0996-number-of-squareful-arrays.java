class Solution {
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        boolean[][] adj = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                int root = (int) Math.sqrt(sum);

                if (root * root == sum) {
                    adj[i][j] = true;
                    adj[j][i] = true;
                }
            }
        }

        return backtrack(nums, adj, new boolean[n], 0, -1);
    }

    private int backtrack(int[] nums, boolean[][] adj,
                          boolean[] used, int count, int prev) {

        if (count == nums.length)
            return 1;

        int ways = 0;

        for (int i = 0; i < nums.length; i++) {

            if (used[i])
                continue;

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;

            if (prev != -1 && !adj[prev][i])
                continue;

            used[i] = true;

            ways += backtrack(nums, adj, used, count + 1, i);

            used[i] = false;
        }

        return ways;
    }
}