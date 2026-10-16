class Solution {
    public int findShortestSubArray(int[] nums) {
        int[][] hash = new int[50000][3];

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            hash[n][0]++;

            if (hash[n][1] == 0) {
                hash[n][1] = i + 1;
            }
            hash[n][2] = i + 1;
        }
        int ans = 0;
        int len = Integer.MAX_VALUE;

        for (int x : nums) {
            if (hash[x][0] > ans) {
                ans = Math.max(ans, hash[x][0]);
                len = hash[x][2] - hash[x][1] + 1;
            } else if (hash[x][0] == ans) {
                len = Math.min(len, hash[x][2] - hash[x][1] + 1);
            }
        }
        return len;
    }
}