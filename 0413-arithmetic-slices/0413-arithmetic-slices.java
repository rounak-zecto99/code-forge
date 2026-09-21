class Solution {
    static int INF = Integer.MAX_VALUE;

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;

        if (n < 3)
            return 0;

        int left = 0;
        int prev = nums[1] - nums[0];

        int count = 0;

        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];

            if (prev == diff) {
                count += Math.max(i - left - 1, 0);
            } else {
                left = i-1;
                prev = diff;
            }
        }
        return count;
    }
}